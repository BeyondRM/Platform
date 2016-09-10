package brm.platform.sound;
import brm.platform.architecture.loadable.Loadable;
import brm.platform.architecture.loadable.progress.ProgressBar;
import brm.platform.sound.options.AudioOptions;
import brm.platform.sound.sounds.AudioClip;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The platform sound manager. This provides links to sound clips, and manages the playing of them.
 * @author Gregory
 */
//TODO: Need a general methodology of how audio is initialized and sound clips are loaded, played, unloaded, whatever.
// Should probably do some pre-checking at the time of game launch, when things are starting up.
public final class PlatformSound extends Loadable {
  /**
   * The class singleton instance.
   */
  public static final PlatformSound instance;

  static {
    instance = new PlatformSound();
  }

  /**
   * The audio options. This is the general user-preference options for mute states and volumes.
   */
  private final AudioOptions options;
  /**
   * A list of all the background music clips. Currently, this loads the following sounds:
   * <pre>
   *    Name:       Path:
   *    ==========  ============================
   *    level1      /sounds/bgmus/level1.mp3
   *    level1boss  /sounds/bgmus/level1boss.mp3
   *    level2      /sounds/bgmus/level2.mp3
   *    fanfare     /sounds/bgmus/fanfare.mp3
   * </pre>
   */
  private final Map<String, AudioClip> mus;
  /**
   * A list of all the sound effects clips. Currently, this loads the following sounds:
   * <pre>
   *    Name:         Path:
   *    ============  ==============================
   *    enemyhit      /sounds/bgsfx/enemyhit.mp3
   *    explode       /sounds/bgsfx/explode.mp3
   *    playerattack  /sounds/bgsfx/playerattack.mp3
   *    playercharge  /sounds/bgsfx/playercharge.mp3
   *    playerhit     /sounds/bgsfx/playerhit.mp3
   *    playerjump    /sounds/bgsfx/playerjump.mp3
   *    playerlands   /sounds/bgsfx/playerlands.mp3
   *    teleport      /sounds/bgsfx/teleport.mp3
   * </pre>
   */
  private final Map<String, AudioClip> sfx;
  /**
   * A list of all the system sounds clips. Currently, this loads the following sounds:
   * <pre>
   *    Name:       Path:
   *    ==========  ==============================
   *    menuoption  /sounds/sysfx/menuoption.mp3
   *    menuselect  /sounds/sysfx/menuselect.mp3
   * </pre> This list should bee extended to include various other system-ui sounds, for navigating menus, et cetera.
   */
  private final Map<String, AudioClip> sys;

  private boolean activeMuteAll;
  private boolean activeMuteBGM;
  private boolean activeMuteSFX;
  private boolean activeMuteSYS;
  private float activeVolumeAll;
  private float activeVolumeBGM;
  private float activeVolumeSFX;
  private float activeVolumeSYS;

  {
    options = new AudioOptions(); // don't generally need getter/setter, but may need an init method to setup values.
    // Initialize the background musics:
    mus = new HashMap<>(0);
    mus.put("level1",
            new AudioClip(true, "/sounds/bgmus/level1.mp3"));
    mus.put("level1boss",
            new AudioClip(true, "/sounds/bgmus/level1boss.mp3"));
    mus.put("level2",
            new AudioClip(true, "/sounds/bgmus/level1v2.mp3"));
    mus.put("fanfare",
            new AudioClip(true, "/sounds/bgsfx/fanfare.mp3"));
    // Initialize the sound effects:
    sfx = new HashMap<>(0);
    sfx.put("enemyhit",
            new AudioClip(false, "/sounds/bgsfx/enemyhit.mp3"));
    sfx.put("explode",
            new AudioClip(false, "/sounds/bgsfx/explode.mp3"));
    sfx.put("playerattack",
            new AudioClip(false, "/sounds/bgsfx/playerattack.mp3"));
    sfx.put("playercharge",
            new AudioClip(false, "/sounds/bgsfx/playercharge.mp3"));
    sfx.put("playerhit",
            new AudioClip(false, "/sounds/bgsfx/playerhit.mp3"));
    sfx.put("playerjump",
            new AudioClip(false, "/sounds/bgsfx/playerjump.mp3"));
    sfx.put("playerlands",
            new AudioClip(false, "/sounds/bgsfx/playerlands.mp3"));
    sfx.put("teleport",
            new AudioClip(true, "/sounds/bgsfx/teleport.mp3"));
    // Initialize the system sounds:
    sys = new HashMap<>(0);
    sys.put("menuoption",
            new AudioClip(false, "/sounds/sysfx/menuoption.mp3"));
    sys.put("menuselect",
            new AudioClip(false, "/sounds/sysfx/menuselect.mp3"));

    //TODO: Implement a methodology to load audio clips to replace above code; above references are statically defined.
  }

  /**
   * An array of the active background music instances. Strictly speaking, only the first-indexed music will be played
   * automatically; the rest may be present to play in a linear order.
   */
  private List<String> activeBGM;
  /**
   * An array of the active sound effect instances.
   */
  private List<String> activeSFX;
  /**
   * The currently-playing background music &mdash; generally, the first item in the {@link #activeBGM activeBGM} list.
   */
  private String currentBGM;

  private PlatformSound() {
  }

  /**
   * Get the state of things. This is a list of the general state of fields accessible from this class object. It is to
   * be used when starting a menu options screen for controlling audio options. It currently provides information on if
   * our {@link #options options} object is loaded, followed by the options for global mute and volume values, and the
   * current {@link PlatformSound} overall state of operation (numbers of BGM, SFX, and SYS sounds loaded, volumes and
   * mute states).
   * @return A {@link String} list object.
   */
  public List<String> getState() {
    List<String> status = new ArrayList<>(0);
    // start with reporting on whether the options object is not null
    String stateOptions = options == null
        ? "Options NOT loaded -- check for errors."
        : "Options loaded successfully; good job dude!";
    // if the options object is not null, we can report on the muting and volume values
    if(options != null) {
      // add the global mutes
      stateOptions += String.format(" Global mute states: [ALL:%s, BGM:%s, SFX:%s, SYS:%s].",
                                    options.isMuteAll(),
                                    options.isMuteMus(),
                                    options.isMuteSfx(),
                                    options.isMuteSys());
      // add the global volumes
      stateOptions += String.format(" Global volume values: [ALL:%f, BGM:%f, SFX:%f, SYS:%f]",
                                    options.getVolumeAll(),
                                    options.getVolumeMus(),
                                    options.getVolumeSfx(),
                                    options.getVolumeSys());
    }
    status.add(stateOptions);

    return status;
  }

  @Override
  public boolean isDataLoaded() {
    return dataLoaded;
  }

  @Override
  public boolean isDataValidated() {
    return dataValidated;
  }

  @Override
  public int getInitializedCount() {
    return initializedCount;
  }

  @Override
  public void beforeInitialization(long l, File f, String s) {
  }

  @Override
  public void initializeBefore(ProgressBar pb) {
  }

  @Override
  public void initializeDuring(ProgressBar pb) {
  }

  @Override
  public void initializeFinish(ProgressBar pb) {
  }

  @Override
  public void validation() {
  }
}
