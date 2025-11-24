import java.util.ArrayList;
public class Inventario {
    // Atributos
    private ArrayList<Producto> productos;
    private String nombreTienda;

    // Constructor
    public Inventario(String nombreTienda) {
        this.productos = new ArrayList<>();
        if(nombreTienda == null || nombreTienda.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: El nombre de la tienda no puede estar vacia");
        }
        this.nombreTienda = nombreTienda;
    }

    // Getters
    public ArrayList<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    // Metodo Estático
    public String generarCodigo(String categoria){
        if(categoria == null || categoria.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: La categoria no puede estar vacia");
        }
        StringBuilder codigo = new StringBuilder();
        codigo.append("Producto-");
        for (int i=0; i < 4; i++){
            int numero = (int) (Math.random()*10);
            codigo.append(numero);
        }
        return codigo.toString();
    }

    // Metodos
    public void agregarProducto(Producto p){
        if(p == null){
            throw new NullPointerException("✗ Error capturado: El producto no puede ser nulo");
        }
        productos.add(p);
    }

    public Producto buscarPorCodigo(String codigo) throws ProductoNoEncontradoException{
        if(codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: El código no puede estra vacio");
        }

        for (Producto producto: productos){
            if(producto.getCodigo().equals(codigo)){
                return producto;
            }
        }
        throw new ProductoNoEncontradoException("✗ Error capturado: Producto no encontrado");
    }

    public double venderProducto(String codigo, int cantidad) throws StockInsuficienteException{
        if(cantidad <= 0){
            throw new IllegalArgumentException("✗ Error capturado: El cantidad debe de ser mayor a 0");
        }

        Producto producto = buscarPorCodigo(codigo);
        if(cantidad > producto.getStock()){
            throw new StockInsuficienteException("✗ Error capturado: El stock no puede ser menor a la cantidad");
        }
        producto.vender(cantidad);
        return producto.calcularPrecioFinal() * cantidad;

    }

    public double calcularValorInventario(){
        if(productos.isEmpty()){
            throw new IllegalStateException("✗ Error capturado: El inventario esta vacio");
        }
        double valorTotal = 0;
        for (Producto producto: productos){
            valorTotal += producto.calcularPrecioFinal() * producto.getStock();
        }
        return valorTotal;
    }

    public ArrayList<Producto> listarProductosBajoStock(int minimo){
        ArrayList<Producto> productosBajoStock  = new ArrayList<>();
        for (Producto producto:productos) {
            if (producto.getStock() < minimo) {
                productosBajoStock.add(producto);
            }
        }
        return productosBajoStock;
    }

    public void ordenarPorPrecio() {
        int n = productos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (productos.get(j).calcularPrecioFinal() > productos.get(j + 1).calcularPrecioFinal()) {
                    // Intercambiar productos
                    Producto temp = productos.get(j);
                    productos.set(j, productos.get(j + 1));
                    productos.set(j + 1, temp);
                }
            }
        }
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Inventario{" +
                "nombreTienda='" + nombreTienda + '\'' +
                ", totalProductos=" + productos.size() +
                ", valorInventario=" + (productos.isEmpty() ? 0 : calcularValorInventario()) +
                '}';
    }
}