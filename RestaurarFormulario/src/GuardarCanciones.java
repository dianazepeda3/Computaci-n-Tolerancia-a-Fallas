
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author diana zepeda tatengo
 */
public class GuardarCanciones {
    private DataOutputStream archivo;
    private DataOutputStream archivo2;
    
    private DataInputStream archivo3;
    private DataInputStream archivo4;
    //EntradaDatos entrada;
    Cancion song;
    int num;
                    
    Object[][] canciones = new Object[50][3];   
    
    GuardarCanciones(){
        num=0;
        for(int i=0; i<50; i++){
            canciones[i][0] = null;
        }
    }

    public int getNum() {
        return num;
    }
        
    
    public void CrearArchivo(String url) throws FileNotFoundException{
        archivo = new DataOutputStream(new FileOutputStream(url, true));
        archivo2 = new DataOutputStream(new FileOutputStream("respaldo.txt"));
    }
      
    public void Guardar(String nombre, String artista, String album, String url) 
            throws FileNotFoundException, IOException{        
        archivo = null;
        archivo = new DataOutputStream(new FileOutputStream(url, true));
        archivo.writeUTF(nombre);
        archivo.writeUTF(artista);
        archivo.writeUTF(album);
        archivo.close();       
    }
    
    public void Respaldo(String nombre, String artista, String album) 
            throws FileNotFoundException, IOException{        
        archivo2 = null;
        archivo2 = new DataOutputStream(new FileOutputStream("respaldo.txt"));
        archivo2.writeUTF(nombre);
        archivo2.writeUTF(artista);
        archivo2.writeUTF(album);
        archivo2.close();           
    }
    
    public Cancion getRespaldo() throws FileNotFoundException, IOException{
        archivo4 = new DataInputStream(new FileInputStream("respaldo.txt"));
        song = new Cancion();                   
        song.setNombre(archivo4.readUTF());
        song.setArtista(archivo4.readUTF());
        song.setAlbum(archivo4.readUTF());

        return song;
    }
    
    public void borrarRespaldo() throws FileNotFoundException, IOException{
        archivo2 = null;
        archivo2 = new DataOutputStream(new FileOutputStream("respaldo.txt"));
    }
    
    public Object[][] getCanciones(String url) throws FileNotFoundException{
        archivo3 = new DataInputStream(new FileInputStream(url));
        int cont = 0;
        try {
            while(true){
                canciones[cont][0] = archivo3.readUTF();
                canciones[cont][1] = archivo3.readUTF();
                canciones[cont][2] = archivo3.readUTF(); 
                cont++;
            }
        } catch (IOException ex) {}
        return canciones;
    }
}
