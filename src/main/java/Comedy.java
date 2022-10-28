public class Comedy extends Play {

    public Comedy(String name) {
        super(name);
    }

    @Override
    public float price(Customer c,int audience) {
        float price = 0;
        if(audience > 20)
        {
            price += 100 + 5.00*(audience-20);
        }
        price += 3*audience;
        if(c.points >= 150) price -= 15;
        return price + 400;
    }

    @Override
    public float bonus(Customer c, int audience) {
        int volumeCredits = 0;
        volumeCredits += Math.max(audience - 30, 0);
        volumeCredits += Math.floor(audience / 5);
        c.points += volumeCredits;
        return volumeCredits;
    }
    
    
}
