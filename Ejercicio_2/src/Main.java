// Ejercicio 2: Gestión de Cuentas Bancarias
public class Main {
    public static void main(String[] args) {
        try {

            Banco banco = new Banco("Banco");
            // Probar crear cuenta con titular vacío (IllegalArgumentException)
            try {
                CuentaBancaria cuentaBancaria1 = new CuentaBancaria("123456", "", 1000);
                throw new IllegalArgumentException("Cuenta creada correctammente");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                ;
            }

            // Probar crear cuenta con saldo negativo (IllegalArgumentException)
            try {
                CuentaBancaria cuentaBancaria2 = new CuentaBancaria("123", "Juan", -2000);
                throw new IllegalArgumentException("Cuenta creada correctammente");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // Agregar 6 cuentas válidas (2 de cada tipo)
            CuentaAhorros cuentaAhorros1 = new CuentaAhorros("1001", "Mike Salguero", 1000, 0.05);
            CuentaAhorros cuentaAhorros2 = new CuentaAhorros("1002", "Matero Torres", 2000, 0.03);
            banco.abrirCuenta(cuentaAhorros1);
            banco.abrirCuenta(cuentaAhorros2);

            CuentaCorriente cuentaCorriente1 = new CuentaCorriente("2001", "Emilio Estrada", 600, 200);
            CuentaCorriente cuentaCorriente2 = new CuentaCorriente("2002", "Andrea Garcia", 700, 500);
            banco.abrirCuenta(cuentaCorriente1);
            banco.abrirCuenta(cuentaCorriente2);

            CuentaInversion cuentaInversion1 = new CuentaInversion("3001", "Alex Toapanta", 1800, 100, 0.10);
            CuentaInversion cuentaInversion2 = new CuentaInversion("3002", "Anahi Solorzano", 2000, 100, 0.08);
            banco.abrirCuenta(cuentaInversion1);
            banco.abrirCuenta(cuentaInversion2);
            System.out.println(banco.toString());

            // Realizar depósitos y retiros
            cuentaAhorros1.depositar(500);
            cuentaAhorros2.depositar(300);
            cuentaCorriente1.depositar(400);
            cuentaCorriente2.depositar(300);
            cuentaInversion1.depositar(200);
            cuentaInversion2.depositar(500);
            System.out.println(banco.toString());

            // Probar retiro con saldo insuficiente (SaldoInsuficienteException)
            try {
                cuentaAhorros1.retirar(2000);
            } catch (SaldoInsuficienteException e) {
                System.out.println(e.getMessage());
            }

            try {
                cuentaCorriente1.retirar(20000);
            } catch (SaldoInsuficienteException e) {
                System.out.println(e.getMessage());
            }

            try {
                cuentaInversion1.retirar(20000);
            } catch (SaldoInsuficienteException e) {
                System.out.println(e.getMessage());
            }
            // Probar transferencia exitosa
            try{
                banco.transferir("1001","1002",100);
                System.out.println("Transferencia Exitosa");
            }catch (SaldoInsuficienteException e){
                System.out.println(e.getMessage());
            }

            // Probar transferencia fallida
            try {
                banco.transferir("1002", "1001", 5000);
                System.out.println("Transferencia Exitosa");
            } catch (SaldoInsuficienteException e) {
                System.out.println(e.getMessage());
            }

            // Probar monto negativo (MontoInvalidoException)
            try {
                cuentaAhorros1.retirar(-50);
            } catch (MontoInvalidoException e) {
                System.out.println(e.getMessage());
            }

            // Calcular saldo total del banco
            double saldoTotal = banco.obtenerSaldoTotal();
            System.out.println("Saldo total del banco: $" + saldoTotal);

            // Aplicar intereses y probar CuentaInactivaException
            CuentaAhorros ahorrosInactiva = new CuentaAhorros("1013", "UsuarioInactivo", 0, 0.02);
            banco.abrirCuenta(ahorrosInactiva);
            try {
                banco.aplicarInteresesAhorros();
                System.out.println("✓ Intereses aplicados exitosamente");
            } catch (CuentaInactivaException e) {
                System.out.println(e.getMessage());
            }

            // Ordenar por saldo
            System.out.println("Cuentas antes de ordenar:");
            for (CuentaBancaria cuenta : banco.getCuentas()) {
                System.out.println("  - " + cuenta.getNumeroCuenta() + ": $" + cuenta.getSaldo());
            }

            banco.ordenarPorSaldo();

            System.out.println("\nCuentas después de ordenar (ascendente):");
            for (CuentaBancaria cuenta : banco.getCuentas()) {
                System.out.println("  - " + cuenta.getNumeroCuenta() + ": $" + cuenta.getSaldo());
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}