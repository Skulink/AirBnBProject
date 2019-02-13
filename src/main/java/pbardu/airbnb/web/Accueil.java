package pbardu.airbnb.web;

import pbardu.airbnb.data.HoteList;
import pbardu.airbnb.data.LogementList;
import pbardu.airbnb.data.ReservationList;
import pbardu.airbnb.data.VoyageurList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe permettant de gérer le contenue de l'interface
 * graphique de la page d'accueil
 */
public class Accueil {

    private JFrame mainFrame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private JMenuBar mainBar = new JMenuBar();

    /**
     * Constructeur de la page d'accueil
     */
    public Accueil() {
        //Titre de l’application
        mainFrame.setTitle("AIRB&B");
        //Taille de la fenêtre
        mainFrame.setSize(1000, 1000);
        //Centrer la fenêtre
        mainFrame.setLocationRelativeTo(null);
        //Interdire le redimentionnement
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Paramétrage du panel
        mainPanel.setSize(800, 800);
        mainPanel.setLayout(new BorderLayout());
        this.buildMenuBar();
        mainFrame.setJMenuBar(mainBar);
    }

    /**
     * Methode buildMenuBar
     * Permettant de construire la barre de navigation
     */
    private void buildMenuBar() {
        //Déclaration + initialisation + affectation paramétre "text"
        //du constructeur pour le menu (JMenu) + sous menu (JMenuItem)

        JMenu logement = new JMenu("Gestion des logements");
        JMenuItem listLogement = new JMenuItem("Lister les logements");
        JMenuItem addLogement = new JMenuItem("Ajouter un logement");
        JMenuItem removeLogement = new JMenuItem("Supprimer un logement");
        logement.add(listLogement);
        logement.add(addLogement);
        logement.add(removeLogement);

        JMenu hote = new JMenu("Gestion des hôtes");
        JMenuItem listHote = new JMenuItem("Lister les hôtes");
        JMenuItem addHote = new JMenuItem("Ajouter un hôte");
        JMenuItem removeHote = new JMenuItem("Supprimer un hôte");
        hote.add(listHote);
        hote.add(addHote);
        hote.add(removeHote);

        JMenu voyageur = new JMenu("Gestion des voyageurs");
        JMenuItem listVoyageur = new JMenuItem("Lister les voyageurs");
        JMenuItem addVoyageur = new JMenuItem("Ajouter un voyageur");
        JMenuItem removeVoyageur = new JMenuItem("Supprimer un voyageur");
        voyageur.add(listVoyageur);
        voyageur.add(addVoyageur);
        voyageur.add(removeVoyageur);

        JMenu reservation = new JMenu("Gestion des réservations");
        JMenuItem listReservation = new JMenuItem("Lister les reservations");
        JMenuItem addReservation = new JMenuItem("Ajouter une reservation");
        JMenuItem removeReservation = new JMenuItem("Supprimer une reservation");
        reservation.add(listReservation);
        reservation.add(addReservation);
        reservation.add(removeReservation);
        mainBar.add(logement);
        mainBar.add(hote);
        mainBar.add(voyageur);
        mainBar.add(reservation);


        //Gestion lors du clic sur "Lister les logements" du menu "Gestion des logements"
        listLogement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new LogementList());
                mainFrame.setVisible(true);
            }
        });

        //Gestion lors du clic sur "Lister les hotes" du menu "Gestion des hotes"
        listHote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new HoteList());
                mainFrame.setVisible(true);
            }
        });
        //Gestion lors du clic sur "Lister les voyageurs" du menu "Gestion des voyageurs"
        listVoyageur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new VoyageurList());
                mainFrame.setVisible(true);
            }
        });
        //Gestion lors du clic sur "Lister les reservations" du menu "Gestion des reservations"
        listReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContentPane(new ReservationList());
                mainFrame.setVisible(true);
            }
        });

    }
    /**
     * Methode show permanttant l'affichage de la page d'accueil
     */
    public void show() {
        //Rendre la fenêtre visible
        mainFrame.setVisible(true);
        mainFrame.repaint();
    }
}
