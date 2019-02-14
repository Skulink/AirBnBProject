package pbardu.airbnb.page;

import pbardu.airbnb.data.Search;
import pbardu.airbnb.data.SearchInterface;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

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
	//	mainPanel.setSize(350	, 350);


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

		SearchInterface searchInterface = new SearchInterface(mainPanel, mainFrame);

	}
}
