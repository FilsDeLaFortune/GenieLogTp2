
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("hamlet", new Tragedy("Hamlet"));
        plays.put("as-like", new Comedy("As You Like It"));
        plays.put("othello", new Tragedy("Othello"));

        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("hamlet", 55),
            new Performance("as-like", 35),
            new Performance("othello", 40)));

        StatementPrinter statementPrinter = new StatementPrinter();
        System.out.println(statementPrinter.print(invoice, plays));
        statementPrinter.printToHTML(invoice, plays);
    }
}
