/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazcrud;

/**
 *
 * @author cuvil
 */


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

public class ConcesionarioFichero {
    
    public static void NuevoFicheroConcesionario(ArrayList<Concesionario> c){
        BorrarFichero();
        try{
            File ruta = new File("Concesionario.dat");            
            FileOutputStream fileout = new FileOutputStream(ruta,true);
            ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  
           
            dataOS.writeObject(c);
            dataOS.flush();
            dataOS.close();
            
        }catch (IOException e){}
    }
    public static ArrayList getFicheroConcesionario(){
        ArrayList<Concesionario> c = new ArrayList();        
 
        try{
            File fichero = new File("Concesionario.dat");
            ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

            try {
                while (true) {
                        c = (ArrayList<Concesionario>) dataIS.readObject();
             
                }
            } catch (EOFException | StreamCorruptedException eo) {}

            dataIS.close(); 
        }catch (IOException | ClassNotFoundException e){ }
        
        return c;
    
    }
    public static void BorrarFichero(){
         File ruta = new File("Concesionario.dat");    
            ruta.delete();
    }

}
