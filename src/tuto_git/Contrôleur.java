package tuto_git;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contrôleur implements ActionListener {
	// coucou commentaire non désiré
	Modèle refModl;
	
	public Contrôleur(Modèle m) {
		this.refModl = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		refModl.incrémente();
	}

	
}
