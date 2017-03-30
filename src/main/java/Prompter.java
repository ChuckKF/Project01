import java.util.Scanner;

class Prompter {
  public Jar jar;
  
  public Prompter(Jar jar) {
    this.jar = jar;
  }
  
  Scanner scanner = new Scanner(System.in);
  
  public String setItemName() {
    System.out.printf("||||| ADMINITSTRATOR SETUP |||||\n");
    System.out.printf("What type of item? \n");
    jar.itemName = scanner.nextLine();
    return jar.itemName;
  }
  
  public int setItemLimit() {
    System.out.printf("What is the maximum amount of %s?\n",
                      jar.itemName);
    jar.maximumNumber = scanner.nextInt();
    scanner.nextLine();
    System.out.printf("||||| END ADMINISTRATOR SETUP |||||\n");
    return jar.maximumNumber;
  }
  
  public boolean promptForGuess() {
    ++jar.numberOfGuesses;
    System.out.printf("How many %s are in the jar? Pick a number between 1 and %d.\n",
                      jar.itemName, jar.maximumNumber);
    jar.userGuess = scanner.nextInt();
    scanner.nextLine();
    
    if (jar.userGuess > jar.maximumNumber) {
      System.out.printf("Your guess must be less than %d.\n",
                        jar.maximumNumber);
      jar.numberOfGuesses--;
    } else if (jar.userGuess < 1) {
      System.out.printf("Your guess must be more than 0.\n");
      jar.numberOfGuesses--;
    }
    return jar.isCorrectGuess(jar.userGuess);
  }
  
  public void isGuessClose() {
    if (jar.userGuess > jar.numberOfItemsInJar) {
      System.out.printf("Your guess was too high\n");
    } else if (jar.userGuess < jar.numberOfItemsInJar) {
      System.out.printf("Your guess was too low\n");
    }
  }
  
  public void victoryMessage() {
    if (jar.numberOfGuesses > 1) {
    System.out.printf("Congratulations! You got it in %d attempts.\n",
                      jar.numberOfGuesses);
    } else {
      System.out.printf("Congratulations! You got it in %d attempt.\n",
                        jar.numberOfGuesses);
    }
  }
}