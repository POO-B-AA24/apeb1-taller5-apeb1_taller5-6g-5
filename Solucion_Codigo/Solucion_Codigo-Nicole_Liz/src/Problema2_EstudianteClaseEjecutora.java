import java.util.Scanner;

    public class Problema2_EstudianteClaseEjecutora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingresar datos del estudiante
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombreEstudiante = scanner.next();
        System.out.print("Ingrese la edad del estudiante: ");
        int edadEstudiante = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Estudiante estudiante = new Estudiante(nombreEstudiante, edadEstudiante);

        // Ingresar datos de la materia
        System.out.print("Ingrese el nombre de la materia: ");
        String nombreMateria = scanner.next();
        System.out.print("Ingrese la calificación ACD (3.5/10): ");
        double acd = scanner.nextDouble();
        System.out.print("Ingrese la calificación APE (3.5/10): ");
        double ape = scanner.nextDouble();
        System.out.print("Ingrese la calificación AA (3/10): ");
        double aa = scanner.nextDouble();

        Materia materia = new Materia(nombreMateria, acd, ape, aa);

        // Vincular materia al estudiante
        estudiante.setMateria(materia);

        // Verificar si el estudiante ha aprobado la materia
        boolean aprobado = estudiante.verificarAprobacion();

        if (!aprobado) {
            // Ingresar nota del examen de recuperación
            System.out.print("Ingrese la nota del examen de recuperación (3.5/10): ");
            double notaRecuperacion = scanner.nextDouble();
            estudiante.rendirExamenRecuperacion(notaRecuperacion);
        }

        scanner.close();
    }
}