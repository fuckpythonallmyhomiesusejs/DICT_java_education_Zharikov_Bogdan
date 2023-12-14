package CoffeeMachine;
import java.util.Scanner;
public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disposableCups = 9;
        this.money = 550;
    }
    public void processUserInput(String action) {
        switch (action) {
            case "buy": buyCoffee();
            break;
            case "fill": fillMachine();
            break;
            case "take": takeMoney();
            break;
            case "remaining": displayMachineStatus();
            break;
            case "exit":
                break;
            default: System.out.println("Invalid action. Please try again.");
        }
    }
    private void buyCoffee() {
    }
    private void fillMachine() {
    }
    private void takeMoney() {
    }
    private void displayMachineStatus() {
    }
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            coffeeMachine.processUserInput(action);

            if ("exit".equals(action)) {
                isRunning = false;
            }
        }
    }
}
