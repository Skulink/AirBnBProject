package pbardu.airbnb.data;


import pbardu.airbnb.logements.Logement;
import pbardu.airbnb.utilisateurs.Hote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import static java.awt.Color.green;
import static java.awt.Color.red;


/**
 * Classe représentant une liste de logement
 * Extends JPanel pour son utilisation
 */
public class LogementList extends JPanel {
    private JList<String> listDesLogements;
    private final LogementList that = this;
    private List<Logement> list = AirBnBData.getInstance().getLogements();
    private JButton buttonAddLogement = new JButton("Ajouter");
    private JButton buttonDeleteLogement = new JButton("Supprimer");

    //Constructeur
    public LogementList(boolean withoutAside) {
        this.setLayout(new BorderLayout());
        /*
         Version Java 8 Stream API
         String[] data = list.stream().map(Object::toString).toArray(String[]::new)
         */
        // Création d'un tableau de la même taille que la list "list"
        String[] data = new String[list.size()];
        // Pour tous les éléments dans la list "list"
        for (int i = 0; i < list.size(); i++) {
            Logement logement = list.get(i);
            // On converti le logement en chaine de caractère
            String s = logement.toString();
            data[i] = s;
        }

        listDesLogements = new JList<>(data);
        JScrollPane scrollPane = new JScrollPane(listDesLogements);
        this.add(scrollPane);
        this.buildAside();
    }


    public Logement getSelectedLogement() {
        List<String> selection = listDesLogements.getSelectedValuesList();
        if (selection.size() > 0) {
            String logementString = selection.get(0);
            List<Logement> list = AirBnBData.getInstance().getLogements();

                        /*
                        Version 8 BG ©Jheissler
                        return list.stream()
                            .filter(hote -> hote.toString().equals(hoteString)) // Ne garde que ceux qui respecte le test
                            .findFirst() // On recupère le premier ou aucun Optional<Hote>
                            .orElseGet(null); // On récupère cette valeur ou null si elle n'existe pas
                        */

            for (Logement l : list) {
                if (l.toString().equals(logementString)) {
                    return l;
                }
            }
            return null;
        } else {
            return null;
        }
    }




    private void buildAside() {
        JPanel mainAside = new JPanel();
        mainAside.add(buttonAddLogement);
        mainAside.add(buttonDeleteLogement);
        this.add(mainAside, BorderLayout.EAST);


        buttonAddLogement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                that.remove(mainAside);
                that.revalidate();
                that.repaint();

                JPanel panelHote = new JPanel();

                //JLabel
                JLabel labelNewHote = new JLabel("Selectionner l'hôte");
                JLabel labelTarifParNuit = new JLabel("Indiquer le tarif par nuit : ");
                JLabel labelAdresse = new JLabel("Indiquer l'adresse : ");
                JLabel labelSuperficie = new JLabel("Indiquer la superficie : ");
                JLabel labelNbVoyageursMaxt = new JLabel("Indiquer le nombre de voyageur : ");

                //JTextField
                HoteList listHote = new HoteList(true);

                JTextField textFieldTarifNuit = new JTextField();
                JTextField textFieldAdresse = new JTextField();
                JTextField textFieldSuperficie = new JTextField();
                JTextField textFieldNbVoyageursMaxt = new JTextField();
                JButton btnAddLogement = new JButton("Ajouter le logement");
                btnAddLogement.setBackground(green);
                btnAddLogement.setOpaque(true);
                btnAddLogement.setBorderPainted(false);
                JButton btnBack = new JButton("Retour");
                btnBack.setBackground(red);
                btnBack.setOpaque(true);
                btnBack.setBorderPainted(false);

                panelHote.setLayout(new GridLayout(12, 1));

                JScrollPane scrollPaneListHote = new JScrollPane(listHote);
                //Ajout dans le panelHote du label labelNewHote + listHote
                panelHote.add(labelNewHote);
                panelHote.add(scrollPaneListHote);


                //Ajout dans le panelHote du label labelTarifParNuit + listHote
                panelHote.add(labelTarifParNuit);
                panelHote.add(textFieldTarifNuit);
                //Ajout dans le panelHote du label labelAdresse + textFieldAdresse
                panelHote.add(labelAdresse);
                panelHote.add(textFieldAdresse);
                //Ajout dans le panelHote du label labelSuperficie + textFieldSuperficie
                panelHote.add(labelSuperficie);
                panelHote.add(textFieldSuperficie);
                //Ajout dans le panelHote du label labelTarifParNuit + textFieldNbVoyageursMaxt
                panelHote.add(labelNbVoyageursMaxt);
                panelHote.add(textFieldNbVoyageursMaxt);
                //Ajout bouton de validation
                panelHote.add(btnAddLogement);
                //Ajout du bouton de retour
                panelHote.add(btnBack);

                btnBack.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //todo retourne sur l'ecran precedent
                        panelHote.setVisible(false);
                    }
                });

                //Action Listener lors du clic sur le bouton validé
                btnAddLogement.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Hote resultHotList = listHote.getSelectedHote();

                        int resultTarifParNuit = 0;
                        if (textFieldTarifNuit.getText().trim().length() > 0) {
                            resultTarifParNuit = Integer.parseInt(textFieldTarifNuit.getText());
                        }

                        String resultAdresse = "";
                        if (textFieldAdresse.getText().trim().length() > 0) {
                            resultAdresse = textFieldAdresse.getText();
                        }
                        int resultSuperficie = 0;
                        if (textFieldSuperficie.getText().trim().length() > 0) {
                            resultSuperficie = Integer.parseInt(textFieldSuperficie.getText());
                        }
                        int resultNbrVoyageurs = 0;
                        if (textFieldNbVoyageursMaxt.getText().trim().length() > 0) {
                            resultNbrVoyageurs = Integer.parseInt(textFieldNbVoyageursMaxt.getText());
                        }

                        if (resultTarifParNuit != 0 && resultAdresse != null && resultSuperficie != 0 && resultNbrVoyageurs != 0) {
                            System.out.println(resultHotList + "" + resultTarifParNuit + "" + resultAdresse + "" + resultSuperficie + "" + resultNbrVoyageurs);
                            Logement addLogement = new Logement(resultHotList, resultTarifParNuit, resultAdresse, resultSuperficie, resultNbrVoyageurs) {
                                @Override
                                public Hote getHote() {
                                    return super.getHote();
                                }
                            };

                            //Mise à jour de la liste des logement avec le new logement
                            list.add(addLogement);
                            //System.out.println(list);
                            listDesLogements.setListData(list.stream().map(Object::toString).toArray(String[]::new));
                        } else {
                            //custom title, warning icon
                            JOptionPane.showMessageDialog(mainAside,
                                    "Votre saisi n'est pas valide, veuillez recommencer",
                                    "Champs du formulaire incorrect",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });

                that.add(panelHote, BorderLayout.EAST);
                that.revalidate();
                that.repaint();
            }
        });

        buttonDeleteLogement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                Logement resultLogementList = getSelectedLogement();
                list.remove(resultLogementList);
                listDesLogements.setListData(list.stream().map(Object::toString).toArray(String[]::new));
            }
        });
    }

}
