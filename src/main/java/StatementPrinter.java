import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class StatementPrinter {

  public String print(Invoice invoice, HashMap<String, Play> plays) {
    PrintedInvoice pi = new PrintedInvoice(invoice, plays);
    return pi.print();
  }

  public void toHTML(String result) throws IOException{
    File f = new File("source.html");
    BufferedWriter bw = new BufferedWriter(new FileWriter(f));
    bw.write("<html>\n");
    bw.write("<p>\n");
    bw.write(result);
    bw.write("</p>\n");
    bw.write("</body>\n</html>\n");
    bw.close();
  }
}
