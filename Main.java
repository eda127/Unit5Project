import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String loop = "looping";
        System.out.println("Enter q into the equation field to quit calculating");

        while(!loop.equals("q")) {
            System.out.println("Enter your equation: ");    
            String equation = input.nextLine();
            
            // quitting calculator
            if (equation.equals("q")) {
                loop = "q";
                break;
            }

            // simplifying fraction
            else if (equation.substring(0, equation.indexOf("(")).equals("simplify")) {
                  int slashPos = equation.indexOf("/");
                  int top = Integer.valueOf(equation.substring(equation.indexOf("(")+1, slashPos));
                  int bottom = Integer.valueOf(equation.substring(slashPos+1, equation.indexOf(")")));

                  Fraction fr1 = new Fraction(top, bottom);
                  System.out.println(fr1);
            }              

            else {
                // finding the position and type of operation
                int operationPos = equation.indexOf(")")+1;
                String operation = equation.substring(operationPos, operationPos+1);

                // finding the position of the first slash in the first fraction and getting the numbers based on that and the parenthesis
                int firstSlashPos = equation.indexOf("/");
                int topOfFirst = Integer.valueOf(equation.substring(1, firstSlashPos));
                int bottomOfFirst = Integer.valueOf(equation.substring(firstSlashPos+1, equation.indexOf(")")));
               
                // same here, but it starts after the position of the operation
                int secondSlashPos = equation.indexOf("/", operationPos+1);
                int topOfSecond = Integer.valueOf(equation.substring(operationPos+2, secondSlashPos));
                int bottomOfSecond = Integer.valueOf(equation.substring(secondSlashPos+1, equation.length()-1));

                Fraction fr1 = new Fraction(topOfFirst, bottomOfFirst);
                Fraction fr2 = new Fraction(topOfSecond, bottomOfSecond);
                
                if      (operation.equals("+")) System.out.println(fr1.add     (topOfSecond, bottomOfSecond));
                else if (operation.equals("-")) System.out.println(fr1.subtract(topOfSecond, bottomOfSecond));
                else if (operation.equals("*")) System.out.println(fr1.multiply(topOfSecond, bottomOfSecond));
                else if (operation.equals("/")) System.out.println(fr1.divide  (topOfSecond, bottomOfSecond));
                else if (operation.equals("<") ||
                         operation.equals(">") ||
                         operation.equals("=")) System.out.println(fr1.compare (topOfSecond, bottomOfSecond));
                else                            System.out.println("Not a valid operator");
            }
        }
        System.out.println("Calculator closed");
    }
}