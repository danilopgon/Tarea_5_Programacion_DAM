package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author DaniLopez
 */
public class Ejercicio2 {

    //Implementamos el algoritmo de Euclides de manera recursiva
    private static int euclidesRecursivo(int x, int y) {
        //En el momento en que ambos números son iguales, el método devuelve 1 de ellos: el máximo común divisor
        //El return, además, cumple la función de salir del método anticipadamente cuando el resultado es correcto
        if (x == y) {
            return x;
            //Si x es mayor que y, restamos y a x
        } else if (x > y) {
            x = x - y;
            //Si y es mayor que x, restamos x a y
        } else if (y > x) {
            y = y - x;
        }

        //En caso de que no se haya encontrado el máximo común divisor, el método se llama a sí mismo con los números ya introducidos
        return euclidesRecursivo(x, y);
    }

    public static void main(String[] args) {
        //Pedimos ambos números por pantalla
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer número entero: ");
        int primerNumero = sc.nextInt();
        System.out.println("Introduce el segundo número entero: ");
        int segundoNumero = sc.nextInt();

        //Pasamos los números al método recursivo y mostramos el resultado por pantalla
        System.out.println("m.c.d.(" + primerNumero + ", " + segundoNumero + ") = " + euclidesRecursivo(primerNumero, segundoNumero));
    }
}
