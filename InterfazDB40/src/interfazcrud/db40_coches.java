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
public class db40_coches {
       public static void insertarCoches(Coche r){
    
        ObjectContainer db = com.db4o.Db4o.openFile("coches.yap");
        db.store(r);
        db.close();
         
    }
    public static void leerCoches(ArrayList<Coche> re)  {
        
        ObjectContainer db = com.db4o.Db4o.openFile("coches.yap");
        Query q = db.query();
        q.constrain(Region.class);
        ObjectSet result = q.execute();
        while(result.hasNext()){
            
            Coche r = new Coche();
            r = (Coche) result.next();
            re.add(r);
        }
        
        db.close();
        
    }
    public static void deleteConcesionario(Concesionario r) {
            
       ObjectContainer db = com.db4o.Db4o.openFile("coche.yap");    
       Query q = db.query();
       q.constrain(Concesionario.class);
       q.descend("id").constrain(new Integer(r.getId())).equal();
       ObjectSet result = q.execute();
       Concesionario b = (Concesionario) result.next();
       db.delete(b);
       db.close();
       
    }
}
