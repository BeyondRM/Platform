package brm.platform;
import brm.platform.architecture.loadable.Loadable;
import brm.platform.architecture.loadable.progress.ProgressBar;
import brm.platform.attributes.PlatformAttributes;
import brm.platform.chronology.PlatformChronology;
import brm.platform.graphics.PlatformGraphics;
import brm.platform.items.PlatformItems;
import brm.platform.maps.PlatformMaps;
import brm.platform.races.PlatformRaces;
import brm.platform.sound.PlatformSound;
import brm.platform.system.PlatformSystem;
import brm.platform.vocabulary.PlatformVocabulary;
import brm.platform.window.PlatformWindowControls;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
//import brm.platform.characters.PlatformCharacters;
//import brm.platform.classes.PlatformClasses;
//import brm.platform.conditions.PlatformConditions;
//import brm.platform.graphics.PlatformGraphicsAbstract;
//import brm.platform.graphics.animations.PlatformGraphicsAnimations;
//import brm.platform.graphics.balloons.PlatformGraphicsBalloons;
//import brm.platform.graphics.iconsets.PlatformGraphicsIconsets;
//import brm.platform.graphics.tilesets.PlatformGraphicsTilesets;
//import brm.platform.monsters.PlatformMonsters;
//import brm.platform.screenui.ScreenStatic;
//import brm.platform.skills.PlatformSkills;
//import brm.platform.system.battling.PlatformSystemBattling;
//import brm.platform.system.crafting.PlatformSystemCrafting;
//import brm.platform.system.questing.PlatformSystemQuesting;
//import brm.platform.vehicles.PlatformVehicles;


/**
 * Platform static module initialization and game instantiation. This class provides complete initialization and
 * validation of all platform modules that exist, including the loading of both engine and game data.
 * <p>
 * TODO: At some point, I really should create an independent testing framework for these modules.....
 * @author Gregory
 * @see #instance instance
 * @see #initEngine(File,String[],int,int) initEngine(File,String[],int,int)
 */
public final class Platform {
  /**
   * The default instance.
   * <h1>How RPG Maker VX Ace loads things.</h1>
   * For a normal game, RPG Maker VX Ace's RGSS system loads things in this order, by default:
   * <pre>
   *    $data_actors        = load_data("Data/Actors.rvdata2")
   *    $data_classes       = load_data("Data/Classes.rvdata2")
   *    $data_skills        = load_data("Data/Skills.rvdata2")
   *    $data_items         = load_data("Data/Items.rvdata2")
   *    $data_weapons       = load_data("Data/Weapons.rvdata2")
   *    $data_armors        = load_data("Data/Armors.rvdata2")
   *    $data_enemies       = load_data("Data/Enemies.rvdata2")
   *    $data_troops        = load_data("Data/Troops.rvdata2")
   *    $data_states        = load_data("Data/States.rvdata2")
   *    $data_animations    = load_data("Data/Animations.rvdata2")
   *    $data_tilesets      = load_data("Data/Tilesets.rvdata2")
   *    $data_common_events = load_data("Data/CommonEvents.rvdata2")
   *    $data_system        = load_data("Data/System.rvdata2")
   *    $data_mapinfos      = load_data("Data/MapInfos.rvdata2")</pre>
   * Note that battle-tests do not use the map-information, because battle-tests do nothing on maps; so they do not get
   * loaded at all. After that, the RPG Maker DataManager will create the game objects:
   * <pre>
   *    $game_temp          = Game_Temp.new
   *    $game_system        = Game_System.new
   *    $game_timer         = Game_Timer.new
   *    $game_message       = Game_Message.new
   *    $game_switches      = Game_Switches.new
   *    $game_variables     = Game_Variables.new
   *    $game_self_switches = Game_SelfSwitches.new
   *    $game_actors        = Game_Actors.new
   *    $game_party         = Game_Party.new
   *    $game_troop         = Game_Troop.new
   *    $game_map           = Game_Map.new
   *    $game_player        = Game_Player.new</pre>
   * These above objects are for game-use only; battle-tests will not see them....<p>
   * But in our case, this class constructor should be able to instantiate things in a non-specific order, so long as a
   * post-loading method validates everything as being valid. This depends upon the Editor and Project infrastructures,
   * such as they are, as having written project data in the correct manner.
   * @see Platform
   */
  public static final Platform instance;

  static {
    instance = new Platform();
  }

  /**
   * The loadable modules array.
   * @see Platform
   * @see Loadable
   */
  private final List<Loadable> loadables;
  /**
   * Whether loaded.
   * @see Platform
   */
  private boolean loaded;
  /**
   * Whether validated.
   * @see Platform
   */
  private boolean validated;

  /**
   * A private constructor. This instantiates the {@link #loadables loadables} object, and adds core platform modules;
   * additional custom loadable objects are added through {@link #addLoadable(Loadable) addLoadable(Loadable)}.
   * @see Platform
   */
  private Platform() {
    // first, the static content that does not change during a game:
    loadables = new ArrayList<>(0);
    /**
     * First: the basics. Add the things which MUST be defined, and are static across ALL gaming.
     */
    loadables.add(PlatformAttributes.instance); // Can attributes and conditions go together in a module?
    loadables.add(PlatformChronology.instance); // Should the chronology definition be part of the PlatformSystem data?
    loadables.add(PlatformGraphics.instance);
    loadables.add(PlatformItems.instance);
    loadables.add(PlatformMaps.instance);
    loadables.add(PlatformRaces.instance);
    loadables.add(PlatformSound.instance);
    loadables.add(PlatformSystem.instance);
    loadables.add(PlatformVocabulary.instance);
    loadables.add(PlatformWindowControls.instance);
    /**
     * Second: the extras. Add the things which may be most relevant to game-related things, though are defined for the
     * platform because they don't change. (The Events module is a good example.)
     * <p/>
     * Of the following, perhaps the Characters, Classes, Conditions, Monsters, Skills, Vehicles, and the System units,
     * for Battling, Crafting, and Questing, -- should all be moved into the first section.
     */
    loadables.add(PlatformCharacters.instance);
    loadables.add(PlatformClasses.instance);
    loadables.add(PlatformConditions.instance);
    loadables.add(PlatformGraphicsAbstract.instance);
    loadables.add(PlatformGraphicsAnimations.instance);
    loadables.add(PlatformGraphicsBalloons.instance);
    loadables.add(PlatformGraphicsIconsets.instance);
    loadables.add(PlatformGraphicsTilesets.instance);
    loadables.add(PlatformMonsters.instance);
    loadables.add(PlatformSkills.instance);
    loadables.add(PlatformSystemBattling.instance);
    loadables.add(PlatformSystemCrafting.instance);
    loadables.add(PlatformSystemQuesting.instance);
    loadables.add(PlatformVehicles.instance);
//  loadables.add(PlatformEvents.instance);    // Maybe should not define events in platform module? or perhaps so?
//  loadables.add(PlatformVariables.instance); // Maybe should not define variables in platform module? or maybe so?
    //TODO: Finish the instantiation of various Loadable-implementing classes....
    // 1. The following platform modules should have a class implementing Loadable but do not: platform-screenui;
    // 2. The following engine modules should have a class implementing Loadable but do not: engine-configuration;
    //      engine-content; engine-inputs; engine-system; engine-system-battling; engine-system-crafting;
    //      engine-system-questing;
    // 3. Either module engine or engine-common should probably have a similar class handling loading the classes from
    //      point number 4, above....
    // 4. Finalize everything loading, so that an actual game can run, setting up both the platform modules and engine
    //      modules.
    //TODO: Double-check these loadable modules as only containing the static definitions, and not the things which are
    // saved with a game-save....
  }

  /**
   * Whether loaded. If everything is loaded, we return true; else we may need some more relevant error-handling to say
   * what went wrong.
   * @return A {@link Boolean} condition.
   * @see Platform
   */
  public boolean isLoaded() {
    if(!loaded || !validated) {
      return false;
    } else {
      for(Loadable loading : loadables) {
        if(!loading.isDataLoaded() || !loading.isDataValidated()) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Add a loadable object. This method allows adding in additional third-party modules to be initialized and validated
   * by the platform core.
   * @param l A {@link Loadable} object, representing a loadable module.
   * @see Platform
   */
  public synchronized void addLoadable(Loadable l) {
  }

  /**
   * Initialize the platform. This static method initializes the various classes extending {@link Loadable} to provide a
   * list of classes, each providing their own aspect of the overall game content.
   * <p>
   * The internals of this method merely perform an iteration through the various methods defined within Loadable; that
   * means a few repeated {@code for} loops. First, we validate the parameters as possible. Second, we iterate through
   * pre-initialization of each module, providing a unique file reference that each module will handle. Next, we create
   * a simple progress-bar container and iterate through before, during, and finish initialization states. Finally, the
   * method iterates one last time, attempting to validate each module as necessary.
   * <p>
   * To use this in the game state which loads initializes the engine, obtain a root File object, then call this method
   * with the parameters for the file and some basic strings:
   * <pre>
   *     File file = ... ; // omitting setting this object, for simplicity...
   *     // a simple array of text for the progress bar (may be localized)...
   *     String[] strings = new String[] {
   *       "Starting Program and Loading Data",
   *       "Program Initialization",
   *       "{a subtask}"
   *     };
   *     Platform.initEngine(file, strings);</pre>
   * <br>
   * And with that, the game state should automatically begin iterating through the modules, loading the game contents,
   * and validating them when done.
   * @param f A {@link File} object, representing the root path to analyze.
   * @param s A {@link String} array, representing the beginning progress-bar text.
   * @param w An {@link Integer} value, representing the screen half-width.
   * @param h An {@link Integer} value, representing the screen half-height.
   * @see Platform
   * @see Loadable
   * @see ScreenStatic
   * @see BufferedImage
   * @see ProgressBar
   */
  public synchronized void initEngine(File f, String[] s, int w, int h) {
    // pre-initialization setup
    for(Loadable loadable : loadables) {
      loadable.beforeInitialization(0L, f, "");
    }
    // initialize before, with progress bar
    ProgressBar pb = new ProgressBar(null, false, false, w / 2, h / 4, w, h, s[1]);
    for(Loadable loadable : loadables) {
      loadable.initializeBefore(pb);
    }
    // initialize during, with progress bar
    for(Loadable loadable : loadables) {
      loadable.initializeDuring(pb);
    }
    // initialize finish, with progress bar
    for(Loadable loadable : loadables) {
      loadable.initializeFinish(pb);
    }
    // post-initialization validation
    for(Loadable loadable : loadables) {
      loadable.validation();
    }
  }

  /**
   */
}
