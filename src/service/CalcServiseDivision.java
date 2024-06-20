package service;

import model.ComplexNumber;

public class CalcServiseDivision implements Calculable {

    @Override
    public ComplexNumber calculate(ComplexNumber... args) throws Exception {
        if ((args[1].getImage()) == 0 && (args[1].getReal()) == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        ComplexNumber numerator = null;
        ComplexNumber denominator= null;
        numerator = new ComplexNumber(args[0].getReal()*args[1].getReal()- args[0].getImage()*(-args[1].getImage())
                ,args[0].getReal()*(-args[1].getImage())+args[0].getImage()*args[1].getReal()
               );
        denominator = new ComplexNumber(Math.pow(args[1].getReal(),2)+Math.pow(args[1].getImage(),2),0);

        return new ComplexNumber(numerator.getReal()/denominator.getReal(),numerator.getImage()/denominator.getReal());

    }


}


