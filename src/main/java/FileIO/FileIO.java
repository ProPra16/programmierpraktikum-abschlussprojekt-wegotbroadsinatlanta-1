package FileIO;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileIO {

    private static Writer writer;
    private static BufferedReader reader;
    private static String filename = "./catalog.txt";

    public static void writeKatalog(ArrayList<Aufgabe> katalog) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
            writer.write(getTag("excercises", true));
            for(int i=0; i < 1/*katalog.size()*/; i++) {
                Aufgabe aktuelleAufgabe = new Aufgabe();
                //test code
                AufgabeBlock a = new AufgabeBlock("hallo welt", "public");
                aktuelleAufgabe.aufgabeklassen.add(a);
                //bis hier
                writer.write(getXMLOneValue("excercise", "name", "ando"/*aktuelleAufgabe.name*/, true));
                writer.write(getTag("description", true));
                writer.write("teste description"/*aktuelleAufgabe.description*/);
                writer.write(getTag("description", false));
                for(int j=0; j < 1/*aktuelleAufgabe.aufgabeklassen.size()*/; j++) {
                    writer.write(getXMLArray("classes", "class", aktuelleAufgabe.aufgabeklassen));
                }
                for(int k=0; k < 1/*aktuelleAufgabe.aufgabetests.size()*/; k++) {
                    writer.write(getXMLArray("tests", "test", aktuelleAufgabe.aufgabetests));
                }
                writer.write(getTag("config", true));
                if(aktuelleAufgabe.config.babystep.value == "True") writer.write(getXMLWithValueAndTime("babysteps", aktuelleAufgabe.config.babystep.value, aktuelleAufgabe.config.babystep.time));
                else writer.write(getXMLOneValue("babysteps", "value", "true"/*aktuelleAufgabe.config.babystep.value*/, false));
                writer.write(getXMLOneValue("timetracking", "value", "yeah"/*aktuelleAufgabe.config.timetracking*/, false));
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
            String line = reader.readLine();
            StringBuilder b = new StringBuilder();
            while (line != null) {
                b.append(line+"\n");
                line = reader.readLine();
            }
            String text = b.toString();

            String[] aufgaben = text.split("<excercise name=");
            String[] NameBabystepTimetracking = null;
            String[] descriptionpre = null;
            String[] description = null;
            String[] aufgabenblocknamenpre = null;
            String[] aufgabenblocknamen = null;
            for(int i=1; i<aufgaben.length; i++) {
                Aufgabe aufgabe = new Aufgabe();
                NameBabystepTimetracking = aufgaben[i].split("\"");
                descriptionpre = aufgaben[i].split("<description>");
                description = descriptionpre[1].split("</description>");
                aufgabe.description = description[0];
                aufgabenblocknamenpre = aufgaben[i].split("<class name=\"");
                for(int k=1; k<aufgabenblocknamenpre.length; k++) {
                    aufgabenblocknamen = aufgabenblocknamenpre[k].split("\">\n" + "public");
                    aufgabe.aufgabeklassen.get(k-1).name = aufgabenblocknamen[0];
                }
                for(int j=1; j< NameBabystepTimetracking.length; j++) {
                    if(j==1) aufgabe.name = NameBabystepTimetracking[j];
                    if(j==3) aufgabe.config.babystep.value = NameBabystepTimetracking[j];
                    if(j==5) aufgabe.config.timetracking = NameBabystepTimetracking[j];
                    j++;
                }
                katalog.add(aufgabe);
            }
            System.out.println(katalog.get(0).name + katalog.get(0).config.timetracking + katalog.get(0).config.babystep.value + katalog.get(0).description + katalog.get(0).aufgabeklassen.get(0).name + katalog.get(0).aufgabeklassen.get(0).preset);

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
        s = s + "\n </" + typ + ">\n";
        return s;
    }

    private static String getTag(String tag, boolean open){
        if (open) return "<" + tag + ">\n";
        return "</" + tag + ">\n";
    }
}
