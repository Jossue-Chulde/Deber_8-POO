public class Moto extends Vehiculo{
    // Atributos
    private int cilindrada;

    // Constructor
    public Moto(String marca, String modelo, int año, double precio, int cilindrada) {
        super(marca, modelo, año, precio);
        if(cilindrada <= 0){
            throw new IllegalArgumentException("✗ Error capturado: La cantida de cilindrada debe de ser mayor a 0");
        }
        this.cilindrada = cilindrada;
    }

    // Getters
    public int getCilindrada() {
        return cilindrada;
    }

    // Sobreescritura
    @Override
    public double calcularImpuestoCirculacion() {
        if (cilindrada <= 250) {
            return getPrecio() * 0.02;
        }else {
            return getPrecio() * 0.04;
        }
    }

    @Override
    public String toString() {
        return "Moto{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", año=" + getAño() +
                ", precio=" + getPrecio() +
                ", cilindrada=" + cilindrada +
                '}';
    }
}
