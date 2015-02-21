package com.dolphinziyo.android.testingflavorscalc;

/**
 * Creado por dolphinziyo el 19/02/2015.
 * http://www.tecnogame.org
 * http://twitter.com/dolphinziyo
 */

public class Calculadora {
    double num1, num2;

    Calculadora(double num1, double num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public double sumar(){
        return num1 + num2;
    }

    public double restar(){
        return num1 - num2;
    }

    public double multiplicar(){
        return num1 * num2;
    }

    public double dividir(){
        return num1 / num2;
    }
}
