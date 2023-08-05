package org.cis1200.eightoneninetwo;

import javax.swing.*;
import java.awt.*;

/**
 * This class sets up the top-level frame and widgets for the GUI.
 * 
 * This game adheres to a Model-View-Controller design framework. This
 * framework is very effective for turn-based games.
 * 
 * In a Model-View-Controller framework, Game initializes the view,
 * implements a bit of controller functionality through the reset
 * button, and then instantiates a GameBoard. The GameBoard will
 * handle the rest of the game's view and controller functionality, and
 * it will instantiate an 8192 object to serve as the game's model.
 */
public class Run8192 implements Runnable {
    public void run() {
        // Top-level frame in which game components live
        final JFrame frame = new JFrame("8192");
        frame.setLocation(300, 300);

        // Status panel
        final JPanel status_panel = new JPanel();
        status_panel.setPreferredSize(new Dimension(Gameboard8192.BOARD_WIDTH, 30));
        frame.add(status_panel, BorderLayout.SOUTH);
        final JLabel status = new JLabel("Setting up...");
        status_panel.add(status);

        // Game board
        final Gameboard8192 board = new Gameboard8192(status);
        frame.add(board, BorderLayout.CENTER);

        // Reset button
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);

        // Note here that when we add an action listener to the reset button, we
        // define it as an anonymous inner class that is an instance of
        // ActionListener with its actionPerformed() method overridden. When the
        // button is pressed, actionPerformed() will be called.
        final JButton reset = new JButton("Reset");
        reset.addActionListener(e -> board.reset());
        control_panel.add(reset);

        // Load button
        final JButton load = new JButton("Load");
        load.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int option = chooser.showOpenDialog(null);
            if (option == JFileChooser.APPROVE_OPTION) {
                String filename = chooser.getSelectedFile().getAbsolutePath();
                board.loadGame(filename);
            }
        });
        control_panel.add(load);

        // Save button
        final JButton save = new JButton("Save");
        save.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int option = chooser.showSaveDialog(null);
            if (option == JFileChooser.APPROVE_OPTION) {
                String filename = chooser.getSelectedFile().getAbsolutePath();
                board.saveGame(filename);
            }
        });
        control_panel.add(save);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start the game
        board.reset();

        // Instructions window
        JOptionPane.showMessageDialog(
                frame,
                "This is the game 8192! " +
                        "You can use the left, right, up, down, A, D, W, or S arrows to move. " +
                        "Once you reach 8192 in a cell, the game will end."
        );
    }
}