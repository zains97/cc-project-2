import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Lexer {
    Set<Token> tokens = new HashSet<>();
    private char peek = ' ';
    private int peek_byte = 0;
    private int line = 0;

    private void read() throws IOException {
        peek_byte = System.in.read();
        peek = (char) peek_byte;
    }

    private boolean read(char c) throws IOException {
        read();
        if (peek != c) {
            return false;
        }
        peek = ' ';
        return true;
    }

    public void scan() throws IOException {
        while (peek_byte != -1) {
            read();
            if (peek == ' ' || peek == '\t') {
                continue;
            } else if (peek == '\n') {
                line = line + 1;
            } else {
            }

            switch (peek) {
                case '+':
                    if (read('+')){
                        Token increment = new Token(Tag.INCREMENT);
                        tokens.add(increment);
                    }
                    else {
                        Token plus = new Token('+');
                        tokens.add(plus);
                    }
                case '-':
                    if (read('-')){
                        Token decrement = new Token(Tag.DECREMENT);
                        tokens.add(decrement);
                    }
                    else {
                        Token minus = new Token('-');
                        tokens.add(minus);
                    }
                case '>':
                    if (read('=')){
                        Token g_eq = new Token(Tag.G_EQ);
                        tokens.add(g_eq);
                    }
                    else {
                        Token gr = new Token('<');
                        tokens.add(gr);
                    }
                case '<':
                    if (read('=')){
                        Token l_eq = new Token(Tag.L_EQ);
                        tokens.add(l_eq);
                    }
                    else {
                        Token less = new Token('<');
                        tokens.add(less);
                    }
                case '=':
                    if (read('=')){
                        Token eq = new Token(Tag.EQ);
                    }
                    else {

                    }
            }

        }
    }
}
