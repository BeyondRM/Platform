package brm.platform.architecture.loadable.progress;
import java.awt.image.BufferedImage;


/**
 * <h2>ProgressSet</h2>
 * @author Gregory
 */
public class ProgressSet extends AProgress {
  protected final ProgressBar[] bars;

  public ProgressSet(BufferedImage bi, boolean b0, boolean b1, int ix, int iy, int iw, int ih, String s0, ProgressBar... pb) {
    super(bi, b0, b1, ix, iy, iw, ih, s0);
    bars = pb;
  }

  @Override
  public void draw() {
    super.draw();
  }

  @Override
  public void reset(int i, String s) {
    super.reset(i, s);
    for(ProgressBar bar : bars) {
      bar.update(s);
    }
  }

  public final ProgressBar getProgressBar(int i) {
    return bars[i];
  }
}
