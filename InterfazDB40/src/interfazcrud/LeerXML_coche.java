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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cuvil
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerXML_coche {

    public static void leer(ArrayList<Coche> arraycoches) {
        try {
            System.out.println("leeyendo el leer xml");
            File archivo = new File("C:\\Users\\cuvil\\Documents\\NetBeansProjects\\InterfazCRUD\\CochesXML.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            Coche c = new Coche();
            document.getDocumentElement().normalize();
            System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
            NodeList coches = document.getElementsByTagName("cochesXML");

            for (int i = 0; i < coches.getLength(); i++) {
                Node nodo = coches.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    c.setNombre(element.getElementsByTagName("marca").item(0).getTextContent());
                    c.setModelo(element.getElementsByTagName("modelo").item(0).getTextContent());
                    c.setIdentificador(Integer.parseInt(element.getElementsByTagName("identificador").item(0).getTextContent()));
                    c.setAno((Integer.parseInt(element.getElementsByTagName("año").item(0).getTextContent())));
                    System.out.println(c.getNombre());
                    System.out.println(c.getModelo());
                    System.out.println(c.getIdentificador());
                    System.out.println(c.getAno());
                }
            }
        } catch (IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException e) {
        }
    }
}
