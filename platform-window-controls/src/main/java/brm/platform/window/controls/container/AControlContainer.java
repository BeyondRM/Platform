package brm.platform.window.controls.container;
import brm.platform.window.controls.AControl;


/**
 * A container object. This is the abstract parent class for defining types of visual and non-visual container, used to
 * organize multiple sub-components.
 * <h1>Subtypes of Containers</h1>
 * Generally, a container would be a literal frame or panel that does nothing more than hold components in a horizontal
 * or vertical arrangement.
 * @author Gregory
 */
abstract public class AControlContainer extends AControl {

  public AControlContainer(boolean b, double x, double y, double w, double h) {
    super(b, x, y, w, h);
  }
}
