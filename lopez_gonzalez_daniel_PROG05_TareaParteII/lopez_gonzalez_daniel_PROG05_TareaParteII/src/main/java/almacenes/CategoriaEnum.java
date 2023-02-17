package almacenes;

/**
 *
 * @author DaniLopez
 */
//Enum para almacenar las constantes de categoría
public enum CategoriaEnum {

    CATEGORIA_EMPLEADO("EMPLEADO", 0),
    CATEGORIA_ENCARGADO("ENCARGADO", 1),
    CATEGORIA_DIRECTIVO("DIRECTIVO", 2),
    CATEGORIA_TECNICO("TECNICO", 3),
    CATEGORIA_FREE_LANCE("FREELANCE", 4),
    CATEGORIA_ANONIMO("ANONIMO", 5),
    CATEGORIA_ERRONEA("ANTIGUEDAD ERRÓNEA", 6);

    private String nombre;
    private int numero;

    //Constructor de CategoriaEnum
    private CategoriaEnum(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    //Métodos get
    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    //Método para obtener un valor del enum a partir de la categoria
    public static CategoriaEnum getCategoria(int numero) {
        switch (numero) {
            case 0 -> {
                return CategoriaEnum.CATEGORIA_EMPLEADO;
            }
            case 1 -> {
                return CategoriaEnum.CATEGORIA_ENCARGADO;
            }
            case 2 -> {
                return CategoriaEnum.CATEGORIA_DIRECTIVO;
            }
            case 3 -> {
                return CategoriaEnum.CATEGORIA_TECNICO;
            }
            case 4 -> {
                return CategoriaEnum.CATEGORIA_FREE_LANCE;
            }

            case 5 -> {
                return CategoriaEnum.CATEGORIA_ANONIMO;
            }

            default -> {
                return CategoriaEnum.CATEGORIA_ERRONEA;
            }

        }
    }
}
