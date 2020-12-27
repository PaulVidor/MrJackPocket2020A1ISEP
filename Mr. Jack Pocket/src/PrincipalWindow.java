import javax.swing.*;
import java.awt.*;

public class PrincipalWindow extends JFrame{
    public JFrame PrincipalWindow;

    PrincipalWindow(){

        //Initialisation de la fenêtre
        this.PrincipalWindow = new JFrame();
        this.PrincipalWindow.setTitle("Mr. Jack Pocket");
        this.PrincipalWindow.setSize(10000,1000);
        this.PrincipalWindow.setResizable(true);
        this.PrincipalWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.PrincipalWindow.setLayout(null);
        this.PrincipalWindow.setVisible(true);

        //Mise en avant du rôle
        JLabel lblColor = new JLabel("Votre rôle est: ");
        lblColor.setBounds(1500,50, 200, 20);
        lblColor.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        this.PrincipalWindow.add(lblColor);

        //Detective phrase
        JLabel lblColorD = new JLabel("Détective ");
        lblColorD.setBounds(1500,50, 200, 100);
        lblColorD.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        this.PrincipalWindow.add(lblColorD);

        //MisterJack phrase
        JLabel lblColorJ = new JLabel("MisterJack ");
        lblColorJ.setBounds(1600,50, 200, 100);
        lblColorJ.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        this.PrincipalWindow.add(lblColorJ);

        //Case Detective
        JTextField tfCaseDep = new JTextField();
        tfCaseDep.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        tfCaseDep.setBounds(1500,150, 60, 150);
        this.PrincipalWindow.add(tfCaseDep);

        //Case MisterJack
        JTextField tfCaseDepM = new JTextField();
        tfCaseDepM.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        tfCaseDepM.setBounds(1600,150, 60, 150);
        this.PrincipalWindow.add(tfCaseDepM);

        //Différentes cases
        Plateau plateau = new Plateau();
        plateau.setBounds(0,-70, 1000, 1000);
        this.PrincipalWindow.add(plateau);


    }


}
