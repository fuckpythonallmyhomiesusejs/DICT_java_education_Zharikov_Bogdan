import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        // Отримуємо поточний рік
        int currentYear = java.time.Year.now().getValue();

        // Виводимо привітання та інформацію про бота
        System.out.println("Hello! My name is MyBot.");
        System.out.println("I was created in " + currentYear + ".");

        // Створюємо об'єкт Scanner для зчитування імені користувача
        Scanner scanner = new Scanner(System.in);

        // Запитуємо у користувача його ім'я
        System.out.println("Please, remind me your name.");
        String userName = scanner.nextLine();

        // Виводимо персональне привітання з іменем користувача
        System.out.println("What a great name you have, MyName " + userName + "!");

        // Спробуємо вгадати вік користувача
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        // Зчитуємо залишки від ділення на 3, 5 і 7
        int remainder3 = Integer.parseInt(scanner.nextLine());
        int remainder5 = Integer.parseInt(scanner.nextLine());
        int remainder7 = Integer.parseInt(scanner.nextLine());

        // Обчислюємо вік за формулою
        int userAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        // Виводимо вгаданий вік
        System.out.println("Your age is " + userAge + "; that's a good time to start programming!");

        // Запитуємо у користувача позитивне число
        System.out.println("Now I will prove to you that I can count to any number you want!");
        int userNumber = Integer.parseInt(scanner.nextLine());

        // Починаємо підрахунок від 1 до введеного числа
        for (int i = 1; i <= userNumber; i++) {
            System.out.println(i + "!");
        }

        // Проведення тесту
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods in Java?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");

        // Зчитуємо відповідь користувача
        int userAnswer;
        do {
            userAnswer = Integer.parseInt(scanner.nextLine());
            if (userAnswer != 2) {
                System.out.println("Please, try again.");
            }
        } while (userAnswer != 2);

        // Виводимо повідомлення про правильну відповідь
        System.out.println("Congratulations, " + userName + "! You got it right!");

        // Додаємо повідомлення про завершення
        System.out.println("Goodbye, have a nice day!");
    }
}
