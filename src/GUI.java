import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.Panel;

public class GUI implements ActionListener {
    private static JFrame frame;
    private static JFrame checkB;
    static int depth;
    private enum Actions {
        EASY,
        MEDIUM,
        HARD
    }

    public static void runBoard() {
        new checker();
    }

    public static void main(String[] args) {

        GUI instance = new GUI();

        frame = new JFrame("Choose Difficulty");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(250, 80);
        frame.setLocationRelativeTo(null);

        JButton easy = new JButton("Easy");
        easy.setActionCommand(Actions.EASY.name());
        easy.addActionListener(instance);
        frame.getContentPane().add(easy);

        JButton medium = new JButton("Medium");
        medium.setActionCommand(Actions.MEDIUM.name());
        medium.addActionListener(instance);
        frame.getContentPane().add(medium);

        JButton hard = new JButton("Hard");
        hard.setActionCommand(Actions.HARD.name());
        hard.addActionListener(instance);
        frame.getContentPane().add(hard);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand() == Actions.EASY.name()) {
            depth =  1;
            runBoard();
            frame.setVisible(false);
        } else if (evt.getActionCommand() == Actions.MEDIUM.name()) {
            depth = 3;
            runBoard();
            frame.setVisible(false);
        }
        else if (evt.getActionCommand() == Actions.HARD.name()) {
            depth = 5;
            runBoard();
            frame.setVisible(false);
        }

    }

}