package brm.platform.attributes;
import abc.cryptology.AbcCryptology;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import brm.platform.architecture.loadable.AModuleLoading;
import brm.platform.architecture.loadable.progress.ProgressBar;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.NoSuchPaddingException;


/**
 * The platform attributes handler. This provides for managing the attribute classes and attributes lists; the database
 * objects which implement attributes (such as for items) must also handle attribute properties in combat, crafting, or
 * other scenes.
 * <p/>
 * Attributes can be used in so many ways. In combat, one attribute may ablate or repel another attribute; so, incoming
 * damage values may need to be adjusted, based upon natural diminishing factors. In crafting, ingredients holding some
 * attributes could cause greater or lesser qualities or quantities of a finished product, along with a character's own
 * crafting mastery. In other scenarios, an attribute could be a natural manner of telling something about a character,
 * an item, a game object, &mdash; anything necessary. (In some early iterations, an attempt to base characters species
 * upon a special subtype of attribute was tried; but in the long run, a simple attribute was too simple to merely hold
 * all the miscellaneous race data.)
 * @author Gregory
 */
public class PlatformAttributes extends AModuleLoading {
  /**
   * The default instance.
   * @see PlatformAttributes
   */
  public static final PlatformAttributes instance;

  static {
    instance = new PlatformAttributes();
  }

  /**
   * The attributes list.
   * @see PlatformAttributes
   */
  protected Attribute[] attributes;
  /**
   * The attribute classes list.
   * @see PlatformAttributes
   */
  protected AttributeClass[] attclass;
  /**
   * The loader object.
   * @see PlatformAttributes
   */
  private AttributeLoader loader;

  /**
   * A private constructor. Goes nowhere, does nothing.
   * @see PlatformAttributes
   */
  private PlatformAttributes() {
  }

  @Override
  public synchronized final boolean isDataLoaded() {
    return dataLoaded;
  }

  @Override
  public synchronized final boolean isDataValidated() {
    return dataValidated;
  }

  @Override
  public synchronized final int getInitializedCount() {
    return initializedCount;
  }

  @Override
  public synchronized final void beforeInitialization(long l, File f, String s) {
    sourcePath = f;
  }

  @Override
  public synchronized final void initializeBefore(ProgressBar pb) {
    boolean b = sourcePath.exists() && sourcePath.isFile() && sourcePath.canRead();
    if(!b) {
      //TODO: Throw an error message; something may be wrong....
    }
  }

  @Override
  public synchronized final void initializeDuring(ProgressBar pb) {
    pb.reset(0, null);
    if(loader == null) {
      loader = new AttributeLoader(pb);
    }
    try {
      AbcCryptology.instance.performDecryption(477218073L, loader, "attribute", sourcePath, "PBEWithMD5AndDES");
      attclass = loader.getClasses();
      attributes = loader.getAttributes();
      loader = null;
    } catch(NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IOException ex) {
      Logger.getLogger(PlatformAttributes.class.getName()).log(Level.SEVERE, null, ex);
      System.exit(9);
    }
    dataLoaded = attclass != null && attclass.length > 0 && attributes != null && attributes.length > 0;
  }

  @Override
  public synchronized final void initializeFinish(ProgressBar pb) {
    if(dataLoaded) {
      for(AttributeClass ac : attclass) {
        if(!ac.valid()) {
          //TODO: Throw an error message; something may be wrong....
          String s = String.format("PlatformAttribute attribute class object is not valid: %s", ac.toString());
          //throw new Exception(s);
        }
      }
      for(Attribute a : attributes) {
        if(!a.valid()) {
          //TODO: Throw an error message; something may be wrong....
          String s = String.format("PlatformAttribute attribute object is not valid: %s", a.toString());
          //throw new Exception(s);
        }
      }
      dataValidated = true;
      return;
    }
    dataValidated = false;
  }

  @Override
  public synchronized final void validation() {
    boolean valid = true;
    for(AttributeClass lac : attclass) {
      valid &= !lac.getAbbr().isEmpty() && !lac.getName().isEmpty();
    }
    if(valid) {
      for(Attribute la : attributes) {
        valid &= la.attclass >= 0
            && la.multA > la.multB
            && la.multB > la.multC
            && la.multC > la.multD
            && la.multD > la.multE
            && la.multE >= 0;
      }
    }
    dataValidated = valid;
  }

  /**
   * Get a random attribute.
   * @return A {@link Attribute} object.
   * @see PlatformAttributes
   */
  public synchronized final Attribute getAttribute() {
    int i = (int)(Math.random() * attributes.length);
    return attributes[i];
  }

  /**
   * Get a specific attribute.
   * @param i An {@link Integer} value, representing the index to use.
   * @return A {@link Attribute} object.
   * @see PlatformAttributes
   */
  public synchronized final Attribute getAttribute(int i) {
    int index = i;
    if(index < 0) {
      index = 0;
    } else if(index >= attributes.length) {
      index = attributes.length - 1;
    }
    return attributes[index];
  }

  /**
   * Get a specific attribute class.
   * @param i An {@link Integer} value, representing the index to use.
   * @return A {@link AttributeClass} object.
   * @see PlatformAttributes
   */
  public synchronized final AttributeClass getAttributeClass(int i) {
    if(i >= 0 && i < attclass.length) {
      return attclass[i];
    } else {
      throw new ArrayIndexOutOfBoundsException(String.format("Expected a value greater than or equal to zero and less than array length, got %d instead.", i));
    }
  }


  /**
   * A loader. This class will both decrypt a readable input stream and encrypt a writable output stream, to handle the
   * attributes and the attribute classes lists.
   * @see PlatformAttributes
   * @see ACryptology
   * @see ProgressBar
   * @see Attribute
   * @see AttributeClass
   * @see #progressBar progressBar
   * @see #attributes attributes
   * @see #classes classes
   * @see #AttributeLoader(ProgressBar) AttributeLoader(ProgressBar)
   * @see #performDecryption(DataInputStream) performDecryption(DataInputStream)
   * @see #performEncryption(DataOutputStream) performEncryption(DataOutputStream)
   * @see #decryptAtt(DataInputStream) decryptAtt(DataInputStream)
   * @see #decryptCls(DataInputStream) decryptCls(DataInputStream)
   * @see #encryptAtt(DataOutputStream) encryptAtt(DataOutputStream)
   * @see #encryptCls(DataOutputStream) encryptCls(DataOutputStream)
   * @see #getAttributes() getAttributes()
   * @see #getClasses() getClasses()
   */
  static final class AttributeLoader extends Crypto {
    /**
     * The progress bar.
     */
    private final ProgressBar progressBar;
    /**
     * The attributes.
     */
    private Attribute[] attributes;
    /**
     * The attribute classes.
     */
    private AttributeClass[] classes;

    /**
     * A constructor. This takes a progress bar object, so that changes can be visually displayed as they are loading.
     * @param pb A {@link ProgressBar} object, representing the {@link #progressBar progressBar} instance.
     */
    AttributeLoader(ProgressBar pb) {
      progressBar = pb;
    }

    @Override
    public void performDecryption(DataInputStream dis) throws IOException {
      if(!PlatformArchitecture.mode.devOnly && dis != null) {
        decryptCls(dis);
        decryptAtt(dis);
      }
    }

    @Override
    public void performEncryption(DataOutputStream dos) throws IOException {
      if(PlatformArchitecture.mode.devOnly && dos != null) {
        encryptCls(dos);
        encryptAtt(dos);
      }
    }

    /**
     * Decrypt attributes.
     * @param dis A {@link DataInputStream}, representing the input source.
     * @throws java.io.IOException
     */
    private void decryptAtt(DataInputStream dis) throws IOException {
      if(attributes != null) {
        attributes = null;
      }
      int i = dis.readInt();
      attributes = new Attribute[i];
      while(i > 0) {
        Attribute att = new Attribute();
        att.performDecryption(dis);
        progressBar.update("");
        i--;
      }
    }

    /**
     * Decrypt attribute classes.
     * @param dis A {@link DataInputStream}, representing the input source.
     * @throws java.io.IOException
     */
    private void decryptCls(DataInputStream dis) throws IOException {
      if(classes != null) {
        classes = null;
      }
      int i = dis.readInt();
      classes = new AttributeClass[i];
      while(i > 0) {
        AttributeClass cls = new AttributeClass();
        cls.performDecryption(dis);
        progressBar.update("");
        i--;
      }
    }

    /**
     * Encrypt attributes.
     * @param dos A {@link DataOutputStream}, representing the input target.
     * @throws java.io.IOException
     */
    private void encryptAtt(DataOutputStream dos) throws IOException {
      if(attributes != null) {
        // second, encrypt the attributes
        dos.writeInt(attributes.length);
        for(AttributeClass ac : classes) {
          ac.performEncryption(dos);
        }
      }
    }

    /**
     * Encrypt attribute classes.
     * @param dos A {@link DataOutputStream}, representing the input target.
     * @throws java.io.IOException
     */
    private void encryptCls(DataOutputStream dos) throws IOException {
      if(classes != null) {
        // first, encrypt the attribute classes
        dos.writeInt(classes.length);
        for(Attribute a : attributes) {
          a.performEncryption(dos);
        }
      }
    }

    /**
     * Get the attributes.
     * <p/>
     * This depends upon the decryption method having been run to read the binary files.
     * @return An {@link Attribute} array.
     */
    Attribute[] getAttributes() {
      return attributes.clone();
    }

    /**
     * Get the attribute classes.
     * <p/>
     * This depends upon the decryption method having been run to read the binary files.
     * @return An {@link AttributeClass} array.
     */
    AttributeClass[] getClasses() {
      return classes.clone();
    }
  }
}
