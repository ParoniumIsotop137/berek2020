package berekfeladat;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class BerekFoAblak {

	private JFrame frmFoAblak;
	private List<Dolgozo> dolgozok;
	private DefaultListModel lModel;
	private JList lstDolozoLista;
	private String reszleg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BerekFoAblak window = new BerekFoAblak();
					window.frmFoAblak.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BerekFoAblak() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFoAblak = new JFrame();
		frmFoAblak.getContentPane().setBackground(new Color(0, 153, 204));
		frmFoAblak.setTitle("Dolgoz\u00F3k adatai");
		frmFoAblak.setBounds(100, 100, 700, 400);
		frmFoAblak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFoAblak.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 685, 250);
		frmFoAblak.getContentPane().add(scrollPane);

		lstDolozoLista = new JList();
		lstDolozoLista.setForeground(new Color(65, 105, 225));
		lstDolozoLista.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lstDolozoLista.setBackground(new Color(245, 255, 250));
		scrollPane.setViewportView(lstDolozoLista);

		dolgozok = new ArrayList<Dolgozo>();
		lModel = new DefaultListModel<Dolgozo>();

		ListaFeltoltes();

		lstDolozoLista.setModel(lModel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(176, 196, 222));
		frmFoAblak.setJMenuBar(menuBar);

		JMenu mnFeladatok = new JMenu("Feladatok");
		mnFeladatok.setFont(new Font("Serif", Font.BOLD, 13));
		menuBar.add(mnFeladatok);

		JMenuItem mntmHarmadikF = new JMenuItem("3. feladat");
		mntmHarmadikF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HarmadikFeladat();

			}
		});
		mntmHarmadikF.setBackground(new Color(245, 255, 250));
		mntmHarmadikF.setForeground(new Color(105, 105, 105));
		mntmHarmadikF.setFont(new Font("SansSerif", Font.ITALIC, 12));
		mnFeladatok.add(mntmHarmadikF);

		JMenuItem mntmNegyedikF = new JMenuItem("4. feladat");
		mntmNegyedikF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				NegyedikFeladat();

			}
		});
		mntmNegyedikF.setForeground(SystemColor.controlDkShadow);
		mntmNegyedikF.setFont(new Font("SansSerif", Font.ITALIC, 12));
		mntmNegyedikF.setBackground(new Color(245, 255, 250));
		mnFeladatok.add(mntmNegyedikF);

		JMenuItem mntmOtodikF = new JMenuItem("5. feladat");
		mntmOtodikF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				OtodikesHatodikFeladat();

			}
		});
		mntmOtodikF.setForeground(SystemColor.controlDkShadow);
		mntmOtodikF.setFont(new Font("SansSerif", Font.ITALIC, 12));
		mntmOtodikF.setBackground(new Color(245, 255, 250));
		mnFeladatok.add(mntmOtodikF);

		JMenuItem mntmHetedikF = new JMenuItem("7. feladat");
		mntmHetedikF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				HetedikFeladat();

			}
		});
		mntmHetedikF.setForeground(SystemColor.controlDkShadow);
		mntmHetedikF.setFont(new Font("SansSerif", Font.ITALIC, 12));
		mntmHetedikF.setBackground(new Color(245, 255, 250));
		mnFeladatok.add(mntmHetedikF);
	}

	private void HetedikFeladat() {

		Map<String, Integer> statisztika = new HashMap<String, Integer>();

		for (Dolgozo dolgozo : dolgozok) {
			statisztika.put(dolgozo.getReszleg(), 0);
		}

		for (Map.Entry<String, Integer> item : statisztika.entrySet()) {
			for (Dolgozo dolgozo : dolgozok) {
				if (dolgozo.getReszleg().equals(item.getKey())) {
					item.setValue((item.getValue() + 1));
				}
			}
		}

		StringBuilder kiiras = new StringBuilder();

		statisztika.entrySet().stream().forEach(x -> kiiras.append(x.getKey() + " - " + x.getValue() + " fõ\n"));

		JOptionPane.showMessageDialog(frmFoAblak, "Statisztika:\n" + kiiras, "7. feladat", JOptionPane.PLAIN_MESSAGE);

	}

	private void OtodikesHatodikFeladat() {

		int i = 0;

		BekeroAblak ujAblak = new BekeroAblak();
		ujAblak.setVisible(true);

		if (ujAblak.isDialogResult()) {

			reszleg = ujAblak.getReszlegNeve();
		}

		int max = -1;
		try {

			max = dolgozok.stream().filter(x -> x.getReszleg().equals(reszleg)).mapToInt(x -> x.getBer()).max()
					.orElseThrow();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmFoAblak, "A megadott részleg nem létezik a cégnél!", "6. feladat",
					JOptionPane.INFORMATION_MESSAGE);
		}

		while (i < dolgozok.size() && dolgozok.get(i).getBer() != max) {
			i++;
		}
		if (i < dolgozok.size()) {
			JOptionPane.showMessageDialog(frmFoAblak,
					"A legtöbbet keresõ dolgozó a megadott részlegen:\nNév: " + dolgozok.get(i).getDolgozoNeve()
							+ "\nNeme: " + dolgozok.get(i).getDolgozoNeme() + "\nBelépés: "
							+ String.valueOf(dolgozok.get(i).getBelepesEve()) + "\nBér: "
							+ String.valueOf(dolgozok.get(i).getBer()) + " Forint",
					"6. feladat", JOptionPane.PLAIN_MESSAGE);
		}

	}

	private void NegyedikFeladat() {

		Double atlagBer = dolgozok.stream().mapToDouble(x -> x.getBer()).average().getAsDouble();

		String kiiras = String.format("%.1f eFt", (atlagBer / 1000.0));

		JOptionPane.showMessageDialog(frmFoAblak, "Bérek átlaga: " + kiiras, "4. feladat", JOptionPane.PLAIN_MESSAGE);

	}

	private void HarmadikFeladat() {

		JOptionPane.showMessageDialog(frmFoAblak, "Dolgozók száma: " + String.valueOf(dolgozok.size()) + "fõ",
				"3. feladat", JOptionPane.PLAIN_MESSAGE);

	}

	private void ListaFeltoltes() {

		FajlKezeles fajl = new FajlKezeles();
		dolgozok = fajl.AdatokBeolvasasa("F:\\Kurs\\Feladatok\\Berek\\berek2020.txt", ";");

		for (Dolgozo dolgozo : dolgozok) {
			lModel.addElement(dolgozo);
		}

	}
}
