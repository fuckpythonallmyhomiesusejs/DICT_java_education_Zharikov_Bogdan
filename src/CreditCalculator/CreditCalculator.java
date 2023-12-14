import java.util.Scanner;
import java.lang.Math;
public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = "";
        double principal = 0;
        double payment = 0;
        int periods = 0;
        double interest = 0;

        for (int i = 0; i < args.length; i += 2) {
            String argName = args[i];
            String argValue = args[i + 1];

            switch (argName) {
                case "-Dtype":
                    type = argValue;
                    break;
                case "-Dprincipal":
                    principal = Double.parseDouble(argValue);
                    break;
                case "-Dpayment":
                    payment = Double.parseDouble(argValue);
                    break;
                case "-Dperiods":
                    periods = Integer.parseInt(argValue);
                    break;
                case "-Dinterest":
                    interest = Double.parseDouble(argValue) / 100 / 12;
                    break;
            }
        }
        if (type.equals("diff")) {
            if (payment == 0) {
                double totalPayment = 0;
                for (int month = 1; month <= periods; month++) {
                    double monthlyPayment = principal / periods + interest * (principal - (principal * (month - 1)) / periods);
                    System.out.println("Month " + month + ": payment is " + (int) Math.ceil(monthlyPayment));
                    totalPayment += monthlyPayment;
                }
                System.out.println("\nOverpayment = " + (int) Math.ceil(totalPayment - principal));
            } else {
                System.out.println("Incorrect parameters.");
            }
        } else if (type.equals("annuity")) {
            if (payment == 0) {
                double annuityPayment = principal * (interest * Math.pow(1 + interest, periods)) / (Math.pow(1 + interest, periods) - 1);
                System.out.println("Your annuity payment = " + (int) Math.ceil(annuityPayment) + "!");
            } else if (periods == 0) {
                periods = (int) Math.ceil(Math.log(payment / (payment - interest * principal)) / Math.log(1 + interest));
                int years = periods / 12;
                int months = periods % 12;
                System.out.println("It will take " + years + " years and " + months + " months to repay this loan!");
            } else if (principal == 0) {
                principal = payment / ((interest * Math.pow(1 + interest, periods)) / (Math.pow(1 + interest, periods) - 1));
                System.out.println("Your loan principal = " + (int) Math.ceil(principal) + "!");
            }
        } else {
            System.out.println("Incorrect parameters.");
        }
    }
}
