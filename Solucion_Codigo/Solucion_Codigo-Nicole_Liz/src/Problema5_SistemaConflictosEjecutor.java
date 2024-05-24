import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Problema5Conflictos_ClaseEjecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Conflicto conflicto = crearConflicto(scanner);

        mostrarDetallesConflicto(conflicto);

        scanner.close();
    }

    private static Conflicto crearConflicto(Scanner scanner) {
        System.out.println("Ingrese el nombre del conflicto:");
        String nombreConflicto = scanner.nextLine();

        System.out.println("Ingrese la fecha de inicio del conflicto en días desde un punto de referencia:");
        int fechaInicio = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese los detalles adicionales del conflicto:");
        String detallesAdicionales = scanner.nextLine();

        List<String> paisesInvolucrados = new ArrayList<>();
        agregarPaisesInvolucrados(scanner, paisesInvolucrados);

        return new Conflicto(nombreConflicto, fechaInicio, detallesAdicionales, paisesInvolucrados);
    }

    private static void agregarPaisesInvolucrados(Scanner scanner, List<String> paisesInvolucrados) {
        boolean agregarMasPaises = true;

        while (agregarMasPaises) {
            System.out.println("Ingrese el nombre de un país involucrado:");
            String pais = scanner.nextLine();
            paisesInvolucrados.add(pais);

            System.out.println("¿Desea agregar otro país involucrado? (S/N):");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    private static void mostrarDetallesConflicto(Conflicto conflicto) {
        System.out.println("\nDetalles del conflicto:");
        System.out.println(conflicto);
    }
}
