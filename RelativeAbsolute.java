File dir = new File(".");
File Archivo = new File(dir, "imagen.bmp");
------------------------------------------------------


CodeSource src = MyClass.class.getProtectionDomain().getCodeSource();
if (src != null) {
  URL jar = src.getLocation();
  ZipInputStream zip = new ZipInputStream(jar.openStream());
  while(true) {
    ZipEntry e = zip.getNextEntry();
    if (e == null)
      break;
    String name = e.getName();
    if (name.startsWith("path/to/your/dir/")) {
      /* Do something with this entry. */
      ...
    }
  }
} 
else {
  /* Fail... */
}

---------------------------------------------------------------------
Utiliza la librería java.net.URL. Y en la parte donde deseas la ruta de la imagen pon

URL is = getClass().getResource("imagen.jpg");
ImageIcon imgThisImg = new ImageIcon(is);
----------------------------------------------------------------------

String template = System.getProperty("user.dir";
String file_report = template+"/src/SanverReportes/Ventas/PrincipaReportesVentac.jasper";
File archivo = new File(file_report);


-------------------------------------------------------
BufferedReader, BufferedWriter o RandomAccessFile
