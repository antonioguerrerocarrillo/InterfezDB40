/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazcrud;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.ArrayList;
import javafx.scene.layout.Region;

/**
 *
 * @author cuvil
 */
public class db40_clientes {
       public static void insertarClientes(Clientes r){
    
        ObjectContainer db = com.db4o.Db4o.openFile("clientes.yap");
        db.store(r);
        db.close();
         
    }
    public static void leerClientes(ArrayList<Clientes> re)  {
        
        ObjectContainer db = com.db4o.Db4o.openFile("clientes.yap");
        Query q = db.query();
        q.constrain(Region.class);
        ObjectSet result = q.execute();
        while(result.hasNext()){
            
            Clientes r = new Clientes();
            r = (Clientes) result.next();
            re.add(r);
        }
        
        db.close();
        
    }
    public static void deleteClientes(Clientes r) {
            
       ObjectContainer db = com.db4o.Db4o.openFile("clientes.yap");    
       Query q = db.query();
       q.constrain(Concesionario.class);
       q.descend("dni").constrain(new Integer(r.getDni())).equal();
       ObjectSet result = q.execute();
       Concesionario b = (Concesionario) result.next();
       db.delete(b);
       db.close();
       
    }
}
