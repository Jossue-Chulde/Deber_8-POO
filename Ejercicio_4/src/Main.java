// Ejercicio 4: Sistema de Biblioteca Digital (SIMPLIFICADO)
public class Main {
    public static void main(String[] args) {
        try {
            Biblioteca biblioteca = new Biblioteca("Biblioteca POO");
            System.out.println("Probar crear material con título vacío (IllegalArgumentException)");
            try {
                Libro libroInvalido = new Libro("LIB-1001", "", "Autor Test", 2020,
                        false, 300, "Editorial", false);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\\nProbar crear material con año < 1000 (IllegalArgumentException)");
            try {
                Revista revistaInvalida = new Revista("REV-1001", "Revista Test", "Editor",
                        500, false, 1, "Enero", false);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\\nProbar agregar material con código inválido (CodigoInvalidoException)");
            try {
                Libro libroCodigoInvalido = new Libro("CODIGO-INVALIDO", "Libro Test", "Autor",
                        2020, false, 250, "Editorial", false);
                biblioteca.agregarMaterial(libroCodigoInvalido);
            } catch (CodigoInvalidoException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nAgregar 8 materiales válidos (2 Libros, 2 Revistas, 2 DVDs, 2 de cualquier tipo)");
            Libro libro1 = new Libro("LIB-1001", "Cien Años de Soledad", "Gabriel García Márquez",
                    1967, false, 417, "Sudamericana", false);
            Libro libro2 = new Libro("LIB-1002", "1984", "George Orwell",
                    1949, false, 328, "Secker & Warburg", true);
            biblioteca.agregarMaterial(libro1);
            biblioteca.agregarMaterial(libro2);

            Revista revista1 = new Revista("REV-2001", "National Geographic", "Varios Autores",
                    2024, false, 245, "Marzo", false);
            Revista revista2 = new Revista("REV-2002", "Science Journal", "Equipo Editorial",
                    2023, false, 156, "Noviembre", true);
            biblioteca.agregarMaterial(revista1);
            biblioteca.agregarMaterial(revista2);

            DVD dvd1 = new DVD("DVD-3001", "El Padrino", "Francis Ford Coppola",
                    1972, false, 175, "Drama", false);
            DVD dvd2 = new DVD("DVD-3002", "Interestelar", "Christopher Nolan",
                    2014, false, 169, "Ciencia Ficción", true);
            biblioteca.agregarMaterial(dvd1);
            biblioteca.agregarMaterial(dvd2);

            Libro libro3 = new Libro("LIB-1003", "Don Quijote", "Miguel de Cervantes",
                    1605, false, 863, "Francisco de Robles", false);
            DVD dvd3 = new DVD("DVD-3003", "Matrix", "Hermanas Wachowski",
                    1999, false, 136, "Ciencia Ficción", true);
            biblioteca.agregarMaterial(libro3);
            biblioteca.agregarMaterial(dvd3);
            System.out.println(biblioteca.toString());

            System.out.println("\nRealizar 4 préstamos exitosos");
            try {
                biblioteca.prestarMaterial("LIB-1001");
                biblioteca.prestarMaterial("REV-2001");
                biblioteca.prestarMaterial("DVD-3001");
                biblioteca.prestarMaterial("LIB-1003");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nProbar préstamo de material ya prestado (MaterialNoDisponibleException)");
            try {
                biblioteca.prestarMaterial("LIB-1001");
            } catch (MaterialNoDisponibleException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nProbar buscar material inexistente (MaterialNoEncontradoException)");
            try {
                biblioteca.buscarMaterial("LIB-9999");
            } catch (MaterialNoEncontradoException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nDevolver 2 materiales con diferentes días de retraso y mostrar multas");
            try {
                double multa1 = biblioteca.devolverMaterial("LIB-1001", 3);
                System.out.println("Devolución: LIB-1001 - Multa por 3 días: $" + multa1);

                double multa2 = biblioteca.devolverMaterial("DVD-3001", 7);
                System.out.println("Devolución: DVD-3001 - Multa por 7 días: $" + multa2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nListar materiales disponibles");
            var disponibles = biblioteca.listarMaterialesDisponibles();
            if (disponibles.isEmpty()) {
                System.out.println("No hay materiales disponibles");
            } else {
                for (var material : disponibles) {
                    System.out.println("  - " + material.getCodigo() + ": " + material.getTitulo() +
                            " (" + (material.isEstaPrestado() ? "Prestado" : "Disponible") + ")");
                }
            }

            System.out.println("\nOrdenar por año y mostrar");
            biblioteca.ordenarPorAnio();
            System.out.println("\nMateriales después de ordenar (ascendente):");
            for (var material : biblioteca.getCatalogo()) {
                System.out.println("  - " + material.getAnioPublicacion() + ": " + material.getTitulo());
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}