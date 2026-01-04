package view;

import controller.MusicController;
import modules.MusicModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MusicPlayerGUI extends JFrame {
    private JTextField filePathField;
    private JButton chooseButton;
    private JButton playButton;
    private JButton pauseButton;
    private JButton loopButton;

    public MusicPlayerGUI() {
        super("Music Player");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        filePathField = new JTextField(20);
        chooseButton = new JButton("Choose File");
        playButton = new JButton("Play");
        pauseButton = new JButton("Pause/Resume");
        loopButton = new JButton("Loop");

        add(filePathField);
        add(chooseButton);
        add(playButton);
        add(pauseButton);
        add(loopButton);

        // Create the model and controller
        MusicModel model = new MusicModel();
        new MusicController(model, filePathField, playButton, pauseButton, loopButton);

        // Add action listener for the choose button
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });

        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Audio Files", "wav", "mp3", "aiff", "m4a"));
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Get the selected file and set its path in the text field
            String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
            filePathField.setText(selectedFilePath);
        }
    }

}