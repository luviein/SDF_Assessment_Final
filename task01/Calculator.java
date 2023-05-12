package task01;

import java.io.Console;

public class Calculator{

    public static void main(String[] args) {
        Console cons = System.console();
        boolean toContinue = true;

        while(toContinue){
            String userInput = cons.readLine(">").trim().toLowerCase();
            int x = Integer.parseInt(userInput.trim().split(" ")[0]);
            int y = Integer.parseInt(userInput.trim().split(" ")[2]);
            String operator = userInput.trim().split(" ")[1];
            int last = 0;
            switch(operator){
                case "+": 
                    last = x + y;
                    break;
                case "-":
                    last = x - y;
                    break;
                case "/":
                    last = x / y;
                    break;
                case "*":
                    last = x * y;
                    break;
                default:
                    System.out.println("Enter one of these operators: '+', '-', '/', '*'" );
                

            }

            System.out.println(last);
            String toQuit = cons.readLine(">").trim().toLowerCase();
            if(toQuit.equals("exit")){
                System.out.println("Bye bye");
                toContinue = false;
                break;
            }
        }
    }




}