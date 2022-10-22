import java.io.IOException;
import java.util.HashMap;

public class StatementPrinter {

  public String print(Invoice invoice, HashMap<String, Play> plays) {
    PrintedInvoice pi = new PrintedInvoice(invoice, plays);
    return pi.printToString();
  }

  public void printToHTML(Invoice invoice, HashMap<String, Play> plays) throws IOException{
    PrintedInvoice pi = new PrintedInvoice(invoice, plays);
    pi.printToHTML();
  }
}
