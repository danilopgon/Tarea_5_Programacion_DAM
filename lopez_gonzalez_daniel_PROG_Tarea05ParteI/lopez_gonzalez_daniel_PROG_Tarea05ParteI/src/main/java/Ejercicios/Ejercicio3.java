package Ejercicios;

import java.util.Scanner;
import java.util.function.BiFunction;

/**
 *
 * @author DaniLopez
 */
public class Ejercicio3 {

    //Vamos a reutilizar el método del ejercicio enterior para calcular el máximo común divisor, que utilizaremos para calcular el minimo común multiplo
    private static int euclidesRecursivo(int x, int y) {
        if (x == y) {
            return x;
        } else if (x > y) {
            x = x - y;
        } else if (y > x) {
            y = y - x;
        }

        //En caso de que no se haya encontrado el máximo común divisor, el método se llama a sí mismo con los números ya introducidos
        return euclidesRecursivo(x, y);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer número entero: ");
        int primerNumero = sc.nextInt();
        System.out.println("Introduce el segundo número entero: ");
        int segundoNumero = sc.nextInt();

        int maximoComunDivisor = euclidesRecursivo(primerNumero, segundoNumero);

        // Definimos una interfaz Bifunction que realiza la siguiente formula para calcular mínimo común multiplo:
        // M.C.M. (a, b) = (a x b) / m.c.d.
        BiFunction<Integer, Integer, Integer> minimoComunMultiplo = (x, y) -> (x * y) / maximoComunDivisor;

        //Imprimimos los resultados por pantalla
        System.out.println("El mínimo común múltiplo de " + primerNumero + " y " + segundoNumero + " es: " + minimoComunMultiplo.apply(primerNumero, segundoNumero));

    }
}
