import java.util.ArrayList;
import java.util.Scanner;
class Problema1_SistemaClaseBase {

    static class Producto {
        private String nombre;
        private double precio;
        private int cantidad;

        public Producto(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        @Override
        public String toString() {
            return nombre + " - Cantidad: " + cantidad + " - Precio: $" + precio;
        }
    }

    static class CarritoDeCompras {
        private ArrayList<Producto> productos;
        private Tienda tienda;

        public CarritoDeCompras(Tienda tienda) {
            this.productos = new ArrayList<>();
            this.tienda = tienda;
        }

        public void agregarProducto(String nombre, int cantidad) {
            Producto producto = tienda.buscarProducto(nombre);
            if (producto != null && producto.getCantidad() >= cantidad) {
                productos.add(new Producto(producto.getNombre(), producto.getPrecio(), cantidad));
                System.out.println("Producto agregado al carrito: " + nombre + " - Cantidad: " + cantidad);
            } else {
                System.out.println("Cantidad no disponible o producto no encontrado: " + nombre);
            }
        }

        public double calcularTotal() {
            double total = 0.0;
            for (Producto producto : productos) {
                total += producto.getPrecio() * producto.getCantidad();
            }
            return total;
        }

        public String realizarPago(double montoPagado, double descuento) {
            double total = calcularTotal();
            if (total > 1000) {
                total -= descuento;
            }
            if (montoPagado >= total) {
                actualizarInventario();
                return "Pago realizado con éxito. Gracias por su compra!";
            } else {
                return "Monto insuficiente. Faltan $" + (total - montoPagado);
            }
        }

        private void actualizarInventario() {
            for (Producto productoEnCarrito : productos) {
                Producto productoEnTienda = tienda.buscarProducto(productoEnCarrito.getNombre());
                if (productoEnTienda != null) {
                    productoEnTienda.setCantidad(productoEnTienda.getCantidad() - productoEnCarrito.getCantidad());
                }
            }
            productos.clear();  // Limpiar el carrito después de la compra
        }

        public String mostrarDetalleCompra() {
            StringBuilder detalles = new StringBuilder("Detalle de la compra:\n");
            for (Producto producto : productos) {
                detalles.append(producto).append("\n");
            }
            detalles.append("Total a pagar: $").append(calcularTotal()).append("\n");
            return detalles.toString();
        }
    }

    static class Tienda {
        private ArrayList<Producto> productos;

        public Tienda() {
            productos = new ArrayList<>();
            productos.add(new Producto("Arroz", 0.25, 5));
            productos.add(new Producto("Pan", 0.10, 10));
            productos.add(new Producto("Huevos", 0.35, 20));
        }

        public Producto buscarProducto(String nombre) {
            for (Producto producto : productos) {
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    return producto;
                }
            }
            return null;
        }

        public String mostrarInventario() {
            StringBuilder detalles = new StringBuilder("Inventario de la tienda:\n");
            for (Producto producto : productos) {
                detalles.append(producto).append("\n");
            }
            return detalles.toString();
        }
    }
}
