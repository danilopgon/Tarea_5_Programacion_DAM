package operaciones;

import almacenes.AntiguedadEnum;
import almacenes.CategoriaEnum;

import datos.*;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class MainTrabajador {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        int edad;
        int categoria;
        int antiguedad;

        //LECTURA DE DATOS DE EMPLEADO:
        System.out.printf("Introduce el nombre: ");
        nombre = sc.nextLine();

        System.out.printf("Introduce la edad: ");
        edad = sc.nextInt();
        sc.nextLine();

        System.out.printf("Introduce la categoría (0 a 5): ");
        categoria = sc.nextInt();
        sc.nextLine();

        System.out.printf("Introduce la antiguedad (0 a 2): ");
        antiguedad = sc.nextInt();
        sc.nextLine();

        AntiguedadEnum antiEnum = AntiguedadEnum.getAntiguedad(antiguedad);

        //LECTURA DE LA FECHA
        System.out.println("FECHA DE ALTA: ");
        System.out.printf("\tIntroduce el día: ");
        int dia = sc.nextInt();
        sc.nextLine();
        System.out.printf("\tIntroduce el mes: ");
        int mes = sc.nextInt();
        sc.nextLine();
        System.out.printf("\tIntroduce el año: ");
        int anio = sc.nextInt();
        sc.nextLine();
        Fecha fec = new Fecha(dia, mes, anio);
        Trabajador t;

        if (CategoriaEnum.CATEGORIA_EMPLEADO.getNumero() == categoria) {
            t = new Empleado(nombre, edad, antiEnum, fec);
        } else if (CategoriaEnum.CATEGORIA_DIRECTIVO.getNumero() == categoria) {
            t = new Directivo(nombre, edad, antiEnum, fec);
        } else if (CategoriaEnum.CATEGORIA_ENCARGADO.getNumero() == categoria) {
            t = new Encargado(nombre, edad, antiEnum, fec);
        } else if (CategoriaEnum.CATEGORIA_TECNICO.getNumero() == categoria) {
            t = new Tecnico(nombre, edad, antiEnum, fec);
        } else if (CategoriaEnum.CATEGORIA_FREE_LANCE.getNumero() == categoria) {
            //Inicializamos numHoras y sueldoHoras
            double numHoras = 0;
            double sueldoHoras = 0;

            t = new FreeLance(nombre, edad, antiEnum, fec, numHoras, sueldoHoras);

        } else if (CategoriaEnum.CATEGORIA_ANONIMO.getNumero() == categoria) {
            //Implementamos la categoría ANONIMO con una clase anonima
            System.out.println("Introduce el sueldo neto: ");
            double sueldoNeto = sc.nextDouble();
            //Almacenamos categoría para poder devolverla con nombreCategoria
            final CategoriaEnum categoriaFinal = CategoriaEnum.getCategoria(categoria);
            t = new Trabajador(nombre, edad, antiEnum, fec) {

                //Implementamos los métodos que necesitamos                         
                @Override
                public double sueldoTrabajador() {
                    return sueldoNeto;
                }

                @Override
                public String nombreCategoria() {
                    return categoriaFinal.getNombre();
                }

            };

        } else {
            t = new Empleado(nombre, edad, antiEnum, fec);
        }

        System.out.println("==================================================");
        System.out.println("CONTROL DE DATOS DE ENTRADA: ");
        System.out.println("\t¿Es correcto el mes:? " + fec.mesCorrecto());
        System.out.println("\tEl nombre del mes es: " + fec.nombreMes());

        System.out.println("\tNombre de la categoría: " + t.nombreCategoria());

        System.out.println("\t¿Es correcta la antiguedad:? " + t.antiguedadCorrecta());
        System.out.println("\tNombre de la antiguedad: " + t.nombreAntiguedad());

        System.out.println("DATOS DEL TRABAJADOR: " + t.toString());
        System.out.println("==================================================");
    }//main
}//FIN

