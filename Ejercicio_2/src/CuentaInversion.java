public class CuentaInversion extends CuentaBancaria{
    // Atributos
    private double montoMinimo;
    private double rendimientoAnual;

    // Constructor
    public CuentaInversion(String numeroCuenta, String titular, double saldo, double montoMinimo, double rendimientoAnual) {
        super(numeroCuenta, titular, saldo);
        if(montoMinimo <= 0){
            throw new IllegalArgumentException("✗ Error capturado: El monto minimo no puede ser negativo");
        }
        this.montoMinimo = montoMinimo;

        if(rendimientoAnual <= 0){
            throw new IllegalArgumentException("✗ Error capturado: El rendimiento anual no puede ser negativo");
        }
        this.rendimientoAnual = rendimientoAnual;
    }

    // Getters
    public double getMontoMinimo() {
        return montoMinimo;
    }

    public double getRendimientoAnual() {
        return rendimientoAnual;
    }

    // Sobreescritura
    @Override
    public void depositar(double monto){
        if (monto <= 0) {
            throw new MontoInvalidoException("✗ Error capturado: El monto a depositar debe ser mayor a cero");
        }

        if(monto < getMontoMinimo()){
            throw new IllegalArgumentException("✗ Error capturado: El monot minimo no puede ser mayor al monto");
        }
        super.depositar(monto);
    }

    // SOBRECARGA:
    public double calcularRendimiento(){
        return getSaldo() * (rendimientoAnual / 12);
    }

    public double calcularRendimiento(int meses){
        if (meses <= 0) {
            throw new MontoInvalidoException("✗ Error capturado: El número de meses debe ser mayor a cero");
        }
        return getSaldo() * (rendimientoAnual / 12) * meses;
    }

    @Override
    public String toString() {
        return "CuentaInversion{" +
                "numeroCuenta='" + getNumeroCuenta() + '\'' +
                ", titular='" + getTitular() + '\'' +
                ", saldo=" + getSaldo() +
                ", montoMinimo=" + montoMinimo +
                ", rendimientoAnual=" + rendimientoAnual +
                '}';
    }
}
