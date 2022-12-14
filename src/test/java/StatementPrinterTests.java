import static org.approvaltests.Approvals.verify;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StatementPrinterTests {

    @Test
    void exampleStatement() {

        HashMap<String, Play> plays = new HashMap<>();
        plays.put("hamlet",  new Tragedy("Hamlet"));
        plays.put("as-like",  new Comedy("As You Like It"));
        plays.put("othello",  new Tragedy("Othello"));

        Customer c = new Customer("BigCo");
        Invoice invoice = new Invoice(c, List.of(
            new Performance("hamlet", 55),
            new Performance("as-like", 35),
            new Performance("othello", 40)));

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice, plays);

        verify(result);
    }
/* 
    @Test
    void statementWithNewPlayTypes() {

        HashMap<String, Play> plays = new HashMap<>();
        plays.put("henry-v",  new Play("Henry V", "history"));
        plays.put("as-like",  new Play("As You Like It", "pastoral"));

        Invoice invoice = new Invoice("BigCo", List.of(
            new Performance("henry-v", 53),
            new Performance("as-like", 55)));

        StatementPrinter statementPrinter = new StatementPrinter();
        Assertions.assertThrows(Error.class, () -> {
            statementPrinter.print(invoice, plays);
        });
    }
    */
}