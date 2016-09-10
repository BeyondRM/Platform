package brm.platform.graphics.graphic;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;


/**
 * A mono-tile graphic object.
 * @author Gregory
 */
public class GraphicMonotile extends Graphic {
  public GraphicMonotile(File f) throws IOException {
    super(f);
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
  }
}
