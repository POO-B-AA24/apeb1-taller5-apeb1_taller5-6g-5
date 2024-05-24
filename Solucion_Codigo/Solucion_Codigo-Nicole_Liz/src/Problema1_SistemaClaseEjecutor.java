import java.util.Scanner;
public class Problema1_SistemaClaseEjecutor {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Problema1_SistemaClaseBase.Tienda tienda = new Problema1_SistemaClaseBase.Tienda();
        Problema1_SistemaClaseBase.CarritoDeCompras carrito = new Problema1_SistemaClaseBase.CarritoDeCompras(tienda);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSistema de Ventas");
            System.out.println("1. Agregar Producto al Carrito");
            System.out.println("2. Mostrar Detalle de Compra");
            System.out.println("3. Calcular Total");
            System.out.println("4. Realizar Pago");
            System.out.println("5. Mostrar Inventario de la Tienda");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            String opcion = teclado.next();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre del producto: ");
                    String nombre = teclado.next();
                    System.out.print("Cantidad: ");
                    int cantidad = teclado.nextInt();
                    carrito.agregarProducto(nombre, cantidad);
                    break;
                case "2":
                    System.out.println(carrito.mostrarDetalleCompra());
                    break;
                case "3":
                    double total = carrito.calcularTotal();
                    System.out.println("El total de la compra es: $" + total);
                    break;
                case "4":
                    System.out.print("Monto pagado: ");
                    double montoPagado = teclado.nextDouble();
                    System.out.print("Descuento a aplicar (si aplica): ");
                    double descuento = teclado.nextDouble();
                    String resultadoPago = carrito.realizarPago(montoPagado, descuento);
                    System.out.println(resultadoPago);
                    break;
                case "5":
                    System.out.println(tienda.mostrarInventario());
                    break;
                case "6":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        teclado.close();
    }
}