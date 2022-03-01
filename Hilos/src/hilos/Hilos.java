
package hilos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.Timer;

/**
 * @author diana
 */
public class Hilos extends Thread {
    javax.swing.JLabel lblTittulo;
    int h, m, s, cs;
    Boolean flag = false;
    private DataOutputStream archivo2;
    private DataInputStream archivo4;
    
    public Hilos() throws IOException{   
        t = new Timer(10, acciones);
       
    }
    
    private Timer t;
    
    private ActionListener acciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    
   public void run(){ 
        try {
            getRespaldo();
        } catch (IOException ex) {
            //Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(true){
            
            ++cs; 
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
            }            
            if(cs==100){
                cs = 0;
                ++s;
                try {
                    Respaldo();
                } catch (IOException ex) {
                    //Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(s==60){
                s = 0;
                ++m;
            }
            if(m==60){
                m = 0;
                ++h;                
            }
            actualizarLabel();
            System.out.println("h: "+h+"  m: "+m+"  s: "+s);
            if(flag){
                h = 0;
                m = 0;
                s = 0;
                cs = 0;
                flag = false;
            }
            //}
        }
    }
    
    private void actualizarLabel() {
        String tiempo = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s+":"+(cs<=9?"0":"")+cs;
        lblTittulo.setText(tiempo);
    }
    
    public void recibeJLabel(javax.swing.JLabel lblTittulo){
        this.lblTittulo = lblTittulo;
    }
    
    public void CrearArchivo() throws FileNotFoundException{
        archivo2 = new DataOutputStream(new FileOutputStream("respaldo.txt"));
    }
    
    public void Respaldo() 
            throws FileNotFoundException, IOException{        
        archivo2 = null;
        archivo2 = new DataOutputStream(new FileOutputStream("respaldo.txt"));
        archivo2.writeUTF(String.valueOf(h));
        archivo2.writeUTF(String.valueOf(m));
        archivo2.writeUTF(String.valueOf(s));
        archivo2.writeUTF(String.valueOf(cs));
        archivo2.close();           
    }
    
    public void getRespaldo() throws FileNotFoundException, IOException{
        archivo4 = new DataInputStream(new FileInputStream("respaldo.txt"));   
        String aux;        
        aux = archivo4.readUTF();
        if(!aux.equals("")){
        h = Integer.parseInt(aux);
        m = Integer.parseInt(archivo4.readUTF());
        s = Integer.parseInt(archivo4.readUTF());
        cs = Integer.parseInt(archivo4.readUTF());
        }
    }
    public void reiniciar() throws FileNotFoundException, IOException{       
        
        flag = true;
        archivo2 = null;
        archivo2 = new DataOutputStream(new FileOutputStream("respaldo.txt"));                
        
    }
    
    
    
}
