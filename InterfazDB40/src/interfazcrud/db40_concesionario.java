/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazcrud;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.util.ArrayList;
import javafx.scene.layout.Region;

/**
 *
 * @author cuvil
 */
public class db40_concesionario {
     
   public static void insertarConcesionario(Concesionario r){
    
        ObjectContainer db = com.db4o.Db4o.openFile("concesionario.yap");
        db.store(r);
        db.close();
         
    }
    public static void leerConcesionario(ArrayList<Concesionario> re)  {
        
        ObjectContainer db = com.db4o.Db4o.openFile("concesionario.yap");
        Query q = db.query();
        q.constrain(Region.class);
        ObjectSet result = q.execute();
        while(result.hasNext()){
            
            Concesionario r = new Concesionario();
            r = (Concesionario) result.next();
            re.add(r);
        }
        
        db.close();
        
    }
    public static void deleteConcesionario(Concesionario r) {
            
       ObjectContainer db = com.db4o.Db4o.openFile("concesionario.yap");    
       Query q = db.query();
       q.constrain(Concesionario.class);
       q.descend("id").constrain(new Integer(r.getId())).equal();
       ObjectSet result = q.execute();
       Concesionario b = (Concesionario) result.next();
       db.delete(b);
       db.close();
       
    }
}
    
