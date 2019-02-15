package pbardu.airbnb.data;

import pbardu.airbnb.utilisateurs.Voyageur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static java.awt.Color.green;
import static java.awt.Color.red;

/**
 * Classe représentant une liste des voyageurs
 * Extends JPanel pour son utilisation
 */
public class VoyageurList extends JPanel {
    private JList<String> listDesVoyageurs;
    private final VoyageurList that = this;
    private List<Voyageur> list = AirBnBData.getInstance().getVoyageurs();
    private JButton buttonAddVoyageur = new JButton("Ajouter");
    private JButton buttonDeleteVoyageur = new JButton("Supprimer");

    //Constructeur
    public VoyageurList(boolean withouAside) {
        this.setLayout(new BorderLayout());

        /*
         Version Java 8 Stream API
         String[] data = list.stream().map(Object::toString).toArray(String[]::new)
         */

        // Création d'un tableau de la même taille que la list "list"
        String[] data = new String[list.size()];
        // Pour tous les éléments dans la list "list"
        for (int i = 0; i < list.size(); i++) {
            Voyageur voyageur = list.get(i);
            // On converti le logement en chaine de caractère
            String s = voyageur.toString();
            data[i] = s;
        }

        listDesVoyageurs = new JList<>(data);
        JScrollPane scrollPane = new JScrollPane(listDesVoyageurs);
        this.add(scrollPane);
        this.add(listDesVoyageurs);
        this.buildAside();

    }

    private void buildAside() {
        JPanel mainAside = new JPanel();
        mainAside.add(buttonAddVoyageur);
        mainAside.add(buttonDeleteVoyageur);
        this.add(mainAside, BorderLayout.EAST);
        
        buttonAddVoyageur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                that.remove(mainAside);
                that.revalidate();
                that.repaint();

                JPanel panelVoyageur = new JPanel();

                //JLabel
                JLabel labelNomVoyageur = new JLabel("Nom du nouveau voyageur : ");
                JLabel labelPrenomVoyageur = new JLabel("Prénom du nouveau voyageur : ");
                JLabel labelAgeVoyageur = new JLabel("Age du nouveau voyageur : ");

                //JTextField
                JTextField textFieldNomVoyageur = new JTextField();
                JTextField textFieldPrenomVoyageur = new JTextField();
                JTextField textFieldAgeVoyageur = new JTextField();
                JButton btnAddVoyageur = new JButton("Ajouter un Voyageur");
                btnAddVoyageur.setBackground(green);
                btnAddVoyageur.setOpaque(true);
                btnAddVoyageur.setBorderPainted(false);
                panelVoyageur.setLayout(new GridLayout(8, 1));
                JButton btnBack = new JButton("Retour");
                btnBack.setBackground(red);
                btnBack.setOpaque(true);
                btnBack.setBorderPainted(false);
                //Ajout dans le panelVoyageur du label labelTarifParNuit + listHote
                panelVoyageur.add(labelNomVoyageur);
                panelVoyageur.add(textFieldNomVoyageur);
                //Ajout dans le panelVoyageur du label labelAdresse + textFieldAdresse
                panelVoyageur.add(labelPrenomVoyageur);
                panelVoyageur.add(textFieldPrenomVoyageur);
                //Ajout dans le panelVoyageur du label labelSuperficie + textFieldSuperficie
                panelVoyageur.add(labelAgeVoyageur);
                panelVoyageur.add(textFieldAgeVoyageur);
                //Ajout bouton de validation
                panelVoyageur.add(btnAddVoyageur);
                //Ajout du bouton de retour
                panelVoyageur.add(btnBack);

                btnBack.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //todo retourne sur l'ecran precedent
                        panelVoyageur.setVisible(false);
                    }
                });


                //Action Listener lors du clic sur le bouton validé
                btnAddVoyageur.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Hote resultHotList = listHote.getSelectedHote();

                        String resultNom = "";
                        if (textFieldNomVoyageur.getText().trim().length() > 0) {
                            resultNom = textFieldNomVoyageur.getText();
                        }
                        String resultPrenom = "";
                        if (textFieldPrenomVoyageur.getText().trim().length() > 0) {
                            resultPrenom = textFieldPrenomVoyageur.getText();
                        }
                        int resultAge = 0;
                        if (textFieldAgeVoyageur.getText().trim().length() > 0) {
                            resultAge = Integer.parseInt(textFieldAgeVoyageur.getText());
                        }

                        if (resultNom != null && resultPrenom != null && resultAge != 0) {
                            System.out.println(resultNom + "" + resultPrenom + "" + resultAge);
                            Voyageur addVoyageur = new Voyageur(resultNom, resultPrenom, resultAge);

                            //Mise à jour de la liste des logement avec le new logement

                            list.add(addVoyageur);
                            //System.out.println(list);
                            listDesVoyageurs.setListData(list.stream().map(Object::toString).toArray(String[]::new));
                        } else {
                            //custom title, warning icon
                            JOptionPane.showMessageDialog(mainAside,
                                    "Votre saisi n'est pas valide, veuillez recommencer",
                                    "Champs du formulaire incorrect",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });
                that.add(panelVoyageur, BorderLayout.EAST);
                that.revalidate();
                that.repaint();
            }
        });

        buttonDeleteVoyageur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                Voyageur resultVoyageurList = getSelectedVoyageur();
                list.remove(resultVoyageurList);
                listDesVoyageurs.setListData(list.stream().map(Object::toString).toArray(String[]::new));
            }
        });
    }

    public Voyageur getSelectedVoyageur() {
        List<String> selection = listDesVoyageurs.getSelectedValuesList();
        if (selection.size() > 0) {
            String voyageurString = selection.get(0);
            List<Voyageur> list = AirBnBData.getInstance().getVoyageurs();

                        /*
                        Version 8 BG ©Jheissler
                        return list.stream()
                            .filter(hote -> hote.toString().equals(hoteString)) // Ne garde que ceux qui respecte le test
                            .findFirst() // On recupère le premier ou aucun Optional<Hote>
                            .orElseGet(null); // On récupère cette valeur ou null si elle n'existe pas
                        */

            for (Voyageur v : list) {
                if (v.toString().equals(voyageurString)) {
                    return v;
                }
            }
            return null;
        } else {
            return null;
        }



    }
}

