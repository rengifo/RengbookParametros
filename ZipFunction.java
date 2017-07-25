import java.util.zip.*;
import java.io.*;
 
/**
 *
 * @author GeekZero
 */
public class Archivos {
 
	private static final int BUFFER_SIZE = 1024;
 
        public void Zippear(String srcFile, String desZipFile) throws Exception {
		// objetos en memoria
		FileInputStream fis = null;
		FileOutputStream fos = null;
		ZipOutputStream zipos = null;
 
		// buffer
		byte[] buffer = new byte[BUFFER_SIZE];
		try {
			// fichero a comprimir
			fis = new FileInputStream(srcFile);
			// fichero contenedor del zip
			fos = new FileOutputStream(desZipFile);
			// fichero comprimido
			zipos = new ZipOutputStream(fos);
      String nameFile= srcFile.substring(srcFile.lastIndexOf("/")+1);
			ZipEntry zipEntry = new ZipEntry(nameFile);
			zipos.putNextEntry(zipEntry);
			int len = 0;
			// zippear
			while ((len = fis.read(buffer, 0, BUFFER_SIZE)) != -1)
				zipos.write(buffer, 0, len);
			// volcar la memoria al disco
			zipos.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			// cerramos los files
			zipos.close();
			fis.close();
			fos.close();
		} // end try
	} // end Zippear
 
	public void UnZip(String srcZipFile, String desFile) throws Exception {
		BufferedOutputStream bos = null;
		FileInputStream fis = null;
		ZipInputStream zipis = null;
		FileOutputStream fos = null;
 
		try {
			fis = new FileInputStream(srcZipFile);
			zipis = new ZipInputStream(new BufferedInputStream(fis));
			if (zipis.getNextEntry() != null) {
				int len = 0;
				byte[] buffer = new byte[BUFFER_SIZE];
				fos = new FileOutputStream(desFile);
				bos = new BufferedOutputStream(fos, BUFFER_SIZE);
 
				while  ((len = zipis.read(buffer, 0, BUFFER_SIZE)) != -1)
					bos.write(buffer, 0, len);
				bos.flush();
			} else {
				throw new Exception("El zip no contenia fichero alguno");
			} // end if
		} catch (Exception e) {
			throw e;
		} finally {
			bos.close();
			zipis.close();
			fos.close();
			fis.close();
		} // end try
	} // end UnZip
 
        // ejemplo de uso
	public static void main(String[] args) throws Exception {
		try {
			Archivos arch = new Archivos();
			arch.Zippear("devtroce.jpg", "devtroce.zip");
			System.out.println("Comprimido!");
			arch.UnZip("devtroce.zip", "new_devtroce.jpg");
			System.out.println("Descomprimido!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}// end class
