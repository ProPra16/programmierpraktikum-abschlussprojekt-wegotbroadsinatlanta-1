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
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
            writer.write(getTag("excercises", true));
            for(int i=0; i < katalog.size(); i++) {
                Aufgabe aktuelleAufgabe = katalog.get(i);
                writer.write(getXMLOneValue("excercise", "name", aktuelleAufgabe.name, true));
                //classes und tests
                writer.write(getTag("config", true));
                //babysteps
                writer.write(getXMLOneValue("timetracking", "value", aktuelleAufgabe.config.timetracking, false));
                writer.write(getTag("config", false));
                writer.write(getTag("excercise", false));
            }
            writer.write(getTag("excercises", false));
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


    private static String getXMLOneValue(String tag, String name, String value, Boolean open) {
        if(open) return "<" + tag + " " + name + "=\"" +  value + "\">\n";
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

    private static String getTag(String tag, boolean open){
        if (open) return "<" + tag + ">";
        return "</" + tag + ">";
    }
}
