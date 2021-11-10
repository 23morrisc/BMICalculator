import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Prints BMI based on user input
 * @version 09/11/2021
 * @author 23morrisc
 */

public class BMICalculator {

    /**
     * calculates MBI with inches and weight
     * @param inches
     * @param pounds
     * @return BMI
     */

    public static double computeBMI(int inches,int pounds){
        if (inches <=0 || pounds < 0)
            return 0;
        return pounds*.454 / Math.pow(inches*.0254, 2);
    }

    /**
     * converts string height in ft'in" to an in of inches
     * @param value
     * @return height in inches as an int
     */

    public int extractInt(String value) {
        int qtPos = value.indexOf("'");
        int dblQtPos = value.indexOf("\"");
        if (qtPos == -1 || dblQtPos == -1) {
            return -1;
        }
        int feet = Integer.parseInt(value.substring(0, qtPos));
        int inches = Integer.parseInt(value.substring(qtPos+1, dblQtPos));

        if (inches < 0 || inches > 11 || feet < 0) {
            return -1;
        }

        return (feet*12+inches == 0) ? -1 : feet*12+inches;
    }
/*
    public static int parseString(String height) {

        try {

            int inches = extractInt(height);
            return inches;

        }
        catch(Exception yourMom) {
            return -1;
        }
    }
*/
    public static void main(String[] args) {
        BMICalculator obj = new BMICalculator();
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        while(true) {

            //user inputs

            System.out.print("Enter height in format (ft)'(inches)\": ");
            String height = in.nextLine();
            System.out.print("Enter weight in format (weight): ");
            Integer weight = in.nextInt();
            in.nextLine();

            //calculate and print BMI

            int inches = obj.extractInt(height);;
            System.out.println("Your BMI: " + df.format(computeBMI(inches, weight)));

            //prompt for whether the user wants to run again

            System.out.println("continue? (y/n)");
            String cont = in.nextLine();

            if(!cont.toLowerCase().equals("y")) {
                System.out.println("Exiting...");
                break;
            }
        }
    }
}
