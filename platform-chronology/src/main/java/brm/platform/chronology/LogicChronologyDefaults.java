package brm.platform.chronology;
import abc.cryptology.logics.ACryptoLogic;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * <h2>LogicChronologyDefaults</h2>
 * Logic for the chronology defaults. This class loads the default time values that will exist unchanging throughout an
 * instance of a game. Values never need to be written to a stream, because the defaults will not be modified.
 * @author Gregory
 */
class LogicChronologyDefaults extends ACryptoLogic {
  // the date values
  protected short dateBeginYear;
  protected int dateBeginMonth;
  protected int dateBeginDay;
  protected int dateBeginWeekday;
  protected short dateEndYear;
  protected int dateEndMonth;
  protected int dateEndDay;
  protected int dateEndWeekday;
  // the time values
  protected int timeBeginHour;
  protected int timeBeginMinute;
  protected int timeBeginSecond;
  protected int timeEndHour;
  protected int timeEndMinute;
  protected int timeEndSecond;
  // please read through the readme in the project's resources path, for some details of the fields to instantiate.

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    dateBeginYear = dis.readShort();
    dateBeginMonth = dis.readByte();
    dateBeginDay = dis.readByte();
    dateBeginWeekday = dis.readByte();
    dateEndYear = dis.readShort();
    dateEndMonth = dis.readByte();
    dateEndDay = dis.readByte();
    dateEndWeekday = dis.readByte();

    timeBeginHour = dis.readByte();
    timeBeginMinute = dis.readByte();
    timeBeginSecond = dis.readByte();
    timeEndHour = dis.readByte();
    timeEndMinute = dis.readByte();
    timeEndSecond = dis.readByte();
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeShort(dateBeginYear);
      dos.writeByte(dateBeginMonth);
      dos.writeByte(dateBeginDay);
      dos.writeByte(dateBeginWeekday);
      dos.writeShort(dateEndYear);
      dos.writeByte(dateEndMonth);
      dos.writeByte(dateEndDay);
      dos.writeByte(dateEndWeekday);

      dos.writeByte(timeBeginHour);
      dos.writeByte(timeBeginMinute);
      dos.writeByte(timeBeginSecond);
      dos.writeByte(timeEndHour);
      dos.writeByte(timeEndMinute);
      dos.writeByte(timeEndSecond);
    }
  }
}
