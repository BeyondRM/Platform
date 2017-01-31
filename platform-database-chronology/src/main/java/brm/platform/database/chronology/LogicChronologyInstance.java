package brm.platform.database.chronology;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * Logic for the chronology instance. This class loads the instanced time values that will exist within an instance of
 * a game. If a saved game is loaded, this class reads in the stored game values, and when a game is saved, this class
 * writes those time values to the data stream.
 * @author Gregory
 */
class LogicChronologyInstance extends Crypto {
  // the date values
  protected short currentDateYear;
  protected int currentDateMonth;
  protected int currentDateDay;
  protected int currentDateWeekday;
  // the time values
  protected int currentTimeHour;
  protected int currentTimeMin;
  protected int currentTimeSec; // should seconds be a float or double value? would allow greater precision...

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    currentDateYear = dis.readShort();
    currentDateMonth = dis.readByte();
    currentDateDay = dis.readByte();
    currentDateWeekday = dis.readByte();
    currentTimeHour = dis.readByte();
    currentTimeMin = dis.readByte();
    currentTimeSec = dis.readByte();
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      dos.writeShort(currentDateYear);
      dos.writeByte(currentDateMonth);
      dos.writeByte(currentDateDay);
      dos.writeByte(currentDateWeekday);
      dos.writeByte(currentTimeHour);
      dos.writeByte(currentTimeMin);
      dos.writeByte(currentTimeSec);
    }
  }
}
