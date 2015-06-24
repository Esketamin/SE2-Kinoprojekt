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
			int Eingabe = Integer.parseInt(_ui.getEinzahlungsAnzeige()
					.getText());
			Integer Ausgabe = _preis - Eingabe;
			_ui.getPreisAnzeige().setText(_preis.toString());
			_ui.getRestbetragAnzeige().setText(Ausgabe.toString());

			if (Ausgabe > 0) {
				_ui.getRestbetragLabel().setText("Zu Zahlen");
			} else {
				_ui.getRestbetragLabel().setText("Rückgeld");
			}

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
