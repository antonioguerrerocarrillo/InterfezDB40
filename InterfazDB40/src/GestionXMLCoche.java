

import interfazcrud.Coche;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Cuvi69
 */
public class GestionXMLCoche extends  DefaultHandler {	 
            
            Coche c;
            String leerXML = "";
            private ArrayList<Coche> arrayCoches = new ArrayList();

        public void setArrayCoche(ArrayList<Coche> arrayCoches) {
            this.arrayCoches = arrayCoches;
        }
            
            
    public GestionXMLCoche() {
	        super();
	    }	    
	    public void startDocument() {
	       // System.out.println("Comienzo del Documento XML");
               
	    }	    
	    public void endDocument() {
	       // System.out.println("Final del Documento XML");
	   
            }	 
	    public void startElement(String uri, String nombre,String nombreC, Attributes atts) {
	      //  System.out.printf("\t Principio Elemento: %s %n",nombre);
                leerXML = nombre;     
                if(leerXML.equals("Coches")){
                    c = new Coche();
                
                }

	    } 	
	    public void endElement(String uri, String nombre,String nombreC) {
	       // System.out.printf("\tFin Elemento: %s %n", nombre);
                    leerXML = nombre;
                
                if(leerXML.equals("Coches")){
                      arrayCoches.add(c);
                }
	    }	
	    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		   String car = new String(ch, inicio, longitud);
               //quitar saltos de línea	
		   car = car.replaceAll("[\t\n]","");	   
		   //System.out.printf ("\t Caracteres: %s %n", car);
                   
                    if(leerXML.equals("nombre")){
                       c.setNombre(String.valueOf(car));
                   } 
                    if(leerXML.equals("modelo")){
                       c.setModelo(String.valueOf(car));
                   }
                    if(leerXML.equals("identificador")){
                       c.setIdentificador(Integer.parseInt(car));
                   }
                    if(leerXML.equals("año")){
                       c.setAno(Integer.parseInt(car));
                   }
	    }	
            
}