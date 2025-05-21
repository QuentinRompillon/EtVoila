import javax.sound.sampled.*;
import java.io.IOException;

public class Audio {
    
    private Clip clip;
    //String menuMusic = "src/music/music2.wav";
    //String gameMusic = "src/music/music1.wav";
    public static boolean menuMusicPlayed = false;

    public void PlayMusic(int number) {
        try {
            if (number == 1) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getResource("/music/music1.wav"));
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            if (number == 2) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getResource("/music/music2.wav"));
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                menuMusicPlayed = true;
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
