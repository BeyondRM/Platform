package brm.platform.window.enums;


/**
 * The container layout. This enumeration defines the types of layout that are important to a container. Primarily, the
 * container should layout its contents in either a horizontal or vertical manner; however, an additional layout method
 * may be for a "mixed layout", such as for a grid-based layout.
 * @author Gregory
 */
public enum ContainerLayout {
  horizontal,
  mixedLayout,
  vertical;

  private ContainerLayout() {
  }
}
