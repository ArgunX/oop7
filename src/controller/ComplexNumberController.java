package controller;

import model.ComplexNumber;

public interface ComplexNumberController<T extends ComplexNumber> {

    T calculate(T ... args);

}
