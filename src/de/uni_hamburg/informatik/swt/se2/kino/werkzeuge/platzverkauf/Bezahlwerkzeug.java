package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bezahlwerkzeug {
	private boolean _sichtbarkeit;
	private BezahlwerkzeugUI _ui;
	private Integer _preis;

	public Bezahlwerkzeug() {
		_sichtbarkeit = false;
		_ui = new BezahlwerkzeugUI();
		_preis = 0;

		_ui.getEinzahlungsAnzeige().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rechneUndAktualisiereUI();
			}
		});// evtl. speziellerer Listerner

		_ui.getExitButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				beendeDialog();
			}
		});
	}

	/**
	 * Startet das Dialogfenster, indem es die Sichtbarkeit auf true setzt.
	 * Außerdem wird die Einzahlung auf 0 gesetzt und das Dialogfenster nach
	 * vorne gesetzt und aktualisiert.
	 */
	public void starteDialog() {
		_sichtbarkeit = true;
		// _ui.getEinzahlungsAnzeige().setText("0");
		rechneUndAktualisiereUI();
		_ui.setzeDichSichtbar();
	}

	/**
	 * Schließt das Dialogfenster, indem es unsichtbar wird.
	 */
	public void beendeDialog() {
		_sichtbarkeit = false;
		_ui.setzeDichUnsichtbar();
	}

	/**
	 * Setzt den Preis des Dialogfensters und ruft die Methode
	 * "rechneundaktualisiereUI" auf.
	 * 
	 * @param Der
	 *            zu bezahlende Preis
	 * @assert Preis größer oder gleich 0
	 */
	public void setzePreis(int preis) {
		assert preis >= 0 : "Preis kleiner als 0 Eurocent!";
		assert preis <= 999999 : "Preis größer als 999999 Eurocent!";
		_preis = preis;
		rechneUndAktualisiereUI();
	}

	private void rechneUndAktualisiereUI() {
		if (_sichtbarkeit) {			
			String EinzahlungsAnzeige = _ui.getEinzahlungsAnzeige().getText();
			EinzahlungsAnzeige = EinzahlungsAnzeige.replaceAll(",", "");
			EinzahlungsAnzeige = EinzahlungsAnzeige.replaceAll(" ", "");
			int Eingabe = Integer.parseInt(EinzahlungsAnzeige);
			
			Integer Ausgabe = _preis - Eingabe;
			
			if(Ausgabe<=0){
				_ui.getOKButton().setEnabled(true);
			}else{
				_ui.getOKButton().setEnabled(false);
			}
			
			String StringPreis = "";
			String StringAusgabe = "";
			
			if(_preis>99){
				StringPreis = new StringBuilder(_preis.toString()).insert(_preis.toString().length()-2, ",").toString();
			}else if(_preis>9 && _preis<=99){
				StringPreis = "0,"+_preis;
			}else if(_preis<=9 && _preis>=0){
				StringPreis = "0,0"+_preis;
			}else{
				StringPreis = "Negative prize xD";
			}
				
			if(Math.abs(Ausgabe)>99){
				StringAusgabe = new StringBuilder(Ausgabe.toString()).insert(Ausgabe.toString().length()-2, ",").toString();
			}else if(Ausgabe>9 && Ausgabe<=99){
				StringAusgabe = "0,"+Ausgabe;
			}else if(Ausgabe<=9 && Ausgabe>=0){
				StringAusgabe = "0,0"+Ausgabe;
			}else if(Ausgabe<0 && Ausgabe>=-9){
				StringAusgabe = "-0,0"+Math.abs(Ausgabe);
			}else{
				StringAusgabe = "-0,"+Math.abs(Ausgabe);
			}
			
			_ui.getPreisAnzeige().setText(StringPreis);
			_ui.getRestbetragAnzeige().setText(StringAusgabe);
		}
	}

	/**
	 * Diese Methode wird gebraucht, damit das PlatzverkaufsWerkzeug einen
	 * Listener beim OK-Button erstellen kann.
	 * 
	 * @return BezahlwerkzeugUI
	 */
	public BezahlwerkzeugUI getBezahlwerkzeugUI() {
		return _ui;
	}
}
