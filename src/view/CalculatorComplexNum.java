package view;

import controller.CalcController;
import model.ComplexNumber;
import service.Calculable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculatorComplexNum {
    private final static Map<String, Calculable> operations = new HashMap<>();
    private static CalcController controller = new CalcController();
    private static Loggable logger = new ConsoleLogger();


    static {
       operations.put("+", args -> new ComplexNumber(args[0].getReal()+args[1].getReal(),args[0].getImage()+args[1].getImage()));
       operations.put("-", args -> new ComplexNumber(args[0].getReal()-args[1].getReal(),args[0].getImage()-args[1].getImage()));
       operations.put("*", args -> new ComplexNumber(args[0].getReal()*args[1].getReal()-args[0].getImage()*args[1].getImage()
               ,args[0].getImage()*args[1].getReal()+args[0].getReal()*args[1].getImage()));
       operations.put("/", args -> controller.calculate(args));

    }



    public ComplexNumber calculate() throws Exception {
        double real1 = Double.parseDouble(prompt("Введите вещественную часть первго числа: "));
        double image1 = Double.parseDouble(prompt("Введите мнимую часть первого числа: "));
        ComplexNumber complexNumber1 = new ComplexNumber(real1,image1);
        String operator = prompt("Enter math operation (+ / - *): ");
        double real2 = Double.parseDouble(prompt("Введите вещественную часть второго числа: "));
        double image2 = Double.parseDouble(prompt("Введите мнимую часть второго числа: "));
        ComplexNumber complexNumber2 = new ComplexNumber(real2,image2);


        if (operations.containsKey(operator)){
            //System.out.println(String.format("(%s) %s (%s)", complexNumber1,operator,complexNumber2));
            logger.log(String.format("(%s) %s (%s)", complexNumber1,operator,complexNumber2));
            return operations.get(operator).calculate(complexNumber1, complexNumber2);}
        else{
            throw new RuntimeException("Unsupported math operation");}
    }
     private static String prompt(String message) {
        System.out.println(message);
        return new Scanner(System.in).next();
    }
    public void ViewCalc() {
        try {
            System.out.println(calculate());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}



