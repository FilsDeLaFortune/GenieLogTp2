public abstract class Play {

  public String name;

  public Play(String name) {
    this.name = name;
  }

  public abstract float price(Customer c, int audience);
  public abstract float bonus(Customer c, int audience);
}
