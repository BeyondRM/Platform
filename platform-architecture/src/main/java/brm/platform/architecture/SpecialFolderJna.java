// JNA (Java Native Access) provides Java programs easy access to native shared libraries (DLLs on Windows) without
// writing anything but Java code -- no JNI or native code is required. In this HowTo, we retrieve the path of some
// Windows Special Folders : Program Files, Common Documents and the Desktop.
// You can get the others by using the right identifier from the constants defined in the ShlObj interface.
package brm.platform.architecture;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.Shell32;
import com.sun.jna.platform.win32.ShlObj;
import com.sun.jna.platform.win32.WinDef;


// https://github.com/twall/jna#readme
//    you need 2 jars : jna-3.5.1.jar and platform-3.5.1.jar
public class SpecialFolderJna {
  public static void main(String[] args) {
    char[] pszPath = new char[WinDef.MAX_PATH];

    Shell32.INSTANCE.SHGetFolderPath(null, ShlObj.CSIDL_PROGRAM_FILES, null, ShlObj.SHGFP_TYPE_CURRENT, pszPath);
    System.out.println(Native.toString(pszPath));

    Shell32.INSTANCE.SHGetFolderPath(null, ShlObj.CSIDL_DESKTOPDIRECTORY, null, ShlObj.SHGFP_TYPE_CURRENT, pszPath);
    System.out.println(Native.toString(pszPath));

    Shell32.INSTANCE.SHGetFolderPath(null, ShlObj.CSIDL_COMMON_DOCUMENTS, null, ShlObj.SHGFP_TYPE_CURRENT, pszPath);
    System.out.println(Native.toString(pszPath));
  }
}
//output:
//  C:\Program Files
//  C:\Users\Real_User\Desktop
//  C:\Users\Public\Documents
