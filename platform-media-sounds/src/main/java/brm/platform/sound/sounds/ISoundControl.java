package brm.platform.sound.sounds;


/**
 *
 * @author Gregory
 */
public interface ISoundControl {
  /**
   * A public getter method to obtain whether the sound is cancelable.
   * @return A {@link Boolean} condition.
   */
  abstract public boolean isCancelable();

  /**
   * A public getter method to obtain whether the sound is canceling.
   * @return A {@link Boolean} condition.
   */
  abstract public boolean isCanceling();

  /**
   * A public getter method to obtain whether the sound is loopable.
   * @return A {@link Boolean} condition.
   */
  abstract public boolean isLoopable();

  /**
   * A public getter method to obtain whether the sound is looping.
   * @return A {@link Boolean} condition.
   */
  abstract public boolean isLooping();

  /**
   * A public getter method to obtain whether the sound is pausable.
   * @return A {@link Boolean} condition.
   */
  abstract public boolean isPausable();

  /**
   * A public getter method to obtain whether the sound is pausing.
   * @return A {@link Boolean} condition.
   */
  abstract public boolean isPausing();

  /**
   * A public getter method to obtain whether the sound is playable.
   * @return A {@link Boolean} condition.
   */
  abstract public boolean isPlayable();

  /**
   * A public getter method to obtain whether the sound is playing.
   * @return A {@link Boolean} condition.
   */
  abstract public boolean isPlaying();

  /**
   * Set the sound as canceled or not canceled, based upon the parameter.
   * @param b A {@link Boolean} condition, representing if the sound is canceled.
   */
  abstract public void setCanceling(boolean b);

  /**
   * Set the sound as looping or not looping, based upon the parameter.
   * @param b A {@link Boolean} condition, representing if the sound is looping.
   */
  abstract public void setLooping(boolean b);

  /**
   * Set the sound as pausing or not pausing, based upon the parameter.
   * @param b A {@link Boolean} condition, representing if the sound is pausing.
   */
  abstract public void setPausing(boolean b);

  /**
   * Set the sound as playing or not playing, based upon the parameter.
   * @param b A {@link Boolean} condition, representing if the sound is playing.
   */
  abstract public void setPlaying(boolean b);
}
