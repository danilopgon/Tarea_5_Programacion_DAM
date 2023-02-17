package Ejercicios;

import java.util.Scanner;
import java.util.function.Function;

/**
 *
 * @author DaniLopez
 */
public class Ejercicio4 {

    public static void main(String[] args) {

        //Interfaz funcional para calcular la primera función
        Function<Double, Double> elevadoADos = (x) -> {
            return (Math.pow(x, 2)) + 1;

        };
        //Interfaz funcional para calcular la segunda función
        Function<Double, Double> raizCubica = (x) -> {
            return (Math.cbrt(x)) + 3;

        };

        //Interfaz funcional para calcular la tercera función
        Function<Double, Double> sinCosFuncion = (x) -> {
            return (Math.sin(x + 3)) * (Math.cos(Math.pow(x, 2)));
        };

        //Solicitamos un número decimal
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un numero decimal para realizar los cálculos: ");
        double numero = sc.nextDouble();

        //Se aplica el resultado y se muestra por pantalla
        Function<Double, Double> encadenamiento = elevadoADos.andThen(raizCubica).andThen(sinCosFuncion);
        System.out.println("El resultado de aplicar los tres interfaces funcionales es: " + encadenamiento.apply(numero));

    }

}