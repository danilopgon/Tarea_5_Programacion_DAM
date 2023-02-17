package operaciones;

import almacenes.AntiguedadEnum;
import almacenes.CategoriaEnum;
import almacenes.ConstantesTrabajador;

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
        CategoriaEnum catEnum = CategoriaEnum.getCategoria(categoria);

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

        TrabajadorBuilder tBuilder = new TrabajadorBuilder();

        tBuilder.nombre(nombre)
                .edad(edad)
                .categoria(catEnum)
                .antiguedad(antiEnum)
                .fec(fec);

        Trabajador t;

        if (CategoriaEnum.CATEGORIA_FREE_LANCE.getNumero() == categoria) {
            /*RECOGER LOS DATOS NECESARIOS PARA FREELANCE Y CREARLO CON EL OBJETO BUILDER*/
            System.out.println("Introduce la cantidad de horas trabajadas: ");
            double numHoras = sc.nextDouble();
            System.out.println("Introduce el sueldo por hora: ");
            double sueldoHoras = sc.nextDouble();

            t = new Trabajador(tBuilder) {

                @Override
                public double sueldoTrabajador() {
                    return sueldoHoras * numHoras;
                }
            };

        } else if (CategoriaEnum.CATEGORIA_ANONIMO.getNumero() == categoria) {

            /*RECOGER LOS DATOS NECESARIOS PARA ANONIMO Y CREARLO CON EL OBJETO BUILDER*/
            System.out.println("Introduce el sueldo base: ");
            double sueldoBase = sc.nextDouble();

            t = new Trabajador(tBuilder) {

                @Override
                public double sueldoTrabajador() {
                    return sueldoBase;
                }

            };

        } else {

            /*RECOGER LOS DATOS NECESARIOS PARA EL RESTO DE CATEGORIAS Y CREARLO CON EL OBJETO BUILDER*/
            t = new Trabajador(tBuilder) {

                @Override
                public double sueldoTrabajador() {

                    double porcentajeCategoriaPersonal;
                    double plusAntiguedadPersonal;

                    porcentajeCategoriaPersonal = switch (catEnum.getNumero()) {
                        case 0 ->
                            ConstantesTrabajador.IMPCAT_EMPLEADO;
                        case 1 ->
                            ConstantesTrabajador.IMPCAT_ENCARGADO;
                        case 2 ->
                            ConstantesTrabajador.IMPCAT_DIRECTIVO;
                        case 3 ->
                            ConstantesTrabajador.IMPCAT_TECNICO;
                        default ->
                            0;
                    };

                    /*utilizamos switch para asignar los valores*/
                    plusAntiguedadPersonal = switch (getAntiguedad()) {
                        case ANTIGUEDAD_NOVATO ->
                            ConstantesTrabajador.SUELDO_PLUS_NOVATO;
                        case ANTIGUEDAD_MADURO ->
                            ConstantesTrabajador.SUELDO_PLUS_MADURO;
                        case ANTIGUEDAD_EXPERTO ->
                            ConstantesTrabajador.SUELDO_PLUS_EXPERTO;
                        default ->
                            0;
                    };

                    return ConstantesTrabajador.SUELDO_BASE + (ConstantesTrabajador.SUELDO_BASE * porcentajeCategoriaPersonal) + plusAntiguedadPersonal;

                }
            };

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

