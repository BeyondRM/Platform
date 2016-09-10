package brm.platform.sound.sounds;
import abc.errorlogs.log.AbcLogger;
import deprecated.JukeBox;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * An audio clip. This is a public utility class with fields and methods for managing the properties of an audio clip.
 * @author Gregory
 */
public class AudioClip {
  /**
   * The clip resource location.
   */
  private final String clipLocation;
  /**
   * Whether the clip is disposable &hellip; if it can be cleared from memory, after being played.
   */
  private final boolean disposable;

  /**
   * The audio clip instance.
   */
  private Clip clip = null;
  /**
   * Whether the clip is opened.
   */
  private boolean open = false;
  /**
   * Whether the clip is played.
   */
  private boolean play = false;
  /**
   * The current position.
   */
  private int position = 0;
  /**
   * The loop-data, for storing the beginning and ending frames in the clip, for looping audio.
   */
  private int[] loopdata = {0, 0};

  /**
   * A public constructor to instantiate a new {@link AudioClip} object.
   * @param b A {@link Boolean} condition, representing if it is disposable.
   * @param s A {@link String} value, representing the resource location.
   */
  public AudioClip(boolean b, String s) {
    disposable = b;
    clipLocation = s;
  }

  /**
   * A private setter to set the clip as opened and ready to be played.
   */
  private void setClip() {
    if(!clipLocation.isEmpty() && clip == null) {
      try {
        AudioInputStream ais = AudioSystem.getAudioInputStream(JukeBox.class.getResourceAsStream(clipLocation));
        AudioFormat baseFormat = ais.getFormat();
        AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                                                   baseFormat.getSampleRate(),
                                                   16,
                                                   baseFormat.getChannels(),
                                                   baseFormat.getChannels() * 2,
                                                   baseFormat.getSampleRate(),
                                                   false);
        AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
        clip = AudioSystem.getClip();
        clip.open(dais);
      } catch(IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        AbcLogger.logThis(AbcLogger.L3,
                                       String.format("An exception occurred in class %s for method %s",
                                                     e.getClass(), "load(String,String)"));
      }
    }
  }

  /**
   * A public getter method to obtain whether the clip is opened.
   * @return A {@link Boolean} condition.
   */
  public boolean isOpen() {
    return open;
  }

  /**
   * A public getter method to obtain whether the clip is played.
   * @return A {@link Boolean} condition.
   */
  public boolean isPlay() {
    return play;
  }

  /**
   * A public getter method to obtain the current position in the clip.
   * @return An {@link Integer} value.
   */
  public int getPosition() {
    return position;
  }

  /**
   * A public setter method to set whether the audio clip should be open.
   * @param b A {@link Boolean} condition, representing if it is to be open.
   */
  public void setOpen(boolean b) {
    open = b;
  }

  /**
   * A public setter method to set whether the clip is playing.<p/>
   * Since this is used to set the clip to play, need to test for if open, playing, et cetera, then do certain things
   * based upon that state.
   * <ul>
   * <li/>If 'b' is true and if the clip isn't open, it needs to be; then, begin playing.
   * <li/>If 'b' is false and if the clip is playing, stop it; if the clip is open, close it;
   * </ul>
   * @param b A {@link Boolean} condition, representing if it is played.
   */
  public void setPlay(boolean b) {
    //TODO: Finish this method.
    if(b) {
    } else {
    }
    play = b;
  }

  /**
   * A public setter method to set the {@link #position position} within the audio clip.
   * @param i An {@link Integer} value, representing the clip position.
   */
  public void setPosition(int i) {
    position = i;
  }

  boolean mute = false;
  int gap = 0;

  int getFrameLength() {
    return clip.getFrameLength();
  }

  int getFramePosition() {
    return clip.getFramePosition();
  }

  void close() {
    stop();
    clip.close();
  }

  void init() {
    gap = 0;
  }

  void load(String t) {
    if(clip == null) {
      try {
        AudioInputStream ais = AudioSystem.getAudioInputStream(JukeBox.class.getResourceAsStream(t));
        AudioFormat format = ais.getFormat();
        float sampleRate = format.getSampleRate();
        int channels = format.getChannels();
        AudioFormat af = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, sampleRate, 16, channels, channels * 2, sampleRate, false);
        AudioInputStream stream = AudioSystem.getAudioInputStream(af, ais);
        clip = AudioSystem.getClip();
        clip.open(stream);
        //clips.put(s, clip);
      } catch(IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        String u = String.format("An exception occurred in class %s method %s", e.getClass(), "load(String,String)");
        AbcLogger.logThis(AbcLogger.L3, u);
      }
    }
  }

  void loop() {
    loop(gap, gap, clip.getFrameLength() - 1);
  }

  void loop(int frame) {
    loop(frame, gap, clip.getFrameLength() - 1);
  }

  void loop(int start, int end) {
    loop(gap, start, end);
  }

  void loop(int frame, int start, int end) {
    stop();
    if(!mute) {
      clip.setLoopPoints(start, end);
      clip.setFramePosition(frame);
      clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
  }

  void play() {
    play(gap);
  }

  void play(int i) {
    if(!mute) {
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

  void resume() {
    if(!mute && !clip.isRunning()) {
      clip.start();
    }
  }

  void setFramePosition(int i) {
    clip.setFramePosition(i);
  }

  void stop() {
    if(clip != null && clip.isRunning()) {
      clip.stop();
    }
  }
}
