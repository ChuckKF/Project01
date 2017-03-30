public class GuessingGame {

  public static void main(String[] args) {
    Jar jar = new Jar("Item", 0);
    Prompter prompter = new Prompter(jar);
    
    prompter.setItemName();
    prompter.setItemLimit();
    jar.fillJar();
    
    while (!jar.isWon()) {
      prompter.promptForGuess();
      prompter.isGuessClose();
    }
    
    if (jar.isWon()) {
      prompter.victoryMessage();
    }
    
  }
}
