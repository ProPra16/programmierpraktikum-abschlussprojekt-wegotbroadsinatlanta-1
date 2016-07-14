import FileIO.Project;
import vk.core.api.*;
import vk.core.internal.InternalCompiler;
import java.util.ArrayList;

/**
 * Created by Lionel on 05.07.2016.
 */
public class Compile {  // Verknüpft mit API KATA von Bendisposto
    String outmessage = "";
    public Compile(){
        DEBUG.out("Starting Compiler");
        Main.self.statusBar.output.setText("Starting Compiler...");
    }

    public static CompilationResult compileCodeandTest(String className1,String code1, boolean isTest1,String className2,String code2, boolean isTest2){
        CompilationUnit CodeComUnit = new CompilationUnit(className1,code1,isTest1);
        CompilationUnit TestComUnit = new CompilationUnit(className2,code2,isTest2);
        JavaStringCompiler compiler = CompilerFactory.getCompiler(CodeComUnit,TestComUnit);
        compiler.compileAndRunTests();
        String out = "";
        out +=  compiler.getCompilerResult().getCompilerErrorsForCompilationUnit(CodeComUnit);
        out +=  compiler.getCompilerResult().getCompilerErrorsForCompilationUnit(TestComUnit);
        DEBUG.out(out);
        boolean h = compiler.getCompilerResult().hasCompileErrors();
        int n = -1;
        int s = -1;
        try{n = compiler.getTestResult().getNumberOfFailedTests(); //FIX Otherwise Crashes
        s = compiler.getTestResult().getNumberOfSuccessfulTests();}catch(Exception e){e.printStackTrace();}
        CompilationResult result = new CompilationResult(true,out,h,n,s);
        return result;
    }

    public static CompilationResult compileCode(String className,String code, boolean isTest){
        DEBUG.out("Starting Compiler with, Classname: " + className + ", isTest: " + isTest);
        CompilationUnit ComUnit = new CompilationUnit(className,code,isTest);
        JavaStringCompiler compiler = CompilerFactory.getCompiler(ComUnit);
        compiler.compileAndRunTests();
        String out = "";
        CompilationResult res;
        boolean h = compiler.getCompilerResult().hasCompileErrors();
        if(isTest){
//            int n = compiler.getTestResult().getNumberOfFailedTests();
//            int s = compiler.getTestResult().getNumberOfSuccessfulTests();
            out +=  compiler.getCompilerResult().getCompilerErrorsForCompilationUnit(ComUnit);
            res = new CompilationResult(isTest,out,h);//,n,s);
        }else{
            out += compiler.getCompilerResult().getCompilerErrorsForCompilationUnit(ComUnit);
            res = new CompilationResult(isTest,out,h);
        }
        DEBUG.out(out);
        DEBUG.out("Code has error: " + h);
        return res;
    }

}
