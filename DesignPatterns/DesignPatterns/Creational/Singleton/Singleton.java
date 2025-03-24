public class Singleton {
  // this instance will be created whenever class loads
  // this is eager initialization
  // you could also create a helper class

  private static final Singleton INSTANCE = new Singleton();
  private Singleton() {
    System.out.println("Instance created");
  }
  
  private static class SingletonHelper {
    //private static final Singleton INSTANCE = new Singleton();
    //this would be lazy initialization
    //this would only create instance when called
    //but then returning instance would be different
  }

  public static Singleton getInstance() {
    return INSTANCE;
    // lazy init
    // return SingletonHelper.INSTANCE;
  }

  public void blah() {
    System.out.println("heyyyyyy");
  }

  public static void main(String[] args) {
    Singleton s1 = Singleton.getInstance();

    s1.blah();

    Singleton s2 = Singleton.getInstance();

    System.out.println("same instance??? " + (s1 == s2));
  }
}
