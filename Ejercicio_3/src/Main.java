// Ejercicio 3: Tienda de Productos con Inventario
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        Inventario inventario = new Inventario("Tienda_POO");
        System.out.println("Probar crear producto con precio negativo (PrecioInvalidoException)");
        try {
            ProductoElectronico productoElectronico = new ProductoElectronico("ELEC-1001",
                    "Laptop", -500, 10, "Dell", 12);
            System.out.println("Producto creado correctamente");
        }catch (PrecioInvalidoException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nProbar crear producto con código vacío (IllegalArgumentException)");
        try {
            ProductoAlimenticio productoInvalido2 = new ProductoAlimenticio("", "Leche",
                    2.50, 50, "2024-12-31", false);
            System.out.println("Producto creado correctamente");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAgregar 10 productos válidos (mix de tipos)");
        ProductoElectronico elec1 = new ProductoElectronico("ELEC-1001", "Smartphone", 300, 15, "Samsung", 12);
        ProductoElectronico elec2 = new ProductoElectronico("ELEC-1002", "Tablet", 200, 8, "Apple", 24);
        ProductoElectronico elec3 = new ProductoElectronico("ELEC-1003", "Auriculares", 50, 25, "Sony", 6);

        inventario.agregarProducto(elec1);
        inventario.agregarProducto(elec2);
        inventario.agregarProducto(elec3);

        ProductoAlimenticio ali1 = new ProductoAlimenticio("ALIM-2001", "Leche", 1.50, 30, "2024-12-31", true);
        ProductoAlimenticio ali2 = new ProductoAlimenticio("ALIM-2002", "Pan", 0.80, 20, "2024-10-15", false);
        ProductoAlimenticio ali3 = new ProductoAlimenticio("ALIM-2003", "Queso", 3.20, 10, "2024-11-20", true);

        inventario.agregarProducto(ali1);
        inventario.agregarProducto(ali2);
        inventario.agregarProducto(ali3);

        ProductoRopa ropa1 = new ProductoRopa("ROPA-3001", "Camiseta", 15, 40, "M", "Algodón");
        ProductoRopa ropa2 = new ProductoRopa("ROPA-3002", "Jeans", 35, 15, "32", "Denim");
        ProductoRopa ropa3 = new ProductoRopa("ROPA-3003", "Chaqueta", 60, 5, "L", "Poliéster");
        ProductoRopa ropa4 = new ProductoRopa("ROPA-3004", "Zapatos", 45, 3, "42", "Cuero");

        inventario.agregarProducto(ropa1);
        inventario.agregarProducto(ropa2);
        inventario.agregarProducto(ropa3);
        inventario.agregarProducto(ropa4);

        System.out.println("Productos agregados exitosamente al inventario");
        System.out.println(inventario.toString());

        System.out.println("\nRealizar ventas exitosas");
        try {
            double total1 = inventario.venderProducto("ELEC-1001", 2);
            double total2 = inventario.venderProducto("ALIM-2001", 5);
            double total3 = inventario.venderProducto("ROPA-3001", 3);
            System.out.println("Ventas Exitosas");
        } catch (StockInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nProbar venta con cantidad negativa (IllegalArgumentException)");
        try {
            inventario.venderProducto("ELEC-1001", -2);
        } catch (IllegalArgumentException | StockInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nProbar venta con stock insuficiente (StockInsuficienteException)");
        try {
            inventario.venderProducto("ROPA-3004", 10);
            System.out.println("Venta con Stock exitosa");
        } catch (StockInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nProbar búsqueda de producto inexistente (ProductoNoEncontradoException)");
        try {
            Producto producto = inventario.buscarPorCodigo("INEX-9999");
        } catch (ProductoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nCalcular valor total del inventario");
        double valorTotal = inventario.calcularValorInventario();
        System.out.println("Valor total del inventario: $" + valorTotal);

        System.out.println("Listar productos con stock < 5");
        ArrayList<Producto> productosBajoStock = inventario.listarProductosBajoStock(5);
        if (productosBajoStock.isEmpty()) {
            System.out.println("No hay productos con stock bajo");
        } else {
            for (Producto producto : productosBajoStock) {
                System.out.println("  - " + producto.getNombre() + " (Stock: " + producto.getStock() + ")");
            }
        }

        System.out.println("\nOrdenar por precio");
        inventario.ordenarPorPrecio();
        for (Producto producto : inventario.getProductos()) {
            System.out.println("  - " + producto.getNombre() + ": $" + producto.calcularPrecioFinal());
        }
    }
}