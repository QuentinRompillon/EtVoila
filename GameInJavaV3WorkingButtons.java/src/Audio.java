import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    
    private Clip clip;

    public void PlayMusic(String path) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();

        }
    }
    public void StopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
