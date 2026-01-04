package modules;
import controller.MusicController;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;

public class MusicModel {
    private Clip clip;
    private boolean isLooping = false;

    public void play(String filePath) throws Exception {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }

        File file = new File(filePath);
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(ais);

        if (isLooping) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }

        clip.start();
    }

    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        } else if (clip!=null && !clip.isRunning()) {
            resume();
        }
    }

    public void resume() {
        if (clip != null) {
            clip.start();
        }
    }

    public void toggleLoop() {
        isLooping = !isLooping;
        if (clip != null) {
            if (isLooping) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.loop(0);
            }
        }
    }

    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }

}