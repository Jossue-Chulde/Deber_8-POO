// Ejercicio 1: Sistema de Gestión de Vehículos
public class Main {
    public static void main(String[] args){
        // capturar IllegalArgumentException
        try {
            Auto vehiculo = new Auto("Toyota","Corolla",1800,1500);
            throw new IllegalArgumentException("Vehiculo Creado Correctamente");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        // capturar IllegalArgumentException
        try {
            Auto vehiculo = new Auto("Toyota","Corolla",1950,-1500);
            throw new IllegalArgumentException("Vehiculo Creado Correctamente");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        // Agregar 6 vehículos válidos (2 de cada tipo) al ArrayList

        Concesionaria concesionaria = new Concesionaria();
        concesionaria.agregarVehiculo(new Auto("Toyota","Corolla",2012,2900,4));
        concesionaria.agregarVehiculo(new Auto("Ford", "Mustang",2020,3000,2));

        concesionaria.agregarVehiculo(new Moto("Honda", "CBR 250",2001,2800,250));
        concesionaria.agregarVehiculo(new Moto("Yamaha", "MT-07",2010,1300,520));

        concesionaria.agregarVehiculo(new Camion("Volvo", "FH16",2022,4000,255));
        concesionaria.agregarVehiculo(new Camion("Mercedes", "Actros",2023,2500,255));

        System.out.println("Vehiculos Agregados: "+concesionaria.cantidadVehiculos());

        // capturar IllegalStateException con lista vacía
        Concesionaria concesionariaVacia = new Concesionaria();
        try {
            double total = concesionariaVacia.calcularTotalImpuestos();
            throw new IllegalStateException();
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

        // Calcular total de impuestos con lista llena
        double totalImpuestos = concesionaria.calcularTotalImpuestos();
        System.out.println("Total Impuestos: $"+totalImpuestos);

        // Obtener y mostrar vehículo más caro
        Vehiculo vehiculoMasCaro = concesionaria.obtenerVehiculoMasCaro();
        System.out.println("--- Vehiculo más Caro ---");
        System.out.println(vehiculoMasCaro);

        // Ordenar por precio y mostrar
        System.out.println("-- Vehiculos Ordenados por Precio --");
        concesionaria.ordenarPorPrecio();
        for (Vehiculo vehiculos : concesionaria.getInventario()){
            System.out.println("Marca: "+vehiculos.getMarca()+" - Modelo: "+vehiculos.getModelo()+" - Precio: $"+vehiculos.getPrecio());
        }
    }
}