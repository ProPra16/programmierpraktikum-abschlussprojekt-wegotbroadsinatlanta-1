package FileIO;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by thosch777 on 14.07.2016.
 */
public class Einlesen{

    public ArrayList<Aufgabe> lesen(){
        ArrayList<Aufgabe> katalog = new ArrayList<Aufgabe>();
        try {
            File inputFile = new File("catalogback.xml");
            DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docbuilder = docfactory.newDocumentBuilder();
            Document doc = docbuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodelist = doc.getElementsByTagName("excercise");
            for (int i = 0; i < nodelist.getLength(); i++) {
                Node node = nodelist.item(i);
                Aufgabe aufgabe = new Aufgabe();
                System.out.println("\nCurrent Element :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    aufgabe.name = element.getAttribute("name");
                    aufgabe.description = element.getElementsByTagName("description").item(0).getTextContent();
                    aufgabe.aufgabeklassen = element.getElementsByTagName("class").item(0).getTextContent();
                    aufgabe.aufgabetests = element.getElementsByTagName("tests").item(0).getTextContent();
                    aufgabe.config.babystep = new BabystepConfig();
                    aufgabe.config.babystep.value = element.getElementsByTagName("babysteps").item(0).getAttributes().getNamedItem("value").getTextContent();
                    aufgabe.config.babystep.time = Integer.valueOf(element.getElementsByTagName("babystepTime").item(0).getAttributes().getNamedItem("value").getTextContent());
                    aufgabe.config.timetracking = Boolean.valueOf(element.getElementsByTagName("timetracking").item(0).getAttributes().getNamedItem("value").getTextContent());
                }
                katalog.add(i,aufgabe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return katalog;
    }
}
