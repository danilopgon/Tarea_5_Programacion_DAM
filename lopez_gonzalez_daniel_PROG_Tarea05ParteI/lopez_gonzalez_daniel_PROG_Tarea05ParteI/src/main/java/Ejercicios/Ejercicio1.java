package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author DaniLopez
 */
public class Ejercicio1 {

    //Calculamos la serie de Fibonacci de manera recursiva
    private static int fibonacciRecursivo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        return fibonacciRecursivo(n - 2) + fibonacciRecursivo(n - 1);

    }

    //Lo probamos en un main que pide la cantidad de números que hay que mostrar en la serie al usuario
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cantidad de números que generar en la sucesión: ");
        int sucesion = sc.nextInt();

        System.out.print("La serie de Fibonacci para los " + sucesion + " primeros números sera: ");

        //Los números se van escribiendo mediante un for loop que utiliza la función fibonacciRecursivo
        /*Vamos a solucionar un problema que tenía el mismo ejercicio en la tarea 4, haciendo que el mensaje no acabe con una coma, si no un punto, 
        mediante un condicional que comprueba si es la última vuelta.*/
        for (int i = 0; i < sucesion; i++) {
            if (i == sucesion - 1) {
                System.out.print(fibonacciRecursivo(i) + ".");
            } else {
                System.out.print(fibonacciRecursivo(i) + ", ");
            }
        }
    }
}
