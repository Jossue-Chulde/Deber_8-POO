public class CuentaAhorros extends CuentaBancaria{
    // Atributos
    private double tasaInteres;

    // Constructor
    public CuentaAhorros(String numeroCuenta, String titular, double saldo, double tasaInteres) {
        super(numeroCuenta, titular, saldo);
        if(tasaInteres < 0 || tasaInteres > 1){
            throw new IllegalArgumentException("✗ Error capturado: La tasa de Interes debe de estar entre 0 y 1");
        }
        this.tasaInteres = tasaInteres;
    }

    // Getters
    public double getTasaInteres() {
        return tasaInteres;
    }

    // Sobreescritura
    @Override
    public void retirar(double monto) throws SaldoInsuficienteException {
        if(monto <= 0){
            throw new MontoInvalidoException("✗ Error capturado: El monto no puede ser negativo.");
        }

        if ((getSaldo() - monto) < 50){
            throw new SaldoInsuficienteException("✗ Error capturado: Saldo Insuficiente. Despues del retiro debe quedar al menos $50.00");
        }

        super.retirar(monto);
    }

    // Metodos
    public void aplicarInteres(){
        double interes = getSaldo() + (getSaldo() * tasaInteres);
        depositar(interes);
    }

    @Override
    public String toString() {
        return "CuentaAhorros{" +
                "numeroCuenta='" + getNumeroCuenta() + '\'' +
                ", titular='" + getTitular() + '\'' +
                ", saldo=" + getSaldo() +
                ", tasaInteres=" + tasaInteres +
                '}';
    }
}
