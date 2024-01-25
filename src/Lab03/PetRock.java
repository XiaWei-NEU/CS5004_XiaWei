package Lab03;

public class PetRock {
  private String name;
  private boolean happy = false;
  private double d1 = 1.0;
  private double d2 = 1.0;
  public PetRock(String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public boolean isHappy() {
    return happy;
  }

  public void playWithRock() {
    happy = true;
  }

  public String getHappyMessage() {
//    if(!happy) {
//      throw new IllegalStateException();
//    }
    return "I'm happy!";
  }

  public String getUnhappyMessage() {
    if(happy) {
      throw new RuntimeException();
    }
    return "I'm unhappy!";
  }

  public int getFavNumber() {
    return 42;
  }

  public void waitTillHappy() {
    while (!happy) {
      // do nothing!
    }
  }

  public double getD1(){ return d1; }

  public double getD2() {
    return d2;
  }

  public String toString(){
    return "PetRock: the name is " + name + ", the happy is " + happy + ", the d1 is " + d1;
  }
}
