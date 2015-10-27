package brm.platform.items.item;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import brm.platform.architecture.database.AInformation;
import brm.platform.architecture.database.InformationBasic;
import brm.platform.items.enums.ItemType;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * An item definition. Contains fields and methods for managing the details of an Item instance, based off an object in
 * the game database. It contains fields to centralize information, enumerations to define the item type, et cetera.
 * @author Gregory
 */
abstract public class AItem extends Crypto {
  /**
   * The item information.
   * @see AItem
   */
  protected AInformation information;
  /**
   * The item type.
   * @see AItem
   */
  protected ItemType type;
  /**
   * The item maximum stacking size.
   * @see AItem
   */
  protected byte maxStackSize;
  /**
   * The item price.
   * @see AItem
   */
  protected int price; // have a price (either static or formulaic), ...

  public AItem(ItemType it) {
    type = it;
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      if(information == null) {
        information = new InformationBasic();
      }
      information.performDecryption(dis);
    }
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly && information != null) {
      information.performEncryption(dos);
    }
  }
}
