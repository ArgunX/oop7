package service;

import model.ComplexNumber;

public interface Calculable<T extends ComplexNumber> {
    T calculate(T ... args) throws Exception;




}
