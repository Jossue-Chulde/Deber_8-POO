public abstract class Vehiculo {
    // Atributos
    private String marca;
    private String modelo;
    private int año;
    private double precio;

    // Constructor
    public Vehiculo(String marca, String modelo, int año, double precio) {
        // Validar marca
        if(marca == null || marca.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: La marca no puede ser nulo");
        }
        this.marca = marca;

        // Validar marca
        if(modelo == null || modelo.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: El modelo no puede ser nulo");
        }
        this.modelo = modelo;

        // Validar año
        if(año < 1900 || año > 2025){
            throw new IllegalArgumentException("✗ Error capturado: El año debe estar entre 1900 y 2025");
        }
        this.año = año;

        // Validar Precio
        if(precio < 0){
            throw new IllegalArgumentException("✗ Error capturado: El precio no puede ser menor a 0");
        }
        this.precio = precio;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public double getPrecio() {
        return precio;
    }

    // Implementamos Metodos abstractos
    public abstract double calcularImpuestoCirculacion();

    // Metodo toString()
    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", precio=" + precio +
                '}';
    }
}
