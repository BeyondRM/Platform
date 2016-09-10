package brm.platform.window.controls;
import brm.platform.window.skinning.WindowSkin;


/**
 * <h2>AControl</h2>
 * @author Gregory
 */
abstract public class AControl {
  protected final WindowSkin skin = WindowSkin.instance;
  protected final boolean resizable;
  protected double posX;
  protected double posY;
  protected double sizeX;
  protected double sizeY;

  public AControl(boolean b, double x, double y, double w, double h) {
    resizable = b;
    posX = x;
    posY = y;
    sizeX = w;
    sizeY = h;
  }
}
