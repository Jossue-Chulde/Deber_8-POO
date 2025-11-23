public class Auto extends Vehiculo{
    // Atributos
    private int numeroPuertas;

    // Constructor
    public Auto(String marca, String modelo, int año, double precio) {
        super(marca, modelo, año, precio);
        this.numeroPuertas = 4;
    }

    public Auto(String marca, String modelo, int año, double precio, int numeroPuertas) {
        super(marca, modelo, año, precio);
        if (numeroPuertas <= 0) {
            throw new IllegalArgumentException("✗ Error capturado: El numero de puertas no puede ser menor a 0");
        }
        this.numeroPuertas = numeroPuertas;
    }

    // Getters
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    // Sobreescritura
    @Override
    public double calcularImpuestoCirculacion() {
        return getPrecio() * 0.05;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", año=" + getAño() +
                ", precio=" + getPrecio() +
                ", numeroPuertas=" + numeroPuertas +
                '}';
    }
}
