public class Camion extends Vehiculo{
    // Atributos
    private double capacidadCarga;

    // Constructor
    public Camion(String marca, String modelo, int año, double precio, double capacidadCarga) {
        super(marca, modelo, año, precio);
        if(capacidadCarga <= 0){
            throw new IllegalArgumentException("✗ Error capturado: La capacidad de carga no debe de ser menor a 0");
        }
        this.capacidadCarga = capacidadCarga;
    }

    // Getters
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    // Sobreescritura
    @Override
    public double calcularImpuestoCirculacion(){
        return (getPrecio() * 0.08) + (capacidadCarga * 50);
    };

    @Override
    public String toString() {
        return "Camion{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", año=" + getAño() +
                ", precio=" + getPrecio() +
                ", capacidadCarga=" + capacidadCarga +
                '}';
    }
}
