package pbardu.airbnb.data;

import pbardu.airbnb.utilisateurs.Hote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static java.awt.Color.green;
import static java.awt.Color.red;

/**
 * Classe représentant une liste des hotes
 * Extends JPanel pour son utilisation
 */
public class HoteList extends JPanel {
    //Declaration + initisation
    //Pour les listes
    private JList<String> listDesHotes;
    private List<Hote> list = AirBnBData.getInstance().getHotes();

    //Declaration de that qui retourne this pour son utilisation dans la classe anonyme
    private final HoteList that = this;

    //Pour les elements Swing JButton
    private JButton buttonAddHote = new JButton("Ajouter");
    private JButton buttonDeleteHote = new JButton("Supprimer");
    private JButton btnAddHote = new JButton("Ajouter l'hote");
    private JButton btnBack = new JButton("Retour");

    //Pour les elements Swing JScrollPane
    private JScrollPane scrollPane = new JScrollPane(listDesHotes);

    //Pour les elements Swing JPanel
    private JPanel panelHote = new JPanel();
    private JPanel mainAside = new JPanel();

    //Pour les elements Swing JLabel
    private JLabel labelNom = new JLabel("Nom du nouvel hôte : ");
    private JLabel labelPrenom = new JLabel("Prénom du nouvel hôte : ");
    private JLabel labelAge = new JLabel("Age du nouvel hôte : ");
    private JLabel labelDelai = new JLabel("Délai de réponse du nouvel hôte : ");

    //Pour les elements Swing JTextField
    private JTextField textFieldNom = new JTextField();
    private JTextField textFieldPrenom = new JTextField();
    private JTextField textFieldAge = new JTextField();
    private JTextField textFieldDelai = new JTextField();


    //Constructeur hoteList à appeler pour avoir l'aside sans les bouton ajout et supprimer
    public HoteList(boolean withoutAside) {
        this.setLayout(new BorderLayout());

        /*
         Version Java 8 Stream API
         String[] data = list.stream().map(Object::toString).toArray(String[]::new)
         */
        // Création d'un tableau de la même taille que la list "list"
        // Pour tous les éléments dans la list "list"
        //Pour les tableaux
        String[] data = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Hote hote = list.get(i);
            // On converti l'hote en chaine de caractère
            String s = hote.toString();
            data[i] = s;
        }
        listDesHotes = new JList<>(data);
        listDesHotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(scrollPane);
        this.add(listDesHotes, BorderLayout.CENTER);

        //Appel du constructeur builAside avec uniquement les deux bouton si pas de parametre passé dans le constructeur
        if (!withoutAside) {
            this.buildAside();
        }
    }

    //Constructeur sans parametre
    public HoteList() {
        this(false);
    }

    /**
     * Methode de construction du aside
     */
    public void buildAside() {

        mainAside.add(buttonAddHote);
        mainAside.add(buttonDeleteHote);
        this.add(mainAside, BorderLayout.EAST);

        //Action Listener lors du clic sur le bouton ajouté
        //Affiche le formulaire de creation d'un nouvel hote
        buttonAddHote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                that.remove(mainAside);
                that.revalidate();
                that.repaint();
                //Ajout d'un grille 1 colonne 12 lignes pour la mise en page de l'aside
                panelHote.setLayout(new GridLayout(12, 1));
                //ajout de parametre sur le bpouton ajout du formulaire
                btnAddHote.setBackground(green);
                btnAddHote.setOpaque(true);
                btnAddHote.setBorderPainted(false);
                //ajout de parametre sur le bouton retour du formulaire
                btnBack.setBackground(red);
                btnBack.setOpaque(true);
                btnBack.setBorderPainted(false);

                //Ajout dans le panelHote du formulaire composé de ces champs
                panelHote.add(labelNom);
                panelHote.add(textFieldNom);
                //Ajout dans le panelHote du label labelAdresse + textFieldAdresse
                panelHote.add(labelPrenom);
                panelHote.add(textFieldPrenom);
                //Ajout dans le panelHote du label labelSuperficie + textFieldSuperficie
                panelHote.add(labelAge);
                panelHote.add(textFieldAge);
                //Ajout dans le panelHote du label labelTarifParNuit + textFieldNbVoyageursMaxt
                panelHote.add(labelDelai);
                panelHote.add(textFieldDelai);
                //Ajout bouton de validation
                panelHote.add(btnAddHote);
                //Ajout du bouton de retour
                panelHote.add(btnBack);

                //Action Listener lors du clic sur le bouton retour
                btnBack.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //todo retourne sur l'ecran precedent
                        panelHote.setVisible(false);
                    }
                });

                //Action Listener lors du clic sur le bouton validé
                btnAddHote.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Hote resultHotList = listHote.getSelectedHote();

                        String resultNom = "";
                        if (textFieldNom.getText().trim().length() > 0) {
                            resultNom = textFieldNom.getText();
                        }
                        String resultPrenom = "";
                        if (textFieldPrenom.getText().trim().length() > 0) {
                            resultPrenom = textFieldPrenom.getText();
                        }
                        int resultAge = 0;
                        if (textFieldAge.getText().trim().length() > 0) {
                            resultAge = Integer.parseInt(textFieldAge.getText());
                        }
                        int resultDelaiReponse = 0;
                        if (textFieldDelai.getText().trim().length() > 0) {
                            resultDelaiReponse = Integer.parseInt(textFieldDelai.getText());
                        }

                        if (resultNom != null && resultPrenom != null && resultAge != 0 && resultDelaiReponse != 0) {
                            System.out.println(resultNom + "" + resultPrenom + "" + resultAge + "" + resultDelaiReponse);
                            Hote addHote = new Hote(resultNom, resultPrenom, resultAge, resultDelaiReponse);

                            //Mise à jour de la liste des logement avec le new logement

                            list.add(addHote);
                            //System.out.println(list);
                            listDesHotes.setListData(list.stream().map(Object::toString).toArray(String[]::new));
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

        buttonDeleteHote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hote resultHoteList = getSelectedHote();
                list.remove(resultHoteList);
                listDesHotes.setListData(list.stream().map(Object::toString).toArray(String[]::new));
            }
        });
    }

    public Hote getSelectedHote() {
        List<String> selection = listDesHotes.getSelectedValuesList();
        if (selection.size() > 0) {
            String hoteString = selection.get(0);
            List<Hote> list = AirBnBData.getInstance().getHotes();

            /*
            Version 8 BG ©JHeissler
            return list.stream()
                .filter(hote -> hote.toString().equals(hoteString)) // Ne garde que ceux qui respecte le test
                .findFirst() // On recupère le premier ou aucun Optional<Hote>
                .orElseGet(null); // On récupère cette valeur ou null si elle n'existe pas
            */

            for (Hote h : list) {
                if (h.toString().equals(hoteString)) {
                    return h;
                }
            }
            return null;
        } else {
            return null;
        }
    }
}
