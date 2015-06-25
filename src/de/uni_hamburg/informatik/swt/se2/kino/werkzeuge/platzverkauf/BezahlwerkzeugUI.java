package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

class BezahlwerkzeugUI {
	private JFrame _popUpFenster;
	private JLabel _preisAnzeige;
	private JFormattedTextField _einzahlungsAnzeige;
	private JLabel _restbetragAnzeige;
	private JButton _okButton;
	private JButton _exitButton;

	public BezahlwerkzeugUI() {
		try {
			_popUpFenster = erstelleDialog();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private JFrame erstelleDialog() throws ParseException {
		JFrame fenster = new JFrame();
		
		JLabel preisLabel = new JLabel("Preis:");
		_preisAnzeige = new JLabel();
		_preisAnzeige.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel Euro1 = new JLabel("€");
		JLabel einzahlungLabel = new JLabel("Eingezahlt:");
		MaskFormatter formatter = new MaskFormatter("####,##");
		formatter.setPlaceholder("0000000");		
		_einzahlungsAnzeige = new JFormattedTextField(formatter);
		JLabel Euro2 = new JLabel("€");
		JLabel Minus = new JLabel("_");
		JLabel Line = new JLabel("______________");
		JLabel restbetragLabel = new JLabel("Restbetrag:");
		JLabel Euro3 = new JLabel("€");
		
		_restbetragAnzeige = new JLabel();
		_restbetragAnzeige.setHorizontalAlignment(SwingConstants.RIGHT);
		_okButton = new JButton("OK");
		_exitButton = new JButton("Abbrechen");

		fenster.add(preisLabel);
		fenster.add(_preisAnzeige);
		fenster.add(Euro1);
		fenster.add(einzahlungLabel);
		fenster.add(_einzahlungsAnzeige);
		fenster.add(Euro2);
		fenster.add(Minus);
		fenster.add(Line);
		fenster.add(restbetragLabel);
		fenster.add(_restbetragAnzeige);
		fenster.add(Euro3);
		fenster.add(_okButton);
		fenster.add(_exitButton);
		
		preisLabel.setBounds(20,15,300,20);
		_preisAnzeige.setBounds(102,15,100,20);
		Euro1.setBounds(208, 15, 20, 20);
		einzahlungLabel.setBounds(20,40,300,20);
		_einzahlungsAnzeige.setBounds(155,40,50,20);
		Euro2.setBounds(208, 40, 20, 20);
		Minus.setBounds(145, 35, 20, 20);
		Line.setBounds(120, 49, 100, 20);
		restbetragLabel.setBounds(20,65,300,20);
		_restbetragAnzeige.setBounds(102,65,100,20);
		Euro3.setBounds(208, 65, 20, 20);
		_okButton.setBounds(10,110,100,20);
		_exitButton.setBounds(120,110,100,20);
		
		fenster.setLayout(null);
		fenster.setSize(248, 180);
		fenster.setLocationRelativeTo(null);
		
		return fenster;
	}

	public JButton getOKButton() {
		return _okButton;
	}

	public JButton getExitButton() {
		return _exitButton;
	}

	public JFormattedTextField getEinzahlungsAnzeige() {
		return _einzahlungsAnzeige;
	}

	public JLabel getPreisAnzeige() {
		return _preisAnzeige;
	}

	public JLabel getRestbetragAnzeige() {
		return _restbetragAnzeige;
	}

	public void setzeDichSichtbar() {
		_popUpFenster.setVisible(true);
		_einzahlungsAnzeige.requestFocus();
	}

	public void setzeDichUnsichtbar() {
		_popUpFenster.setVisible(false);
		_einzahlungsAnzeige.setText("0000000");
	}
}
