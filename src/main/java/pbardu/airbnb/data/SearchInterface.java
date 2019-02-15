package pbardu.airbnb.data;

import pbardu.airbnb.logements.Logement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchInterface extends JPanel {

    private JButton buttonSearch = new JButton("Rechercher");



    public SearchInterface()    {

        // Je créée un layout de la Class BoxLayout pour afficher les panel à la vertical centré
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // J'instancie mes textField
        JTextField nbVoyageurs = new JTextField(15);
        JTextField minPrice = new JTextField(15);
        JTextField maxPrice = new JTextField(15);


        //J'instancie mes checkBox
        JCheckBox checkBoxPiscine = new JCheckBox("Je veux une piscine !");
        JCheckBox checkBoxBalcon = new JCheckBox("Je veux un balcon !");
        JCheckBox checkBoxJardin = new JCheckBox("Je veux un Jardin !");

        //J'instancie un panel pour le nombre de voyageur afin de l'afficher à l'horizontal
        JPanel panelNbVoyageur = new JPanel();
        panelNbVoyageur.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelNbVoyageur.add(new JLabel("Nombre de voyageurs * : "));
        panelNbVoyageur.add(nbVoyageurs);
        this.add(panelNbVoyageur);


        //J'instancie un panel pour le prix minimun afin de l'afficher à l'horizontal
        JPanel panelMinPrice = new JPanel();
        panelMinPrice.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelMinPrice.add(new JLabel("Prix minimum : "));
        panelMinPrice.add(minPrice);
        this.add(panelMinPrice);

        JPanel panelMaxPrice = new JPanel();
        panelMaxPrice.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelMaxPrice.add(new JLabel("Prix maximum : "));
        panelMaxPrice.add(maxPrice);
        this.add(panelMaxPrice);

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        checkBoxPanel.add(checkBoxBalcon);
        checkBoxPanel.add(checkBoxJardin);
        checkBoxPanel.add(checkBoxPiscine);
        this.add(checkBoxPanel);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonSearch);
        this.add(buttonPanel);


        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int resultNbVoyageurs = 0;
                if (nbVoyageurs.getText().trim().length() > 0){
                    resultNbVoyageurs = Integer.parseInt(nbVoyageurs.getText());
                }

                int resultPrixMini = 0;
                if(minPrice.getText().trim().length() > 0) {
                    resultPrixMini = Integer.parseInt(minPrice.getText());
                }

                int resultPrixMAxi = Integer.MAX_VALUE;
                if(maxPrice.getText().trim().length() > 0) {
                    resultPrixMAxi = Integer.parseInt(maxPrice.getText());
                }

                boolean resultCheckBoxPiscine = false;

                if (checkBoxPiscine.isSelected()){

                        resultCheckBoxPiscine  = true;
                }
                boolean resultCheckBoxBalcon = false;
                if (checkBoxBalcon.isSelected()){

                    resultCheckBoxBalcon = true;
                }

                boolean resultCheckBoxJardin = false;

                if (checkBoxJardin.isSelected()){
                    resultCheckBoxJardin = true;
                }

                JFrame viewResultSearch = new JFrame();

                JPanel panel = new JPanel();

                viewResultSearch.setTitle("Resultat de la recherche");
                //On donne un titre a l'application
                viewResultSearch.setSize(350,500);
                // On donne une taille a notre fenetre
                viewResultSearch.setLocationRelativeTo(null);
                // On centre la fenetre sur l'ecran
                viewResultSearch.setResizable(true);

                Search.SearchBuilder submitResearch = new Search.SearchBuilder(resultNbVoyageurs)
                        .tarifMinParNuit(resultPrixMini)
                        .tarifMaxParNuit(resultPrixMAxi)
                        .possedePiscine(resultCheckBoxPiscine)
                        .possedeBalcon(resultCheckBoxBalcon)
                        .possedeJardin(resultCheckBoxJardin);
                Search search = submitResearch.build();

                ArrayList<Logement> logements = search.result();
                for (Logement logement: logements) {
                    JLabel label = new JLabel("<html>"+logement.toString()+"</html>");
                    panel.add(label);

                }
                viewResultSearch.setContentPane(panel);
                viewResultSearch.setVisible(true);
            }
        });



    }
}
