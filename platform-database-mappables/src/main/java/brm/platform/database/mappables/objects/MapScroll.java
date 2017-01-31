package brm.platform.database.mappables.objects;


/**
 *
 * @author Gregory
 */
public enum MapScroll {
  /**
   * No map looping.
   * @see MapScroll
   */
  s0(false, false),
  /**
   * Map loops vertically.
   * @see MapScroll
   */
  s1(false, true),
  /**
   * Map loops horizontally.
   * @see MapScroll
   */
  s2(true, false),
  /**
   * Map loops both ways.
   * @see MapScroll
   */
  s3(true, true);
  public boolean h;
  public boolean v;

  private MapScroll(boolean b, boolean c) {
    h = b;
    v = c;
  }

  public static synchronized final MapScroll fromId(char c) {
    switch(c) {
      case '3':
        return s3;
      case '2':
        return s2;
      case '1':
        return s1;
      case '0':
      default:
        return s0;
    }
  }
}
