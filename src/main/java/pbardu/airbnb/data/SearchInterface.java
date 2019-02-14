package pbardu.airbnb.data;

import com.sun.security.auth.module.JndiLoginModule;
import pbardu.airbnb.logements.Logement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchInterface {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel(new GridLayout(5,2));
    private JButton buttonSearch = new JButton("Rechercher");

    public SearchInterface(){

        frame.setTitle("Ma premiere fenetre");
        //On donne un titre a l'application
        frame.setSize(320,240);
        // On donne une taille a notre fenetre
        frame.setLocationRelativeTo(null);
        // On centre la fenetre sur l'ecran
        frame.setResizable(true);
        // On interdit la redimensionnement de la fenetre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setSize(150,100);
       // panel.add(new JButton("toto"));

        JTextField nbVoyageurs = new JTextField();
        JTextField MinPrice = new JTextField();
        JTextField MaxPrice = new JTextField();


        JCheckBox checkBoxPiscine = new JCheckBox("Je veux une piscine !");
        JCheckBox checkBoxBalcon = new JCheckBox("Je veux un balcon !");
        JCheckBox checkBoxJardin = new JCheckBox("Je veux un Jardin !");


        panel.add(new JLabel("Nombre de voyageurs *"));
        panel.add(nbVoyageurs);
        panel.add(new JLabel("Prix minimum"));
        panel.add(MinPrice);
        panel.add(new JLabel("Prix maximum"));
        panel.add(MaxPrice);
        panel.add(checkBoxBalcon);
        panel.add(checkBoxJardin);
        panel.add(checkBoxPiscine);
        panel.add(buttonSearch);




        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int resultNbVoyageurs = 0;
                if (nbVoyageurs.getText().trim().length() > 0){
                    resultNbVoyageurs = Integer.parseInt(nbVoyageurs.getText());
                }

                int resultPrixMini = 0;
                if(MinPrice.getText().trim().length() > 0) {
                    resultPrixMini = Integer.parseInt(MinPrice.getText());
                }

                int resultPrixMAxi = Integer.MAX_VALUE;
                if(MaxPrice.getText().trim().length() > 0) {
                    resultPrixMAxi = Integer.parseInt(MaxPrice.getText());
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
                viewResultSearch.setSize(700,500);
                // On donne une taille a notre fenetre
                viewResultSearch.setLocationRelativeTo(null);
                // On centre la fenetre sur l'ecran
                viewResultSearch.setResizable(true);

                viewResultSearch.setLayout(new BorderLayout(500,500));
                // On interdit la redimensionnement de la fenetre
                viewResultSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        frame.add(panel);
        panel.setVisible(true);
        frame.setVisible(true);

    }
}
