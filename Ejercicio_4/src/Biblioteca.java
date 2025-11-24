import java.util.ArrayList;
public class Biblioteca {
    // Atributos
    private ArrayList<MaterialBiblioteca> catalogo;
    private String nombre;

    // Constructor
    public Biblioteca(String nombre) {
        this.catalogo = new ArrayList<>();
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("✗ Error capturado: El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    // Getters
    public ArrayList<MaterialBiblioteca> getCatalogo() {
        return new ArrayList<>(catalogo);
    }

    public String getNombre() {
        return nombre;
    }

    // Metodos estaticos
    public static void validarCodigo(String codigo) throws CodigoInvalidoException {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("✗ Error capturado: El código no puede estar vacio");
        }
        if (!codigo.matches("^(LIB|REV|DVD)-[A-Z0-9]{3,}$")) {
            throw new CodigoInvalidoException("✗ Error capturado: Formato de código inválido. Debe ser: LIB-XXX, REV-XXX o DVD-XXX");
        }
    }

    public static String generarCodigoAleatorio(String tipo){
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("✗ Error capturado: El tipo no puede estar vacio");
        }

        if (!tipo.equals("LIB") && !tipo.equals("REV") && !tipo.equals("DVD")) {
            throw new IllegalArgumentException("✗ Error capturado: Tipo debe ser LIB, REV o DVD");
        }
        StringBuilder codigo = new StringBuilder();
        codigo.append(tipo).append("-");
        for (int i = 0; i < 3; i++) {
            int digito = (int) (Math.random() * 10);
            codigo.append(digito);
        }
        return codigo.toString();
    }

    // Metodos
    public void agregarMaterial(MaterialBiblioteca material) throws CodigoInvalidoException {
        if (material == null) {
            throw new NullPointerException("✗ Error capturado: El material no puede ser nulo");
        }
        validarCodigo(material.getCodigo());
        catalogo.add(material);
    }

    public MaterialBiblioteca buscarMaterial(String codigo) throws MaterialNoEncontradoException {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("✗ Error capturado: El código no puede estar vacío");
        }
        for (MaterialBiblioteca material : catalogo) {
            if (material.getCodigo().equals(codigo)) {
                return material;
            }
        }
        throw new MaterialNoEncontradoException("✗ Error capturado: Material no encontrado con código: " + codigo);
    }

    public void prestarMaterial(String codigo) throws MaterialNoDisponibleException, MaterialNoEncontradoException {
        MaterialBiblioteca material = buscarMaterial(codigo);
        material.prestar();
    }

    public double devolverMaterial(String codigo, int diasRetraso) throws MaterialNoEncontradoException {
        if (diasRetraso < 0) {
            throw new IllegalArgumentException("✗ Error capturado: Los días de retraso no pueden ser negativos");
        }
        MaterialBiblioteca material = buscarMaterial(codigo);
        material.devolver();
        return material.calcularMultaPorRetraso(diasRetraso);
    }

    public ArrayList<MaterialBiblioteca> listarMaterialesDisponibles() {
        ArrayList<MaterialBiblioteca> disponibles = new ArrayList<>();
        for (MaterialBiblioteca material : catalogo) {
            if (!material.isEstaPrestado()) {
                disponibles.add(material);
            }
        }
        return disponibles;
    }

    public void ordenarPorAnio() {
        int n = catalogo.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (catalogo.get(j).getAnioPublicacion() > catalogo.get(j + 1).getAnioPublicacion()) {
                    MaterialBiblioteca temp = catalogo.get(j);
                    catalogo.set(j, catalogo.get(j + 1));
                    catalogo.set(j + 1, temp);
                }
            }
        }
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", totalMateriales=" + catalogo.size() +
                ", materialesDisponibles=" + listarMaterialesDisponibles().size() +
                '}';
    }
}
