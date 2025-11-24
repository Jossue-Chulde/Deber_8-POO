public class Libro extends MaterialBiblioteca {
    // Atributos
    private int numPaginas;
    private String editorial;
    private boolean esDigital;

    // Constructor
    public Libro(String codigo, String titulo, String autor, int anioPublicacion,
                 boolean estaPrestado, int numPaginas, String editorial, boolean esDigital) {
        super(codigo, titulo, autor, anioPublicacion, estaPrestado);
        if (numPaginas <= 0) {
            throw new IllegalArgumentException("✗ Error capturado: El numero de paginas debe de ser mayor a 0");
        }
        this.numPaginas = numPaginas;
        if (editorial == null || editorial.trim().isEmpty()) {
            throw new IllegalArgumentException("✗ Error capturado: La Editorial no puede estar vacio");
        }
        this.editorial = editorial;
        this.esDigital = esDigital;
    }

    // Getters
    public int getNumPaginas() {
        return numPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public boolean isEsDigital() {
        return esDigital;
    }

    // Sobreescritura
    @Override
    public double calcularMultaPorRetraso(int diasRetraso) {
        if (diasRetraso < 0) {
            throw new IllegalArgumentException("✗ Error capturado: Los dias de retraso no pueden ser negativos");
        }

        if (esDigital) {
            return diasRetraso * 0.50;
        } else {
            return diasRetraso * 1.00;
        }

    }

    @Override
    public int calcularTiempoMaximoPrestamo() {
        if (esDigital) {
            return 7;
        } else {
            return 15;
        }
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Libro{" +
                "codigo='" + getCodigo() + '\'' +
                ", titulo='" + getTitulo() + '\'' +
                ", autor='" + getAutor() + '\'' +
                ", anioPublicacion=" + getAnioPublicacion() +
                ", estaPrestado=" + isEstaPrestado() +
                ", numPaginas=" + numPaginas +
                ", editorial='" + editorial + '\'' +
                ", esDigital=" + esDigital +
                ", tiempoMaximoPrestamo=" + calcularTiempoMaximoPrestamo() +
                '}';
    }
}