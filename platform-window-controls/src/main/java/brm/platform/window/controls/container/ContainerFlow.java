package brm.platform.window.controls.container;


/**
 * A container that flows its contents automatically. In this case, the flow direction could be either in horizontal or
 * vertical direction. Horizontal flow is used in side-by-side lists of items; vertical flow is used in a top-to-bottom
 * list of items.
 * @author Gregory
 */
public class ContainerFlow extends AControlContainer {

  public ContainerFlow(boolean b, double x, double y, double w, double h) {
    super(b, x, y, w, h);
  }
}
