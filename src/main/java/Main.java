
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("hamlet",  new Play("Hamlet", "tragedy"));
        plays.put("as-like",  new Play("As You Like It", "comedy"));
        plays.put("othello",  new Play("Othello", "tragedy"));

        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("hamlet", 55),
            new Performance("as-like", 35),
            new Performance("othello", 40)));

        StatementPrinter statementPrinter = new StatementPrinter();
        String res = statementPrinter.print(invoice, plays);
        statementPrinter.toHTML(res);
        
    }

    
        
}
