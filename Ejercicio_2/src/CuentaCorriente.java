public class CuentaCorriente extends CuentaBancaria{
    // Atributos
    private double limiteCredito;

    // Constructor
    public CuentaCorriente(String numeroCuenta, String titular, double saldo, double limiteCredito) {
        super(numeroCuenta, titular, saldo);
        if(limiteCredito < 0){
            throw new IllegalArgumentException("✗ Error capturado: El limite de credito no puede ser negativo");
        }
        this.limiteCredito = limiteCredito;
    }

    // Getters
    public double getLimiteCredito() {
        return limiteCredito;
    }

    // Sobreescritura
    @Override
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto no puede ser negativo");
        }

        if (monto > (getSaldo() + limiteCredito)) {
            throw new SaldoInsuficienteException("✗ Error capturado: Saldo Insuficiente");
        }
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "numeroCuenta='" + getNumeroCuenta() + '\'' +
                ", titular='" + getTitular() + '\'' +
                ", saldo=" + getSaldo() +
                ", limiteCredito=" + limiteCredito +
                ", disponible=" + (getSaldo() + limiteCredito) +
                '}';
    }
}
