package FileIO;

import java.io.*;
import java.util.ArrayList;

public class FileIO {

    private static Writer writer;

    private static Reader reader;

    private static String filename = "catalog.txt";

    public static void writeKatalog(ArrayList<Aufgabe> katalog) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
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
}
