package berekfeladat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BekeroAblak extends JDialog {
	private JTextField textField;
	private String reszlegNeve;
	private boolean DialogResult = false;

	/**
	 * Launch the application.
	 */

	public String getReszlegNeve() {
		return reszlegNeve;
	}

	public boolean isDialogResult() {
		return DialogResult;
	}

	/**
	 * Create the dialog.
	 */
	public BekeroAblak() {

		setModal(true);
		getContentPane().setBackground(new Color(176, 196, 222));
		setTitle("Keresett r\u00E9szleg");
		setBounds(100, 100, 300, 200);
		getContentPane().setLayout(null);

		JLabel lblReszleg = new JLabel("K\u00E9rem egy r\u00E9szleg nev\u00E9t:");
		lblReszleg.setForeground(new Color(0, 0, 128));
		lblReszleg.setFont(new Font("Serif", Font.BOLD, 12));
		lblReszleg.setHorizontalAlignment(SwingConstants.CENTER);
		lblReszleg.setBounds(70, 11, 140, 25);
		getContentPane().add(lblReszleg);

		textField = new JTextField();
		textField.setFont(new Font("Serif", Font.BOLD, 12));
		textField.setBounds(70, 47, 140, 25);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnKereses = new JButton("Keres\u00E9s");
		btnKereses.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Ellenorzes();

			}
		});
		btnKereses.setForeground(new Color(238, 232, 170));
		btnKereses.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnKereses.setBackground(new Color(112, 128, 144));
		btnKereses.setBounds(37, 103, 95, 30);
		getContentPane().add(btnKereses);

		JButton btnMegsem = new JButton("M\u00E9gsem");
		btnMegsem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});
		btnMegsem.setForeground(new Color(238, 232, 170));
		btnMegsem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnMegsem.setBackground(new Color(112, 128, 144));
		btnMegsem.setBounds(169, 103, 95, 30);
		getContentPane().add(btnMegsem);

	}

	private void Ellenorzes() {

		if (textField.getText() != null && !textField.getText().isBlank()) {

			reszlegNeve = textField.getText();
			DialogResult = true;
			dispose();

		} else {
			JOptionPane.showMessageDialog(this, "A részleg neve mezõ nem maradhat üresen!", "Figyelmeztetés",
					JOptionPane.WARNING_MESSAGE);
		}

	}

}
