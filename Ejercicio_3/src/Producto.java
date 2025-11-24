public abstract class Producto {
    // Atributos
    private String codigo;
    private String nombre;
    private double precioBase;
    private int stock;

    // Constructor
    public Producto(String codigo, String nombre, double precioBase, int stock) {
        if(codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: El código no puede estar vacio");
        }
        this.codigo = codigo;
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: El nombre no puede estar vacio");
        }
        this.nombre = nombre;
        if(precioBase <= 0){
            throw new PrecioInvalidoException("✗ Error capturado: El precio base no puede ser menor a 0");
        }
        this.precioBase = precioBase;
        if(stock < 0){
            throw new IllegalArgumentException("✗ Error capturado: El stock no puede ser negativo");
        }
        this.stock = stock;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public int getStock() {
        return stock;
    }

    // Metodo abstracto
    public abstract double calcularPrecioFinal();

    // Metodos
    public void vender(int cantidad) throws StockInsuficienteException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("✗ Error capturado: La cantidad a vender debe ser mayor a cero");
        }
        if (cantidad > stock) {
            throw new StockInsuficienteException(
                    "✗ Error capturado: Stock insuficiente. Stock actual: " + stock + ", Solicitado: " + cantidad
            );
        }
        this.stock -= cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precioBase=" + precioBase +
                ", stock=" + stock +
                '}';
    }
}
