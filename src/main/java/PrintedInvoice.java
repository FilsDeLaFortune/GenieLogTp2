import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class PrintedInvoice{

    float totalAmount = 0;
    int volumeCredits = 0;
    NumberFormat frmt;


    // Changer en liste parce que sinon pb instantiation
    List <Seat> seats = new ArrayList<>();

    String client;
    String result ="";

    public PrintedInvoice(Invoice invoice, HashMap<String, Play> plays){

        client = invoice.customer;
        frmt = NumberFormat.getCurrencyInstance(Locale.US);
        for (Performance perf : invoice.performances) {
            Play play = plays.get(perf.playID);
            
            Seat s = new Seat();
            s.name = play.name; 
            s.audience = perf.audience;
            s.price = play.price(perf.audience);

            totalAmount += s.price;
            volumeCredits += play.bonus(perf.audience);
            seats.add(s);

        }
    }

    // Faire printToString et printToHTML
    public String print(){
        result += String.format("Statement for %s\n", client);
        for(Seat s : seats){
            result += String.format("  %s: %s (%s seats)\n", s.name, frmt.format(s.price), s.audience);
        }
        result += String.format("Amount owed is %s\n",frmt.format(totalAmount));
        result += String.format("You earned %s credits\n", volumeCredits);

        return result;
    }
}