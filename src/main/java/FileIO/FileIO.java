package FileIO;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileIO {

    private static Writer writer;

    private static Reader reader;

    private static String filename = "./catalog.txt";

    public static void writeKatalog(ArrayList<Aufgabe> katalog) {
        try {
            ArrayList <AufgabeBlock> hallo = new ArrayList<AufgabeBlock>();
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
            AufgabeBlock block = new AufgabeBlock("Mineseeper", "import asdasdasd \n import asdasda\n public class sadasdasf");
            AufgabeBlock block1 = new AufgabeBlock("Mineseeper2", "import asdasdasd \n ojojo asdasda\n public class sadasdasf");
            AufgabeBlock block2 = new AufgabeBlock("Mineseeper3", "import hallo \n ojojo asdasda\n public class 3");
            hallo.add(block);
            hallo.add(block1);
            hallo.add(block2);
            writer.write(getXMLArray("Classes", "Class", hallo));


            //"writer.write(getXMLStruct("class", "Minesweeper", "import static.org.junit.Assert.*;\n import org.junit.Test;\n public class Minesweeper {" +
            //        "}}"));
            writer.close();
        } catch (Exception e) {
            System.out.println("FILE NOT FOUND");
        }
    }

    public static ArrayList<Aufgabe> readKatalog(){
        ArrayList<Aufgabe> katalog = new ArrayList<Aufgabe>();

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "utf-8"));
        } catch (Exception e) {
            System.out.println("FILE NOT FOUND");
        }

        return katalog;
    }

    private static String getXMLWithValueAndTime(String tag, String value, String time) {
        return "<" + tag + " value=\"" +  value + "\" time=\"" + time + "\" />\n";
    }


    private static String getXMLOneValue(String tag, String name, String value) {
        return "<" + tag + " " + name + "=\"" +  value + "\" />\n";
    }

    private static String getXMLStruct(String typ, String name, String vorlage) {
        return "<" + typ + " name=\"" + name + "\">\n" + vorlage + "\n</" + typ + ">\n";
    }

    private static String getXMLArray(String typ, String untertyp, ArrayList<AufgabeBlock> block) {
        String s = "<" + typ + ">\n";
        for(int i=0; i < block.size(); i ++) {
            s = s + getXMLStruct(untertyp, block.get(i).name, block.get(i).preset);
        }
        return s;
    }
}
