public class Tragedy extends Play {

    public Tragedy(String name) {
        super(name);
    }

    @Override
    public float price(int audience) {
        float price = 0;
        if(audience > 30)
        {
            price += 10*(audience-30);
        }
        return price + 400;
    }

    @Override
    public float bonus(int audience) {
        int volumeCredits = 0;
        volumeCredits += Math.max(audience - 30, 0);
        return volumeCredits;
    }
    
}
