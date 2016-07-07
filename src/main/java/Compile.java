import FileIO.Project;
import vk.core.api.*;
/**
 * Created by Lionel on 05.07.2016.
 */
public class Compile {  // Verknüpft mit API KATA von Bendisposto
    String outmessage = "";
    public Compile(Project Proj){
        CompilationUnit code = new CompilationUnit(Proj.getClassName(TDDT.currenttask),Main.tcontroller.getLeftTextArea(),false);
        CompilationUnit test = new CompilationUnit(Proj.getTestName(TDDT.currenttask),Main.tcontroller.getRightTextArea(),true);

        JavaStringCompiler compiler = CompilerFactory.getCompiler(code,test);
        compiler.compileAndRunTests();
        outmessage += compiler.getCompilerResult().toString();
        DEBUG.out(outmessage);
    }

}
