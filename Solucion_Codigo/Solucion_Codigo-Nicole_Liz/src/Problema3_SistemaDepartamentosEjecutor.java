import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problema3Sistema_Claseejecutor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ingresar datos de la empresa
        System.out.print("Ingrese el nombre de la empresa: ");
        String nombreEmpresa = scanner.nextLine();
        System.out.print("Ingrese el RUC de la empresa: ");
        String rucEmpresa = scanner.nextLine();
        System.out.print("Ingrese la dirección de la empresa: ");
        String direccionEmpresa = scanner.nextLine();

        Empresa empresa = new Empresa(nombreEmpresa, rucEmpresa, direccionEmpresa);

        // Ingresar departamentos
        boolean opc = true;

        while (opc) {
            System.out.print("Ingrese el nombre del departamento: ");
            String nombreDepartamento = scanner.nextLine();
            System.out.print("Ingrese el número de empleados del departamento: ");
            int numeroEmpleados = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese la producción anual del departamento: ");
            double produccionAnual = Double.parseDouble(scanner.nextLine());

            Departamento departamento = new Departamento(nombreDepartamento, numeroEmpleados, produccionAnual);
            empresa.agregarDepartamento(departamento);

            System.out.print("¿Desea agregar otro departamento? (S/N): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("N")) {
                break;
            }
        }
        // Mostrar departamentos
        System.out.println("\nDepartamentos de la empresa:");
        for (Departamento departamento : empresa.getDepartamentos()) {
            System.out.println(departamento.toString());
        }
    }
}
