 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPOutputStream;
 
public class Escribe_fichero_comprimido {
    public static void main(String args[]) throws java.io.IOException {
        String infile = "fichero.txt";
        FileInputStream in = new FileInputStream(infile);
 
        String outfile = "fichero.gz";
        GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(outfile));
 
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }
}



import java.io.FileInputStream;
import java.util.zip.GZIPInputStream;
 
public class lee_fichero_comprimido {
    public static void main(String args[]) throws java.io.IOException {
        String infile = "fichero.gz";
        GZIPInputStream in = new GZIPInputStream(new FileInputStream(infile));
 
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            System.out.write(buf, 0, len);
        }
        in.close();
    }
}
----------------------------------------------------------------------------
 String infile = "fichero.gzip";
GZIPInputStream in = new GZIPInputStream(new FileInputStream(infile));
 
Reader decoder = new InputStreamReader(in);
BufferedReader br = new BufferedReader(decoder);
 
String linea;
while ((linea = br.readLine()) != null) {
    System.out.println(linea);
}
-----------------------------------------------------------------------------
 
