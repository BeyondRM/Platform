package brm.platform.gamedata;


/**
 * The platform static data. Perhaps this module could contain the attributes and conditions?
 * @author Gregory
 * @see #instance instance
 * @see #PlatformGamedata() PlatformGamedata()
 */
public class PlatformGamedata {
  /**
   * The default {@link PlatformGamedata} instance.
   * @see #PlatformGamedata
   */
  public static final PlatformGamedata instance;

  static {
    instance = new PlatformGamedata();
  }

  private PlatformGamedata() {
  }
}
