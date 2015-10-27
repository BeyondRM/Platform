package brm.platform.attributes;
import abc.cryptology.logics.Crypto;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * Attribute logic. An attribute instance doesn't typically do much, it only provides defined specifications for source
 * materials, equippable objects, and properties of various combat attacks and defenses.
 * @author Gregory
 */
public class Attribute extends Crypto {
  /**
   * The title.
   * @see Attribute
   */
  public String title; // could be internationalized?
  /**
   * The icon set.
   * @see Attribute
   */
  public int iconset;
  /**
   * The icon tile.
   * @see Attribute
   */
  public int icontile;
  /**
   * The attribute class. Is this physical or weapon attribute, or a magical attribute?
   * @see Attribute
   */
  public int attclass;
  /**
   * Multiplier A.
   * @see Attribute
   */
  public int multA;
  /**
   * Multiplier B.
   * @see Attribute
   */
  public int multB;
  /**
   * Multiplier C.
   * @see Attribute
   */
  public int multC;
  /**
   * Multiplier D.
   * @see Attribute
   */
  public int multD;
  /**
   * Multiplier E.
   * @see Attribute
   */
  public int multE;

  /**
   * A public constructor. Has no parameters, but calls the other constructor with "default" values to instantiate....
   * <p/>
   * More specifically, we set the following defaults:
   * <pre>
   * attclass 0
   * multA 200
   * multB 150
   * multC 100
   * multD 50
   * multE 0
   * </pre>
   * @see LogicAttribute
   */
  public Attribute() {
    // Potentially deprecatable?
    this(0, 200, 150, 100, 50, 0, 0, 0, "");
  }

  /**
   * A public constructor.
   * @param i
   * @param j
   * @param k
   * @param l
   * @param m
   * @param n
   * @param o
   * @param p
   * @param s
   * @see LogicAttribute
   */
  public Attribute(int i, int j, int k, int l, int m, int n, int o, int p, String s) {
    // Potentially deprecatable?
    attclass = i;
    multA = j;
    multB = k;
    multC = l;
    multD = m;
    multE = n;
    iconset = o;
    iconset = o;
    title = s;
  }

  @Override
  public synchronized final void performDecryption(DataInputStream dis) throws IOException {
  }

  @Override
  public synchronized final void performEncryption(DataOutputStream dos) throws IOException {
  }

  public final boolean valid() {
    return title != null && !title.isEmpty()
        && iconset >= 0 // and less than iconsets size ... and icon tile# is greater than zero but less than icons size
        && attclass >= 0 && attclass < PlatformAttributes.instance.attclass.length;
    // Remember, there is nothing saying multA cannot be smaller than multB, although we expect it to be normally; then
    // we cannot check that each multiplier is smaller or equal to the previous one, unless specifying so in the editor
  }
}
