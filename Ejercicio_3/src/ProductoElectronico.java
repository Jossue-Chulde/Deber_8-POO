public class ProductoElectronico extends Producto{
    // Atributos
    private String marca;
    private int garantiaMeses;

    // Constructor
    public ProductoElectronico(String codigo, String nombre, double precioBase, int stock, String marca, int garantiaMeses) {
        super(codigo, nombre, precioBase, stock);
        if(marca == null || marca.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: La marca no puede quedar vacia");
        }
        this.marca = marca;
        if(garantiaMeses <= 0){
            throw new IllegalArgumentException("✗ Error capturado: La garantia no puede ser negativa");
        }
        this.garantiaMeses = garantiaMeses;
    }


    // Getters and Setters
    public String getMarca() {
        return marca;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    // Sobreescritura
    @Override
    public double calcularPrecioFinal(){
        return getPrecioBase() * 1.12;
    };

    // Sobrecarga
    public boolean aplicarGarantia(){
        return garantiaMeses == 12;
    }

    public double aplicarGarantia(int mesesExtras){
        if(mesesExtras <= 0){
            throw new IllegalArgumentException("✗ Error capturado: Los meses en aplicar la garantia deben de ser mayores a 0");
        }
        double costoAdicional = getPrecioBase() * 0.2 * mesesExtras;
        return costoAdicional;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "ProductoElectronico{" +
                "codigo='" + getCodigo() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", precioBase=" + getPrecioBase() +
                ", stock=" + getStock() +
                ", marca='" + marca + '\'' +
                ", garantiaMeses=" + garantiaMeses +
                ", precioFinal=" + calcularPrecioFinal() +
                '}';
    }
}
