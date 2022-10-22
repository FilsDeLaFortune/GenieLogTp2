public abstract class Play {

  public String name;

  public Play(String name) {
    this.name = name;
  }

  public abstract float price(int audience);
  public abstract float bonus(int audience);
}
