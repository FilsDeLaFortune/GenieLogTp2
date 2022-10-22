import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class PrintedInvoice{

    NumberFormat frmt;

    float totalAmount = 0;
    int volumeCredits = 0;
    String client;

    List <Seat> seats = new ArrayList<Seat>();
    StringBuffer str = new StringBuffer();

    public PrintedInvoice(Invoice invoice, HashMap<String, Play> plays){

        client = invoice.customer;
        frmt = NumberFormat.getCurrencyInstance(Locale.US);

        for (Performance perf : invoice.performances) {

            Play play = plays.get(perf.playID);
            Seat s = new Seat();

            // Permet un stockage facile des 3 valeurs pour le print d'après
            s.name = play.name; 
            s.audience = perf.audience;
            s.price = play.price(perf.audience);

            // Remontée des informations
            totalAmount += s.price;
            volumeCredits += play.bonus(perf.audience);
            seats.add(s);
        }
    }

    // Faire printToString et printToHTML
    public String printToString(){
        str.append(String.format("Statement for %s\n", client));
        for(Seat s : seats){
            str.append(String.format("  %s: %s (%s seats)\n", s.name, frmt.format(s.price), s.audience));
        }
        str.append(String.format("Amount owed is %s\n",frmt.format(totalAmount)));
        str.append(String.format("You earned %s credits\n", volumeCredits));

        return str.toString();
    }

    public void printToHTML() throws IOException{
    File f = new File("source.html");
    BufferedWriter bw = new BufferedWriter(new FileWriter(f));
    bw.write("<html>\n");

    bw.write("<head>");
    bw.write("<style>");
    bw.write("table, th, td { border: 1px solid black; }");
    bw.write("</style>");
    bw.write("</head>");

    bw.write("<body>");

    bw.write("<h3><b>Invoice</b></h3>");
    bw.write(String.format("<b>Client :</b> %s", client));
    bw.write("<table>\n");

    bw.write("<thead><tr>\n");
    bw.write("<th>Piece</th>\n");
    bw.write("<th>Seats Sold</th>\n");
    bw.write("<th>Price</th>\n");
    bw.write("</tr></thead>\n");

    bw.write("<tbody>\n");

    for(Seat s : seats){
        bw.write("<tr>");
        bw.write(String.format("<td>%s</td>",s.name));
        bw.write(String.format("<td>%s</td>",s.audience));
        bw.write(String.format("<td>%s</td>",frmt.format(s.price)));
        bw.write("</tr>");
    }
    bw.write(String.format("<tr><td colspan=2>Total owed</td><td>%s</td></tr>", frmt.format(totalAmount)));
    bw.write(String.format("<tr><td colspan=2>Fidelity points earned</td><td>%s</td></tr>", volumeCredits));
    bw.write("</tbody>\n");
    bw.write("</table>\n");

    bw.write("<p><i>Payment required in 30 days.</i></p>");

    bw.write("</body>\n");

    bw.write("</html>\n");

    bw.close();
  }
}