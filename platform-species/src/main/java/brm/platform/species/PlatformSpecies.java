package brm.platform.species;


/**
 * <h2>PlatformSpecies</h2>
 * @author Gregory
 * @see #instance instance
 * @see #PlatformSpecies PlatformSpecies
 */
public class PlatformSpecies { //implements IPlatformLoading
  /**
   * The default {@link PlatformSpecies} instance.
   */
  public static final PlatformSpecies instance;

  static {
    instance = new PlatformSpecies();
  }

  private PlatformSpecies() {
  }
}
