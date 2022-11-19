package kr.co.programmers.school;

import org.python.util.PythonInterpreter;

import javax.script.*;
import java.io.*;

public class AAAJythonTest {
    public static void main(String[] args) throws IOException, ScriptException {
//        PythonInterpreter pythonInterpreter = new PythonInterpreter();
//        pythonInterpreter.execfile("C:\\Users\\user\\IdeaProjects\\CodingChallenge\\CodingChallenge_Python\\CodeWar\\AAAJythonTest.py");

//        PythonInterpreter pythonInterpreter2 = new PythonInterpreter();
//        pythonInterpreter2.exec("import sys\n"
//        +"sys.argv = ['Foo','Bar']");
//        pythonInterpreter2.execfile("C:\\Users\\user\\IdeaProjects\\CodingChallenge\\CodingChallenge_Python\\CodeWar\\AAAJythonTest.py");

//        Process p = Runtime.getRuntime().exec("C:\\Users\\user\\IdeaProjects\\CodingChallenge\\CodingChallenge_Python\\CodeWar\\AAAJythonTest.py");
//        System.out.println(p);

        StringWriter writer = new StringWriter(); //ouput will be stored here

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptContext context = new SimpleScriptContext();

        context.setWriter(writer); //configures output redirection
        ScriptEngine engine = manager.getEngineByName("python");
        engine.eval(new FileReader("C:\\Users\\user\\IdeaProjects\\CodingChallenge\\CodingChallenge_Python\\CodeWar\\AAAJythonTest.py"), context);
        System.out.println(writer.toString());
    }
}
