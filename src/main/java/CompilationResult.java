/**
 * Created by Lionel on 11.07.2016.
 */
public class CompilationResult {
    public static boolean isTest;
    public static String outmessage;
    public static boolean hasErrors;
    public static int numberOfFailedTest;
    public static int numberOfSuccessfullTest;

    public CompilationResult(boolean isTest,String o, boolean h, int n, int s){
        this.isTest = isTest;
        this.outmessage = o;
        this.hasErrors = h;
        this.numberOfFailedTest = n;
        this.numberOfSuccessfullTest = s;
    }

    public CompilationResult(boolean isTest,String o, boolean h){
        this.isTest = isTest;
        this.outmessage = o;
        this.hasErrors = h;
    }
}
