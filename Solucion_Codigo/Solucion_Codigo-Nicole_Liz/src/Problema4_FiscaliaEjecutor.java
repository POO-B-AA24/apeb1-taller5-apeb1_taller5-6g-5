import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problema4Fiscali_ClaseEjecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del caso de corrupción: ");
        String nombreCaso = scanner.nextLine();
        System.out.print("Ingrese la fecha de inicio del caso en días desde un punto de referencia (por ejemplo, 738120): ");
        int fechaInicio = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese los detalles adicionales del caso: ");
        String detallesAdicionales = scanner.nextLine();
        CasoCorrupcion caso = new CasoCorrupcion(nombreCaso, fechaInicio, detallesAdicionales);
        boolean agregarMasPersonas = true;
        while (agregarMasPersonas) {
            System.out.print("Ingrese el nombre de la persona: ");
            String nombrePersona = scanner.nextLine();
            System.out.print("Ingrese la edad de la persona: ");
            int edadPersona = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            System.out.print("Ingrese la ocupación de la persona: ");
            String ocupacionPersona = scanner.nextLine();
            System.out.print("Ingrese el nivel de implicación (acusado, testigo, víctima, etc.): ");
            String nivelImplicacion = scanner.nextLine();

            Persona persona = new Persona(nombrePersona, edadPersona, ocupacionPersona, nivelImplicacion);
            caso.agregarPersonaImplicada(persona);

            System.out.print("¿Desea agregar otra persona implicada? (S/N): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("N")) {
                break;
            }
        }
        System.out.print("Ingrese el día actual en días desde el mismo punto de referencia: ");
        int diaActual = scanner.nextInt();
        caso.actualizarEstado(diaActual);
        System.out.println("\nDetalles del caso:");
        System.out.println(caso);
        for (Persona persona : caso.getPersonasImplicadas()) {
            if ("acusado".equals(persona.getNivelImplicacion())) {
                System.out.print("\n¿La persona " + persona.getNombre() + " ha decidido colaborar? (S/N): ");
                String respuestaColaboracion = scanner.nextLine();
                if (respuestaColaboracion.equalsIgnoreCase("S")) {
                    persona.setColaboracion(true);
                }

                System.out.print("Ingrese la sentencia en años para " + persona.getNombre() + ": ");
                double sentenciaEnAnios = scanner.nextDouble();
                System.out.print("Ingrese el daño económico causado al estado por " + persona.getNombre() + ": ");
                double danioEconomico = scanner.nextDouble();
                scanner.nextLine(); // Consumir la nueva línea

                String mensajeReduccionPena = persona.verificarReduccionPena(sentenciaEnAnios, danioEconomico);
                System.out.println(mensajeReduccionPena);
            }
        }
    }
}
