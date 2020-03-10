package it.dstech.ordinamento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MainVideogiochi {

	public static void main(String[] args) {
		Videogioco v1 = new Videogioco("metal gear solid", 1994, Genere.AVVENTURA, Pegi.QUATTORDICI_PIU, 10.0);
		Videogioco v2 = new Videogioco("fifa 2020", 2001, Genere.SPORTIVO, Pegi.TUTTI, 6.5);
		Videogioco v3 = new Videogioco("eFootball pes 2020", 2020, Genere.SPORTIVO, Pegi.TUTTI, 7.0);
		Videogioco v4 = new Videogioco("Resident Evil 2", 1997, Genere.HORROR, Pegi.DICIOTTO_PIU, 8.5);
		Videogioco v5 = new Videogioco("GTA V", 2012, Genere.SIMULAZIONE, Pegi.DICIOTTO_PIU, 9.0);
		Videogioco v6 = new Videogioco("Zelda", 1993, Genere.MMORPG, Pegi.TUTTI, 9.5);
		Videogioco v7 = new Videogioco("Call of Duty 4", 2004, Genere.FPS, Pegi.QUATTORDICI_PIU, 8.0);
		Videogioco v8 = new Videogioco("ET", 1989, Genere.SIMULAZIONE, Pegi.TUTTI, 2.5);

		List<Videogioco> listaVideogiochi = new ArrayList<>();
		listaVideogiochi.add(v1);
		listaVideogiochi.add(v2);
		listaVideogiochi.add(v3);
		listaVideogiochi.add(v4);
		listaVideogiochi.add(v5);
		listaVideogiochi.add(v6);
		listaVideogiochi.add(v7);
		listaVideogiochi.add(v8);
		
		try {
			salvataggioFile(listaVideogiochi);
			listaVideogiochi  = caricamentoFile();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		for (Videogioco videogioco : listaVideogiochi) {
			System.out.println(videogioco);
		}
		System.out.println("#############################");
		// <>

		Collections.sort(listaVideogiochi);
		for (Videogioco videogioco : listaVideogiochi) {
			System.out.println(videogioco);
		}
		System.out.println("#############################");

		// ordinamento per voto
		Collections.sort(listaVideogiochi, new Comparator<Videogioco>() {

			@Override
			public int compare(Videogioco o1, Videogioco o2) {
				if (o1.getVotazione() < o2.getVotazione())
					return 1;
				if (o1.getVotazione() > o2.getVotazione())
					return -1;

				return 0;
			}
		});
		for (Videogioco videogioco : listaVideogiochi) {
			System.out.println(videogioco);
		}
		System.out.println("#############################");
		// ordinamento per classificazione
		Collections.sort(listaVideogiochi, new Comparator<Videogioco>() {

			@Override
			public int compare(Videogioco o1, Videogioco o2) {
				// TODO Auto-generated method stub
				if (o1.getClassificazione() == Pegi.TUTTI) {
					if (o2.getClassificazione() == Pegi.QUATTORDICI_PIU
							|| o2.getClassificazione() == Pegi.DICIOTTO_PIU) {
						return 1;
					}
				}
				if (o1.getClassificazione() == Pegi.DICIOTTO_PIU) {
					if (o2.getClassificazione() == Pegi.TUTTI) {
						return -1;
					}
					if (o2.getClassificazione() == Pegi.QUATTORDICI_PIU) {
						return 1;
					}
				}
				if (o1.getClassificazione() == Pegi.QUATTORDICI_PIU) {
					if (o2.getClassificazione() == Pegi.TUTTI || o2.getClassificazione() == Pegi.DICIOTTO_PIU) {
						return -1;
					}
				}
				return 0;
			}
		});
		
		for (Videogioco videogioco : listaVideogiochi) {
			System.out.println(videogioco);
		}
		System.out.println("#############################");

	}

	private static List<Videogioco> caricamentoFile() throws IOException, ClassNotFoundException {
		File file = new File("listagiochi");
		if (!file.exists()) {
			file.createNewFile();
			return new ArrayList<>();
		}
		FileInputStream in = new FileInputStream(file);
		ObjectInputStream stream = new ObjectInputStream(in);
		List<Videogioco> videogiochi = (List<Videogioco>) stream.readObject();
		return videogiochi;
	}

	private static void salvataggioFile(List<Videogioco> listaVideogiochi) throws IOException {
		File file = new File("listagiochi");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(file);
		ObjectOutputStream stream = new ObjectOutputStream(out);
		stream.writeObject(listaVideogiochi);
		stream.close();

	}

}
