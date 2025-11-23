public class CuentaBancaria {
    // Atributos
    private String numeroCuenta;
    private String titular;
    private double saldo;

    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        if(numeroCuenta == null || numeroCuenta.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: El numero de cuenta no puede esta vacio");
        }
        this.numeroCuenta = numeroCuenta;

        if(titular == null || titular.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: El titular de cuenta no puede esta vacio");
        }
        this.titular = titular;
        if(saldo < 0){
            throw new IllegalArgumentException("✗ Error capturado: El saldo debe de ser mayor a 0");
        }
        this.saldo = saldo;
    }

    // Getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Metodos
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("✗ Error capturado: El monto a depositar debe ser mayor que 0");
        }
        this.saldo += monto;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if(monto <= 0){
            throw new MontoInvalidoException("✗ Error capturado: El monto a retirar debe ser mayor a cero");
        }
        if(monto > this.saldo){
            throw new SaldoInsuficienteException("✗ Error capturado: Saldo Insuficiente");
        }
        this.saldo -= monto;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}