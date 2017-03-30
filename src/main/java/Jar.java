import java.util.Random;

public class Jar {
  Random random = new Random();
  int numberOfItemsInJar;
  int maximumNumber;
  public String itemName;
  public int someNumber;
  int userGuess;
  int numberOfGuesses = 0;
  boolean isCorrectGuess = false;
  
  public Jar(String itemName, int maximumNumber) {
    this.maximumNumber = maximumNumber;
    this.itemName = itemName;
  }

  public int fillJar() {
    someNumber = random.nextInt(maximumNumber) + 1;
    System.out.printf("The Jar has been filled with a random number of %s!\n",
                       itemName);
    return numberOfItemsInJar = someNumber;
  }
  
  public boolean isCorrectGuess(int userGuess) {
    if (userGuess == numberOfItemsInJar) {
      isCorrectGuess = true;
    }
    return isCorrectGuess;
  }
  
  public boolean isWon() {
    return isCorrectGuess(userGuess);
  }
}