package pbardu.airbnb.page;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PagePrincipale {

	public void pagePrincipale() {
		//Déclaration des attributs 
		JFrame mainFrame = new JFrame();
		JPanel mainPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JMenuBar mainBar = new JMenuBar();
		JMenu logement = new JMenu();
		JMenu hote = new JMenu();
		JMenu voyageur = new JMenu();
		JMenu reservation = new JMenu();
		
		//Titre de l'application
		mainFrame.setTitle("AIRB&B");
		//Taille de la fenêtre
		mainFrame.setSize(1000, 1000);
		//Centrer la fenêtre
		mainFrame.setLocationRelativeTo(null);
		//Interdire le redimentionnement
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Rendre la fenêtre visible
		mainFrame.setVisible(true);
		//Paramétrage du panel
		mainPanel.setSize(800, 800);
		mainPanel.setLayout(new BorderLayout());
		//Ajouter le BorderPanel nord dans le Panel
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainFrame.setJMenuBar(mainBar);
		
		//Paramétrage des menus
		logement.setText("Gestion des logements");
		mainBar.add(logement);
		hote.setText("Gestion des hôtes");
		mainBar.add(hote);
		voyageur.setText("Gestion des voyageurs");
		mainBar.add(voyageur);
		reservation.setText("Gestion des réservations");
		mainBar.add(reservation);

	}
}
