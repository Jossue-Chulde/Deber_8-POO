public class ProductoRopa extends Producto{
    // Atributos
    private String talla;
    private String material;

    // Constructor
    public ProductoRopa(String codigo, String nombre, double precioBase, int stock, String talla, String material) {
        super(codigo, nombre, precioBase, stock);
        if(talla == null || talla.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: La talla no debe de esta vacia");
        }
        this.talla = talla;

        if(material == null || material.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: El material no debe de estar vacio");
        }
        this.material = material;
    }

    // Getters
    public String getTalla() {
        return talla;
    }

    public String getMaterial() {
        return material;
    }

    // Metodos


    // Implementamos Metodos abstractos


    // Sobreescritura
    @Override
    public double calcularPrecioFinal(){
        return getPrecioBase() * 1.12;
    };

    // Metodo toString


    @Override
    public String toString() {
        return "ProductoRopa{" +
                "codigo='" + getCodigo() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", precioBase=" + getPrecioBase() +
                ", stock=" + getStock() +
                ", talla='" + talla + '\'' +
                ", material='" + material + '\'' +
                ", precioFinal=" + calcularPrecioFinal() +
                '}';
    }
}
