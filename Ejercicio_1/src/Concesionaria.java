import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Concesionaria {
    // Atributos
    ArrayList<Vehiculo> inventario;

    // Constructor
    public Concesionaria() {
        this.inventario = new ArrayList<>();
    }

    // Getters
    public ArrayList<Vehiculo> getInventario() {
        return inventario;
    }

    // Metodos
    public void agregarVehiculo(Vehiculo v){
        if(v == null){
            throw new NullPointerException("✗ Error capturado: El valor no puede ser Nulo");
        }
        inventario.add(v);
    }

    public double calcularTotalImpuestos(){
        if (inventario.isEmpty()) {
            throw new IllegalStateException("✗ Error capturado: El Inventario esta vacio");
        }

        double total = 0;
        for(Vehiculo vehiculo : inventario){
            total += vehiculo.calcularImpuestoCirculacion();
        }
        return total;
    }

    //  recorre ArrayList, compara precios. Si vacío: IllegalStateException
    public Vehiculo obtenerVehiculoMasCaro(){
        if(inventario.isEmpty()){
            throw new IllegalStateException("✗ Error capturado: El Inventario esta vacio");
        }

        Vehiculo vehiculoMasCaro = inventario.get(0);
        for(Vehiculo vehiculo: inventario){
            if(vehiculo.getPrecio() > vehiculoMasCaro.getPrecio()){
                vehiculoMasCaro = vehiculo;
            }
        }
        return vehiculoMasCaro;
    }

    public void ordenarPorPrecio() {
        Collections.sort(inventario, new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo v1, Vehiculo v2) {
                return Double.compare(v1.getPrecio(), v2.getPrecio());
            }
        });
    }

    // Mostar Cantidad de Vehiculos
    public int cantidadVehiculos() {
        return inventario.size();
    }
}
