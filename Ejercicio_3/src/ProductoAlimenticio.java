public class ProductoAlimenticio extends Producto{
    // Atributos
    private String fechaVencimiento;
    private boolean requiereRefrigeracion;

    // Constructor
    public ProductoAlimenticio(String codigo, String nombre, double precioBase, int stock, String fechaVencimiento, boolean requiereRefrigeracion) {
        super(codigo, nombre, precioBase, stock);
        if(fechaVencimiento == null || fechaVencimiento.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: La fecha no puede estar vacia");
        }
        this.fechaVencimiento = fechaVencimiento;
        this.requiereRefrigeracion = requiereRefrigeracion;
    }

    // Getters
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public boolean isRequiereRefrigeracion() {
        return requiereRefrigeracion;
    }


    // Sobreescritura
    @Override
    public double calcularPrecioFinal(){
        return getPrecioBase();
    };

    // Metodo toString
    @Override
    public String toString() {
        return "ProductoAlimenticio{" +
                "codigo='" + getCodigo() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", precioBase=" + getPrecioBase() +
                ", stock=" + getStock() +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", requiereRefrigeracion=" + requiereRefrigeracion +
                ", precioFinal=" + calcularPrecioFinal() +
                '}';
    }
}

