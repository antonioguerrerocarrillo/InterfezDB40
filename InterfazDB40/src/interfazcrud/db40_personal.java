package interfazcrud;


import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import interfazcrud.Concesionario;
import interfazcrud.Personal;
import java.util.ArrayList;
import javafx.scene.layout.Region;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cuvil
 */
public class db40_personal {
       public static void insertarPersonal(Personal r){
    
        ObjectContainer db = com.db4o.Db4o.openFile("personal.yap");
        db.store(r);
        db.close();
         
    }
    public static void leerPersonal(ArrayList<Personal> re)  {
        
        ObjectContainer db = com.db4o.Db4o.openFile("personal.yap");
        Query q = db.query();
        q.constrain(Region.class);
        ObjectSet result = q.execute();
        while(result.hasNext()){
            
            Personal r = new Personal();
            r = (Personal) result.next();
            re.add(r);
        }
        
        db.close();
        
    }
    public static void deletePersonal(Personal r) {
            
       ObjectContainer db = com.db4o.Db4o.openFile("personal.yap");    
       Query q = db.query();
       q.constrain(Concesionario.class);
       q.descend("id").constrain(new Integer(r.getId())).equal();
       ObjectSet result = q.execute();
       Concesionario b = (Concesionario) result.next();
       db.delete(b);
       db.close();
       
    }
}
