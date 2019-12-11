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
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.ArrayList;

public class EscrituraXmlCoche {
    
    public static void main(String args[]) throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException{
        ArrayList <Coche> coches = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "documento", null);
        document.setXmlVersion("1.0");
        
        Coche c = new Coche("Seat", "Ibiza", 11192, 1973);
        coches.add(c);
        Coche c1 = new Coche("Fiat", "Multipla", 1170, 1995);
        coches.add(c1);
        Coche c2 = new Coche("Opel", "Tigra", 930, 1992);
        coches.add(c2);
        Coche c3 = new Coche("Hyundai", "Accent", 85, 2000);
        coches.add(c3);
        Coche c4 = new Coche("Renault", "Clio Sport", 180, 1994);
        coches.add(c4);
		
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            // definimos el elemento raíz del documento
            Element eRaiz = doc.createElement("Coches");
            doc.appendChild(eRaiz);

            // definimos el nodo que contendrá los elementos
            
            for(int i = 0; i < coches.size(); i++){
                Element eCoche = doc.createElement("nombre");
                eRaiz.appendChild(eCoche);

                Element eMarca = doc.createElement("modelo");
                eMarca.appendChild(doc.createTextNode(coches.get(i).getNombre()));
                eCoche.appendChild(eMarca);

                Element eidentificador = doc.createElement("identificador");
                eidentificador.appendChild(doc.createTextNode(String.valueOf(coches.get(i).getIdentificador())));
                eCoche.appendChild(eidentificador);

                Element eano = doc.createElement("año");
                eano.appendChild(doc.createTextNode(String.valueOf(coches.get(i).getAno())));
                eCoche.appendChild(eano);
      
            }

            // clases necesarias finalizar la creación del archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Coches2.xml"));

            transformer.transform(source, result);
            }catch(ParserConfigurationException | TransformerException | DOMException e) {
        }
    }
}//fin de la clase



