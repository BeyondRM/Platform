package brm.platform.sound.sounds;


/**
 *
 * @author Gregory
 */
public class SoundBGS extends ArpgmSound {

  public SoundBGS() {
    super(null, null);
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
