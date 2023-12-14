import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        // Список слів для вибору
        String[] wordList = {"python", "java", "javascript", "kotlin"};

        // Випадково вибираємо слово зі списку
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.length);
        String secretWord = wordList[randomIndex];

        // Змінні для відслідковування спроб та введених букв
        int remainingAttempts = 8;
        StringBuilder guessedWord = new StringBuilder("-".repeat(secretWord.length()));
        StringBuilder attemptedLetters = new StringBuilder();

        // Виведення анонсу гри "HANGMAN"
        System.out.println("HANGMAN");
        System.out.println("Type \"play\" to play the game, \"exit\" to quit: ");

        // Головний цикл гри
        while (remainingAttempts > 0) {
            System.out.println(guessedWord);
            System.out.print("Input a letter: > ");
            Scanner scanner = new Scanner(System.in);
            String playerGuess = scanner.next().toLowerCase(); // Перетворюємо введену літеру в малу букву

            if (playerGuess.length() != 1 || !Character.isLowerCase(playerGuess.charAt(0))) {
                // Перевірка, чи введено лише одну малу букву
                System.out.println("You should input a single lowercase English letter");
            } else if (attemptedLetters.toString().contains(playerGuess)) {
                // Гравець вже намагався вгадати цю букву
                System.out.println("You've already guessed this letter");
            } else if (secretWord.contains(playerGuess)) {
                // Гравець вгадав правильно
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == playerGuess.charAt(0)) {
                        guessedWord.setCharAt(i, playerGuess.charAt(0));
                    }
                }
            } else {
                // Гравець помилився
                System.out.println("That letter doesn't appear in the word");
                remainingAttempts--;
            }

            attemptedLetters.append(playerGuess);

            // Перевірка, чи гравець вгадав всі літери та залишилася хоча б одна спроба
            if (guessedWord.toString().equals(secretWord) && remainingAttempts > 0) {
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                break;
            }
        }

        // Закінчення гри
        if (remainingAttempts == 0) {
            System.out.println("Type \"play\" to play the game, \"exit\" to quit: ");
        }
    }
}