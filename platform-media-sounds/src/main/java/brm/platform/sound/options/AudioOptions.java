package brm.platform.sound.options;


/**
 * <h2>AudioOptions</h2>
 * The audio options. This utility class contains fields and methods for the various audio options.
 * <p/>
 * Currently, this is used for handling the variables associated with two aspects of the audio system: the muted state,
 * and the volume multiplier. Each aspect has four associated variables: one each for master, music, sound-effect, and
 * system sounds.
 * <p/>
 * Also, our "sound manager" singleton class should be the only class that needs direct access to this class; it should
 * normally be accessed through the sound manager object.
 * @author Gregory
 * @see #changed changed
 * @see #loaded loaded
 * @see #muteAll muteAll
 * @see #muteMus muteMus
 * @see #muteSfx muteSfx
 * @see #muteSys muteSys
 * @see #volumeAll volumeAll
 * @see #volumeMus volumeMus
 * @see #volumeSfx volumeSfx
 * @see #volumeSys volumeSys
 */
public class AudioOptions {
  /**
   * Whether options are changed.
   */
  private boolean changed = false;
  /**
   * Whether options are loaded.
   */
  private boolean loaded = false;
  /**
   * Whether to mute all audio.
   * @see muteMus muteMus
   * @see muteSfx muteSfx
   * @see muteSys muteSys
   */
  private boolean muteAll;
  /**
   * Whether to mute BGM audio.
   * @see muteAll muteAll
   */
  private boolean muteMus;
  /**
   * Whether to mute SFX audio.
   * @see muteAll muteAll
   */
  private boolean muteSfx;
  /**
   * Whether to mute SYS audio.
   * @see muteAll muteAll
   */
  private boolean muteSys;
  /**
   * The volume multiplier for all audio.
   * @see volumeMus volumeMus
   * @see volumeSfx volumeSfx
   * @see volumeSys volumeSys
   */
  private float volumeAll;
  /**
   * The volume multiplier for BGM audio.
   * @see volumeAll volumeAll
   */
  private float volumeMus;
  /**
   * The volume multiplier for SFX audio.
   * @see volumeAll volumeAll
   */
  private float volumeSfx;
  /**
   * The volume multiplier for SYS audio.
   * @see volumeAll volumeAll
   */
  private float volumeSys;

  // The volumes for music, sound effects, and system sounds are multiplied by the value for all, so that the computed volume is used.

  {
    muteAll = false;
    muteMus = false;
    muteSfx = false;
    muteSys = false;
    volumeAll = 1.0f;
    volumeMus = 1.0f;
    volumeSfx = 1.0f;
    volumeSys = 1.0f;
  }

  /**
   * A public constructor.
   * @see AudioOptions
   */
  public AudioOptions() {
  }

  /**
   * Load the options.
   * @see AudioOptions
   */
  private void load() {
    //TODO: Load the options file...
    // If an options file does not exist, we don't need to read in anything, but we should probably save() the options.
    // If an options file exists, how do we read it in? Typically as a streamed buffered object.
  }

  /**
   * Save the options.
   * @see AudioOptions
   */
  private void save() {
    //TODO: Save the options file...
    // If an options file already exists, would we like to back it up? and if a backup exists, do we delete it first?
    // For game needs, it can be text-based, so that a human can edit it, but if that's not needed, it's safe to write
    // out to a buffered stream object.
  }

  /**
   * Whether all audio is muted.
   * @return A {@link Boolean} condition.
   * @see AudioOptions
   */
  public boolean isMuteAll() {
    return muteAll;
  }

  /**
   * Whether BGM audio is muted.
   * @return A {@link Boolean} condition.
   * @see AudioOptions
   */
  public boolean isMuteMus() {
    return muteMus;
  }

  /**
   * Whether SFX audio is muted.
   * @return A {@link Boolean} condition.
   * @see AudioOptions
   */
  public boolean isMuteSfx() {
    return muteSfx;
  }

  /**
   * Whether SYS audio is muted.
   * @return A {@link Boolean} condition.
   * @see AudioOptions
   */
  public boolean isMuteSys() {
    return muteSys;
  }

  /**
   * The volume for all audio.
   * @return A {@link Float} value.
   * @see AudioOptions
   */
  public float getVolumeAll() {
    return volumeAll;
  }

  /**
   * The volume for BGM audio.
   * @return A {@link Float} value.
   * @see AudioOptions
   */
  public float getVolumeMus() {
    return volumeMus;
  }

  /**
   * The volume for SFX audio.
   * @return A {@link Float} value.
   * @see AudioOptions
   */
  public float getVolumeSfx() {
    return volumeSfx;
  }

  /**
   * The volume for SYS audio.
   * @return A {@link Float} value.
   * @see AudioOptions
   */
  public float getVolumeSys() {
    return volumeSys;
  }

  /**
   * Close the options.
   * @see AudioOptions
   */
  public void close() {
    if(loaded && changed) {
      save();
      changed = false;
      loaded = false;
    }
  }

  /**
   * Open the options.
   * @see AudioOptions
   */
  public void open() {
    if(!loaded) {
      load();
      changed = false;
      loaded = true;
    }
  }

  /**
   * Mute all audio.
   * @param b A {@link Boolean} condition, representing the {@link #muteAll muteAll} condition.
   * @see AudioOptions
   */
  public void setMuteAll(boolean b) {
    muteAll = b;
    changed = true;
  }

  /**
   * Mute BGM audio.
   * @param b A {@link Boolean} condition, representing the {@link #muteMus muteMus} condition.
   * @see AudioOptions
   */
  public void setMuteMus(boolean b) {
    muteMus = b;
    changed = true;
  }

  /**
   * Mute SFX audio.
   * @param b A {@link Boolean} condition, representing the {@link #muteSfx muteSfx} condition.
   * @see AudioOptions
   */
  public void setMuteSfx(boolean b) {
    muteSfx = b;
    changed = true;
  }

  /**
   * Mute SYS audio.
   * @param b A {@link Boolean} condition, representing the {@link #muteSys muteSys} condition.
   * @see AudioOptions
   */
  public void setMuteSys(boolean b) {
    muteSys = b;
    changed = true;
  }

  /**
   * Set the volume on all audio.
   * @param f A {@link Float} value, representing the {@link #volumeAll volumeAll} value.
   * @see AudioOptions
   */
  public void setVolumeAll(float f) {
    volumeAll = f;
    changed = true;
  }

  /**
   * Set the volume on BGM audio. This is for the background music that typically plays while our player is on the map;
   * each map may have its own background music (a small village would use a serene track, while a big city would not).
   * @param f A {@link Float} value, representing the {@link #volumeMus volumeMus} value.
   * @see AudioOptions
   */
  public void setVolumeMus(float f) {
    volumeMus = f;
    changed = true;
  }

  /**
   * Set the volume on SFX audio. This is for the sound effects such as for the battle system (attack and skill sounds)
   * or for on-map sound effects (ambience, environmental, event sounds).
   * @param f A {@link Float} value, representing the {@link #volumeSfx volumeSfx} value.
   * @see AudioOptions
   */
  public void setVolumeSfx(float f) {
    volumeSfx = f;
    changed = true;
  }

  /**
   * Set the volume on SYS audio. This is for the system-operation sounds, such as menu-based operations (selection,
   * cancel, navigation, et cetera) that give aural feedback to our player.
   * @param f A {@link Float} value, representing the {@link #volumeSys volumeSys} value.
   * @see AudioOptions
   */
  public void setVolumeSys(float f) {
    volumeSys = f;
    changed = true;
  }
}
