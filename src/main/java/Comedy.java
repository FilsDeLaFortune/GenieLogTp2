public class Comedy extends Play {

    public Comedy(String name) {
        super(name);
    }

    @Override
    public float price(int audience) {
        float price = 0;
        if(audience > 20)
        {
            price += 100 + 5.00*(audience-20);
        }
        price += 3*audience;
        return price + 400;
    }

    @Override
    public float bonus(int audience) {
        int volumeCredits = 0;
        volumeCredits += Math.max(audience - 30, 0);
        volumeCredits += Math.floor(audience / 5);
        return volumeCredits;
    }
    
    
}
