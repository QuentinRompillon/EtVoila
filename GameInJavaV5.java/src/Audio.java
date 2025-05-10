import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    
    private Clip clip;
    String menuMusic = "src/music/music1.wav";
    String gameMusic = "";

    public void PlayMusic(int number) {
        try {
            if (number == 1) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(menuMusic));
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
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
