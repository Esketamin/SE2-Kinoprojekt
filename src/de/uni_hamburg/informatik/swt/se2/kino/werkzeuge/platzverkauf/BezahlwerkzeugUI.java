package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;

class BezahlwerkzeugUI {
	private JFrame _hauptFenster;
	private JLabel _titel;
	private JPanel _hauptPanel;
	private JLabel _preisLabel;
	private JLabel _preisAnzeige;
	private JLabel _einzahlungLabel;
	private JFormattedTextField _einzahlungsAnzeige;
	private JLabel _restbetragLabel;
	private JLabel _restbetragAnzeige;
	private JPanel _buttonPanel;
	private JButton _okButton;
	private JButton _exitButton;

	public BezahlwerkzeugUI() {
		try {
			_hauptFenster = erstelleDialog();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private JFrame erstelleDialog() throws ParseException {
		JFrame fenster = new JFrame();

		JLabel _titel = new JLabel("ThisIsBezahling");

		JPanel _hauptPanel = new JPanel();
		JLabel _preisLabel = new JLabel("Preis:");
		JLabel _preisAnzeige = new JLabel();
		JLabel _einzahlungLabel = new JLabel("Eingezahlt:");
		MaskFormatter formatter = new MaskFormatter("####,##");
		formatter.setPlaceholder("   000");
		JFormattedTextField _einzahlungsAnzeige = new JFormattedTextField(
				formatter);
		_einzahlungsAnzeige.setText("0");
		JLabel _restbetragLabel = new JLabel();
		JLabel _restbetragAnzeige = new JLabel();

		JPanel _buttonPanel = new JPanel();
		JButton _okButton = new JButton("OK");
		JButton _exitButton = new JButton("Abbrechen");

		_buttonPanel.add(_okButton);
		_buttonPanel.add(_exitButton);

		_hauptPanel.add(_preisLabel);
		_hauptPanel.add(_preisAnzeige);
		_hauptPanel.add(_einzahlungLabel);
		_hauptPanel.add(_einzahlungsAnzeige);
		_hauptPanel.add(_restbetragLabel);
		_hauptPanel.add(_restbetragAnzeige);

		fenster.add(_titel);
		fenster.add(_hauptPanel);
		fenster.add(_buttonPanel);

		
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

	public JLabel getRestbetragLabel() {
		return _restbetragLabel;
	}

	public JLabel getRestbetragAnzeige() {
		return _restbetragAnzeige;
	}

	public void setzeDichSichtbar() {
		_hauptFenster.setVisible(true);
		_einzahlungsAnzeige.requestFocus();
	}

	public void setzeDichUnsichtbar() {
		_hauptFenster.setVisible(false);
	}
}
