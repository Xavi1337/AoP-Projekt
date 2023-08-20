package Game;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;

public class SoundManager {
    private Clip clip;

    public void loadSound(String soundFileName) {
        try {
            URL soundURL = getClass().getResource(soundFileName);
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundURL));
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void playSound() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }
}
