public static void descargar(String url, String ficheroDestino) throws Exception {
 
   URL ficheroUrl = new URL(url);
   InputStream inputStream = ficheroUrl.openStream();			
   OutputStream outputStream = new FileOutputStream(ficheroDestino); // path y nombre del nuevo fichero creado
 
   byte[] b = new byte[2048];
   int longitud;
 
   while ((longitud = inputStream.read(b)) != -1) {
      outputStream.write(b, 0, longitud);
   }
 
   inputStream.close();  // Cerramos la conexión entrada
   outputStream.close(); // Cerramos la conexión salida
}



public static void mostrarContenido(String url) throws Exception {
   URL ficheroUrl = new URL(url);
   BufferedReader in = new BufferedReader(new InputStreamReader(ficheroUrl.openStream()));

   String linea;
   while ((linea = in.readLine()) != null){
      System.out.println(linea);
   }

   in.close(); // Cerramos la conexión  
}
