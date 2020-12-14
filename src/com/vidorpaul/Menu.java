package com.vidorpaul;
import javax.swing.*;
import java.awt.*;

public class Menu {
    public JFrame Menu;

    public Menu() {
        JFrame frame = new JFrame("Mr Jack Pocket");

        JLabel label = new JLabel("Voulez-vous débuter la partie", JLabel.CENTER);
        frame.add(label);

        // Définissez le panel
        JPanel panel = new JPanel();
        // Créer des boutons radio
        ButtonGroup group = new ButtonGroup();
        JRadioButton radio1 = new JRadioButton("OUI", true);
        JRadioButton radio2 = new JRadioButton("NON", false);
        // Ajouter les boutons radio au groupe
        group.add(radio1);
        group.add(radio2);

        // Ajouter les boutons au frame
        panel.add(radio1);
        panel.add(radio2);

        // Ajouter label et panel au frame
        frame.setLayout(new GridLayout(2, 1));
        frame.add(label);
        frame.add(panel);

        frame.pack();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
