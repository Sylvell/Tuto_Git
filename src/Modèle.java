

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;

public class Modèle extends Observable { 

	public ArrayList<ImageModèle> images;
	File fichier = new File("images.xml");

	int indexImageSelectionnée = 0;

	public Modèle(String dir) {
		XMLDecoder decoder = null;
		try {
			FileInputStream fis = new FileInputStream (fichier);
			BufferedInputStream bis = new BufferedInputStream (fis);
			decoder = new XMLDecoder(bis);
			
			this.images = (ArrayList<ImageModèle>)decoder.readObject();
			
		}
		
		catch(IOException e1){
		
		File repImages = new File(dir);
		File[] imagesListe = repImages.listFiles();
		this.images = new ArrayList<>();
		for (File file : imagesListe) {
			String nomImage = file.getName().split("\\.")[0];
			this.images.add(new ImageModèle(nomImage, "Ressources/images/"+file.getName(), 0));
		}
		
		}
		finally {
			if (decoder != null) {
				decoder.close();
			}
		}
	}

	public void sélection(int item) {
		this.indexImageSelectionnée = item;
		this.setChanged();
		this.notifyObservers(this.images.get(this.indexImageSelectionnée));
	}

	public void changeNote(int nouveauRating) {
		this.images.get(this.indexImageSelectionnée).note = nouveauRating;
		this.setChanged();
		this.notifyObservers(this.images.get(this.indexImageSelectionnée));
	}
	
	public void enregistrer() {
		XMLEncoder encoder = null;
		try {
			FileOutputStream fos = new FileOutputStream ("images.xml");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			encoder = new XMLEncoder(bos);
			
			encoder.writeObject(this.images);
			encoder.flush();
			
		}
		
		catch(IOException e1){
			throw new RuntimeException("Impossible d'écrire les données");
			
			
		}
		finally {
			if (encoder != null) {
				encoder.close();
			}
		}
		
	}

}
