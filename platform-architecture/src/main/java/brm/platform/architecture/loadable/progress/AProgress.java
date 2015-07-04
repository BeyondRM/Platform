package brm.platform.architecture.loadable.progress;
import java.awt.image.BufferedImage;


/**
 * An abstract progress container. This is the parent class for progress-group and progress-bar instances.
 * @author Gregory
 */
abstract public class AProgress {
  protected final BufferedImage image;
  protected final boolean resizableX;
  protected final boolean resizableY;
  protected String text;
  protected float progressPercent;
  protected int currentHeight;
  protected int currentWidth;
  protected int currentX;
  protected int currentY;
  protected int targetHeight;
  protected int targetWidth;
  protected int targetX;
  protected int targetY;
  protected int valueIndex;
  protected int valueTotal;

  /**
   * A public constructor. This instantiate a new {@link AProgress} object with the assigned parameters.
   * @param bi A {@link BufferedImage} object, representing the background {@link #image image}.
   * @param b0 A {@link Boolean} condition, representing if object is {@link #resizableX x-resizable}.
   * @param b1 A {@link Boolean} condition, representing if object is {@link #resizableY y-resizable}.
   * @param ix An {@link Integer} value, representing the {@link #currentX currentX} value.
   * @param iy An {@link Integer} value, representing the {@link #currentY currentY} value.
   * @param iw An {@link Integer} value, representing the {@link #currentWidth currentWidth} value.
   * @param ih An {@link Integer} value, representing the {@link #currentHeight currentHeight} value.
   * @param s0 A {@link String} array, representing the {@link #text text} value.
   * @see AProgress
   */
  public AProgress(BufferedImage bi, boolean b0, boolean b1, int ix, int iy, int iw, int ih, String s0) {
    image = bi;
    resizableX = b0;
    resizableY = b1;
    currentX = ix;
    currentY = iy;
    currentWidth = iw;
    currentHeight = ih;
    text = s0;
  }

  /**
   * Update the progress percent.
   * @see AProgress
   */
  private void updateProgressPercent() {
    if(valueIndex == 0) {
      progressPercent = 0.0F;
    } else if(valueIndex == valueTotal) {
      progressPercent = 1.0F;
    } else {
      progressPercent = valueIndex / (float)valueTotal;
    }
  }

  /**
   * Whether the progress is full.
   * @return A {@link Boolean} condition.
   * @see AProgress
   */
  public final boolean isProgressComplete() {
    return progressPercent == 1.0f;
  }

  /**
   * Whether we can resize the width.
   * @return A {@link Boolean} condition.
   * @see AProgress
   */
  public final boolean isResizableX() {
    return resizableX;
  }

  /**
   * Whether we can resize the height.
   * @return A {@link Boolean} condition.
   * @see AProgress
   */
  public final boolean isResizableY() {
    return resizableY;
  }

  /**
   * Get the progress percent.
   * @return A {@link Float} value.
   * @see AProgress
   */
  public final float getProgressPercent() {
    // presumably, method 'updateProgressPercent()' should be called before this...
    return progressPercent;
  }

  /**
   * Get the current height.
   * @return An {@link Integer} value.
   * @see AProgress
   */
  public final int getCurrentHeight() {
    return currentHeight;
  }

  /**
   * Get the current width.
   * @return An {@link Integer} value.
   * @see AProgress
   */
  public final int getCurrentWidth() {
    return currentWidth;
  }

  /**
   * Get the index value.
   * @return An {@link Integer} value.
   * @see AProgress
   */
  public final int getValueIndex() {
    return valueIndex;
  }

  /**
   * Get the total value.
   * @return An {@link Integer} value.
   * @see AProgress
   */
  public final int getValueTotal() {
    return valueTotal;
  }

  /**
   * Draw the progress.
   * @see AProgress
   */
  public void draw() {
  }

  /**
   * Reset all values. This will set all non-final fields to their new values.
   * @param i An {@link Integer} value, representing the {@link #valueTotal valueTotal}.
   * @param s A {@link String} object, representing the {@link #text text} label.
   * @see AProgress
   */
  public void reset(int i, String s) {
    valueTotal = i;
    valueIndex = 0;
    progressPercent = 0.0f;
    text = s;
  }

  /**
   * Update the progress. This method increments our {@link #valueIndex valueIndex}, sets the {@link #text text} to a
   * given String parameter, then updates the progress percent (a {@code float} value.
   * @param s A {@link String} object, representing the {@link #text text} label.
   * @see AProgress
   */
  public void update(String s) {
    valueIndex++;
    text = s;
    updateProgressPercent();
  }
}
