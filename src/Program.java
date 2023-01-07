import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("src/code.txt")));
        Lexer lexer = new Lexer();
        lexer.scan();
    }
}
