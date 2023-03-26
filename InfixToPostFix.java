import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InfixToPostFix {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java InfixToPostfix <file_name>");
            return;
        }

        String fileName = args[0];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                Expression expression = new Expression(line);
                String postfix = expression.toPostfix();
                System.out.println("Infix: " + line + " | Postfix: " + postfix);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading input file");
        }
    }
}
