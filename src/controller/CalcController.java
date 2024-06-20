package controller;

import model.ComplexNumber;
import service.CalcServiseDivision;

public class CalcController implements ComplexNumberController{
    CalcServiseDivision calc = new CalcServiseDivision();

    @Override
    public ComplexNumber calculate(ComplexNumber[] args) {
        ComplexNumber complexNumber = null;
        try {
                complexNumber = calc.calculate(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        return complexNumber;
    }
}
