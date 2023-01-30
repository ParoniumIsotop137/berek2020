package berekfeladat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FajlKezeles {

	public List<Dolgozo> AdatokBeolvasasa(String fajlNev, String elvalaszto) {

		List<Dolgozo> dolgozoLista = new ArrayList<Dolgozo>();

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlNev), "UTF-8"));

			br.readLine();

			while (br.ready()) {

				String[] db = br.readLine().split(elvalaszto);

				Dolgozo d = new Dolgozo(db[0], db[1], db[2], Integer.parseInt(db[3]), Integer.parseInt(db[4]));

				dolgozoLista.add(d);
			}

			br.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Az adatok beolvasása sikertelen volt!", "Hiba",
					JOptionPane.ERROR_MESSAGE);
		}

		return dolgozoLista;

	}

}
