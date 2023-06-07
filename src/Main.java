import java.util.*;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        /**
         * lista de productos en stock, cambio de array list a collections para evitar usar tantos add,
         * Lanmda no me funciono
         */
        List<ProductoElectronico> productos = new ArrayList<>();
        Collections.addAll(productos,
                new Telefono("Motorola g90", 70000.0, "Motorola", 128),
                new Telefono("LG flex", 80000.0, "LG", 64),
                new Notebook("Elitebook HP", 250000.0, "HP", "Intel i7", 16),
                new Television("Samsung Smart", 350000.0, "Samsung", 55),
                new Television("Noblex Android", 150000.0, "Noblex", 55)
        );

        /**
         * intento de crear el carrito de compras
         */
        List<ProductoElectronico> carrito = new ArrayList<>();

        boolean continuarComprando = true;

        System.out.println("\n** Bienvenido a TechLnd!!*11*\n");

        while (continuarComprando) {
            String menu =
                    "\n ¿Qué se le ofrece?\n"
                    + "1. Ver productos disponibles\n"
                    + "2. Agregar producto al carrito\n"
                    + "3. Ver carrito de compras\n"
                    + "4. Realizar compra\n"
                    + "5. Salir";

            System.out.println(menu);

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> mostrarProductos(productos);
                case 2 -> buscarProducto(productos, carrito, scanner);
                case 3 -> mostrarCarrito(carrito);
                case 4 -> realizarCompra(carrito, scanner);
                case 5 -> {
                    continuarComprando = false;
                    System.out.println("¡Gracias por visitar nuestra tienda!");
                }
                default -> System.out.println("Opción inválida. Por favor, seleccione otra opcion.");
            }
        }
    }

    private static void mostrarProductos(List<ProductoElectronico> productos) {
        System.out.println("*** Lista de productos  ***");
        for (int i = 0; i < productos.size(); i++) {
            ProductoElectronico producto = productos.get(i);
            System.out.println((i + 1) + ". " + producto.mostrarInformacion());
        }
    }

    private static void buscarProducto(List<ProductoElectronico> productos, List<ProductoElectronico> carrito, Scanner scanner) {
        System.out.println("Ingrese el número del producto que desea agregar al carrito:");
        int numeroProducto = scanner.nextInt();

        if (numeroProducto >= 1 && numeroProducto <= productos.size()) {
            ProductoElectronico productoSeleccionado = productos.get(numeroProducto - 1);
            System.out.println("Producto seleccionado: ");
            System.out.println(productoSeleccionado.mostrarInformacion());

            System.out.println("¿Desea agregar este producto al carrito? (S/N)");
            String respuesta = scanner.next();

            if (respuesta.equalsIgnoreCase("S")) {
                carrito.add(productoSeleccionado);
                System.out.println("El producto ha sido agregado al carrito de compras.");
            }
        } else {
            System.out.println("Número de producto inválido.");
        }
    }

    private static void mostrarCarrito(List<ProductoElectronico> carrito) {
        System.out.println("Carrito de compras: ");
        if (carrito.isEmpty()) {
            System.out.println("El carrito de compras está vacío.");
        } else {
            for (ProductoElectronico producto : carrito) {
                System.out.println(producto.mostrarInformacion());
            }
        }
    }

    private static void realizarCompra(List<ProductoElectronico> carrito, Scanner scanner) {
        System.out.println("*** Realizar compra ***");
        if (carrito.isEmpty()) {
            System.out.println("El carrito de compras está vacío. No se puede realizar la compra.");
        } else {
            double totalCompra = 0.0;
            for (ProductoElectronico producto : carrito) {
                totalCompra += producto.calcularPrecioFinal();
            }
            System.out.println("El total de la compra es: $" + totalCompra);
            System.out.println("¿Desea confirmar la compra? (S/N)");
            String confirmacion = scanner.next();

            if (confirmacion.equalsIgnoreCase("S")) {
                System.out.println("¡Compra realizada exitosamente!");
                carrito.clear(); // Vaciar el carrito después de la compra
            } else {
                System.out.println("La compra ha sido cancelada.");
            }
        }
    }
}




