package FileIO;

/**
 * Created by Lionel on 24.06.2016.
 */

// Class for the programmingtask objects
public class Project {
    public String code;
    public String test;

    public String getClassName(int i){
        //returns class;
        return "convert()";
    }

    public String getTestName(int i){
        //returns test;
        return "aTest()";
    }

    public Project(String c, String t){
        this.code = "public class TestCode{\n" +
                "            public static String convert(){\n" +
                "            return null;\n" +
                "            }\n" +
                "            }";
        this.test = "import static org.junit.Assert.*;\n" +
                "            import org.junit.Test;\n" +
                "\n" +
                "            public class TestTest{\n" +
                "\n" +
                "            @Test\n" +
                "            public void aTest(){\n" +
                "            assertEquals(null,TestCode.convert());\n" +
                "            }\n" +
                "\n" +
                "            }";
    }

}
