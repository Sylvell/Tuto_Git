

import java.io.Serializable;

public class ImageModèle implements Serializable {

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public int getNote() {
		return note;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setNote(int note) {
		this.note = note;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	public String chemin;
	public int note;

	public ImageModèle() {}
		
	public ImageModèle(String id, String p, int r) {
		this.id = id;
		this.chemin = p;
		this.note = r;
	}
	
	public String toString() {
		String out = this.id + " ";
		for (int i=0; i<=this.note; i++) out += "*";
		return out;
	}

}
