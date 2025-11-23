import java.util.ArrayList;
import java.util.Random;

public class Banco {
    // Atributos
    private ArrayList<CuentaBancaria> cuentas;
    private String nombre;

    // Constructor
    public Banco(String nombre) {
        this.cuentas = new ArrayList<>();
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    // Getters
    public ArrayList<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public String getNombre() {
        return nombre;
    }

    // Metodo estatico
    public static String generarNumeroCuenta(){
        Random random = new Random();
        StringBuilder numeroCuenta = new StringBuilder();
        for(int i=0; i < 10; i++){
            numeroCuenta.append(random.nextInt(10));
        }
        return numeroCuenta.toString();
    }

    // Metodos
    public void abrirCuenta(CuentaBancaria cuenta){
        if(cuenta == null){
            throw new NullPointerException("✗ Error capturado: La cuenta bancaria no puede estar nula");
        }
        cuentas.add(cuenta);
    }
    public void transferir(String origen, String destino, double monto) throws SaldoInsuficienteException{
        if(monto <= 0){
            throw new MontoInvalidoException("✗ Error capturado: El monto no puede ser negativo");
        }
        CuentaBancaria cuentaOrigen = buscarCuenta(origen);
        CuentaBancaria cuentaDestino = buscarCuenta(destino);

        if(cuentaOrigen == null || cuentaDestino == null){
            throw new IllegalArgumentException("✗ Error capturado: Una de las cuentas no existe");
        }

        if (cuentaOrigen == cuentaDestino) {
            throw new IllegalArgumentException("✗ Error capturado: No se puede transferir a la misma cuenta");
        }

        // Retira de origen y deposita en destino
        cuentaOrigen.retirar(monto);
        cuentaDestino.depositar(monto);
    }

    // Metodo auxiliar para buscar cuenta por número
    private CuentaBancaria buscarCuenta(String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    public void aplicarInteresesAhorros(){
        for(CuentaBancaria cuenta : cuentas) {
            if (cuenta instanceof CuentaAhorros) {
                CuentaAhorros cuentaAhorros = (CuentaAhorros) cuenta;
                if (cuentaAhorros.getSaldo() == 0){
                    throw new CuentaInactivaException("✗ Error capturado: La cuenta no tiene saldo");
                }
                cuentaAhorros.aplicarInteres();
            }
        }
    }

    public double obtenerSaldoTotal(){
        if(cuentas.isEmpty()){
            throw new IllegalStateException("✗ Error capturado: No hay cuentas en el banco");
        }
        double saldoTotal = 0;
        for (CuentaBancaria cuenta : cuentas){
            saldoTotal += cuenta.getSaldo();
        }
        return saldoTotal;
    }

    public void ordenarPorSaldo(){
        int n = cuentas.size();
        for(int i=0; i < n - 1; i++){
            for(int j=0; j < n - i - 1; j++){
                if (cuentas.get(j).getSaldo() > cuentas.get(j + 1).getSaldo()) {
                    CuentaBancaria temp = cuentas.get(j);
                    cuentas.set(j, cuentas.get(j + 1));
                    cuentas.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", totalCuentas=" + cuentas.size() +
                ", saldoTotal=" + (cuentas.isEmpty() ? 0 : obtenerSaldoTotal()) +
                '}';
    }
}
