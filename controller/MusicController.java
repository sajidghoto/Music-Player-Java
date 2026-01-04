package controller;

import modules.MusicModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicController implements ActionListener {
    private MusicModel model;
     JTextField filePathField;
    private JButton playButton;
    private JButton pauseButton;
    private JButton loopButton;

    public MusicController(MusicModel model, JTextField filePathField, JButton playButton, JButton pauseButton, JButton loopButton) {
        this.model = model;
        this.filePathField = filePathField;
        this.playButton = playButton;
        this.pauseButton = pauseButton;
        this.loopButton = loopButton;

        playButton.addActionListener(this);
        pauseButton.addActionListener(this);
        loopButton.addActionListener(this);
        filePathField.addActionListener(this);

    }

    private void playMusic() {
        try {
            String filePath = filePathField.getText();
            model.play(filePath);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error playing music: " + e.getMessage());
        }
    }

    private void pauseMusic() {
        model.pause();
    }

    private void toggleLoop() {
        model.toggleLoop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            playMusic();
        }else if (e.getSource() == pauseButton) {
            pauseMusic();
        }else if (e.getSource() == loopButton) {
            toggleLoop();
        }
    }
}