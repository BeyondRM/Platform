package deprecated;
import abc.errorlogs.log.AbcLogger;
import java.io.IOException;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * The jukebox. This is to be revamped into my own format of an audio management class.
 * <p/>
 * This utility class with static fields and methods for managing the various play-time aspects of the audio clips that
 * are used in the game.
 * @author Gregory
 */
public class JukeBox {
  /**
   * The clips map. This array of sound clip objects represent the playable audio clips.
   */
  private static final Map<String, Clip> clips;
  /**
   * Whether audio is muted. This condition is for controlling the mute state.
   * <p/>
   * Error: this is checked in code, but not set anywhere but here -- always false!
   */
  private static final boolean mute;
  /**
   * The current gap. This value represents the position within the audio clip.
   * <p/>
   * Error: this is checked in code, but not set anywhere but here -- always zero!
   */
  private static int gap;

  static {
    clips = new HashMap<>(20);
    mute = false;
  }

  private JukeBox() {
  }

  /**
   * Get the total frames within the audio clip.
   * @param s A {@link String} object, representing the identifiable clip name.
   * @return An {@link Integer} value.
   */
  public static int getFrames(String s) {
    return clips.get(s).getFrameLength();
  }

  /**
   * Get the number of frames into the audio clip.
   * @param s A {@link String} object, representing the identifiable clip name.
   * @return An {@link Integer} value.
   */
  public static int getPosition(String s) {
    return clips.get(s).getFramePosition();
  }

  /**
   * Stop playing an audio clip, if it is playing.
   * @param s A {@link String} object, representing the identifiable clip name.
   */
  public static void close(String s) {
    stop(s);
    clips.get(s).close();
  }

  /**
   * Initialize the jukebox object.
   */
  public static void init() { // Used only in GameStateManager initialization.
    gap = 0;
  }

  /**
   * @param s A {@link String} object, representing the identifiable clip name.
   * @param t A {@link String} object, representing
   */
  public static void load(String s, String t) {
    if(clips.get(s) == null) {
      AudioInputStream ais;
      try {
        ais = AudioSystem.getAudioInputStream(JukeBox.class.getResourceAsStream(t));
        AudioFormat format = ais.getFormat();
        float sampleRate = format.getSampleRate();
        int channels = format.getChannels();
        AudioFormat af = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, sampleRate, 16, channels, channels * 2, sampleRate, false);
        AudioInputStream stream = AudioSystem.getAudioInputStream(af, ais);
        Clip clip = AudioSystem.getClip();
        clip.open(stream);
        clips.put(s, clip);
      } catch(UnsupportedAudioFileException ex) {
        String s1 = String.format("JukeBox.load(String,String) caught an UnsupportedAudioFileException; clipname:%s filename:%s", s, t);
        AbcLogger.logThis(AbcLogger.L1, s1, ex);
      } catch(IOException ex) {
        String s1 = String.format("JukeBox.load(String,String) caught an IOException; clipname:%s filename:%s", s, t);
        AbcLogger.logThis(AbcLogger.L1, s1, ex);
      } catch(LineUnavailableException ex) {
        String s1 = String.format("JukeBox.load(String,String) caught a LineUnavailableException; clipname:%s filename:%s", s, t);
        AbcLogger.logThis(AbcLogger.L1, s1, ex);
//    } finally {
//      try {
//        ais.close();
//      } catch(IOException ex) {
//        AbcLogger.logThis(AbcLogger.L1, null, ex);
//      }
      }
    }
  }

  /**
   * @param s A {@link String} object, representing the identifiable clip name.
   */
  public static void loop(String s) {
    loop(s, gap, gap, clips.get(s).getFrameLength() - 1);
  }

  /**
   * @param s     A {@link String} object, representing the identifiable clip name.
   * @param frame
   */
  public static void loop(String s, int frame) {
    loop(s, frame, gap, clips.get(s).getFrameLength() - 1);
  }

  /**
   * @param s     A {@link String} object, representing the identifiable clip name.
   * @param start
   * @param end
   */
  public static void loop(String s, int start, int end) {
    loop(s, gap, start, end);
  }

  /**
   * @param s     A {@link String} object, representing the identifiable clip name.
   * @param frame
   * @param start
   * @param end
   */
  public static void loop(String s, int frame, int start, int end) {
    stop(s);
    if(!mute) {
      clips.get(s).setLoopPoints(start, end);
      clips.get(s).setFramePosition(frame);
      clips.get(s).loop(Clip.LOOP_CONTINUOUSLY);
    }
  }

  /**
   * @param s A {@link String} object, representing the identifiable clip name.
   */
  public static void play(String s) {
    play(s, gap);
  }

  /**
   * @param s A {@link String} object, representing the identifiable clip name.
   * @param i An {@link Integer} value, representing
   */
  public static void play(String s, int i) {
    if(!mute) {
      Clip clip = clips.get(s);
      if(clip != null) {
        if(clip.isRunning()) {
          clip.stop();
        }
        clip.setFramePosition(i);
        while(!clip.isRunning()) {
          clip.start();
        }
      }
    }
  }

  /**
   * Cause playback of a paused clip to resume playing.
   * @param s A {@link String} object, representing the identifiable clip name.
   */
  public static void resume(String s) { // Not used.
    if(!mute && !clips.get(s).isRunning()) {
      clips.get(s).start();
    }
  }

  /**
   * Set the position within a loaded, playable clip.
   * @param s A {@link String} object, representing the identifiable clip name.
   * @param i An {@link Integer} value, representing
   */
  public static void setPosition(String s, int i) { // Used only in Level1AState.
    clips.get(s).setFramePosition(i);
  }

  /**
   * Stop the playing of an audio clip, if not a null reference and if not playing.
   * @param s A {@link String} object, representing the identifiable clip name.
   */
  public static void stop(String s) {
    if(clips.get(s) != null && clips.get(s).isRunning()) {
      clips.get(s).stop();
    }
  }

  private Clip activeBGM = null;
  private final Deque<Clip> retainedBGM = new ConcurrentLinkedDeque<>();
  private final Deque<Clip> retainedSFX = new ConcurrentLinkedDeque<>();

  public void playActiveBGM() {}
  public void playRetainedSFX() {}
  public void pollRetainedBGM() {
    activeBGM.close();
    activeBGM = retainedBGM.pollFirst();
  }
  public void pushRetainedBGM() {
    retainedBGM.push(activeBGM);
  }
}
