package brm.platform.sound.sounds;
import javax.sound.sampled.Clip;


/**
 *
 * @author Gregory
 */
abstract public class ArpgmSound implements ISoundControl {
  private boolean mute;
  private int posgap;
  private int volume;

  protected boolean cancelable;
  protected boolean canceling;
  protected boolean loopable;
  protected boolean looping;
  protected boolean pausable;
  protected boolean pausing;
  protected boolean playable;
  protected boolean playing;

  public final Clip clip;
  public final String name;

  public ArpgmSound(String s, Clip c) {
    name = s;
    clip = c;
  }

  @Override
  public boolean isCancelable() {
    return cancelable;
  }

  @Override
  public boolean isCanceling() {
    return canceling;
  }

  @Override
  public boolean isLoopable() {
    return loopable;
  }

  @Override
  public boolean isLooping() {
    return looping;
  }

  @Override
  public boolean isPausable() {
    return pausable;
  }

  @Override
  public boolean isPausing() {
    return pausing;
  }

  @Override
  public boolean isPlayable() {
    return playable;
  }

  @Override
  public boolean isPlaying() {
    return playing;
  }

  @Override
  public void setCanceling(boolean b) {
    loopable = b;
  }

  @Override
  public void setLooping(boolean b) {
    looping = b;
  }

  @Override
  public void setPausing(boolean b) {
    pausing = b;
  }

  @Override
  public void setPlaying(boolean b) {
    playing = b;
  }
}
