public class DVD extends MaterialBiblioteca{
    // Atributos
    private int duracionMinutos;
    private String genero;
    private boolean tieneSubtitulos;

    // Constructor
    public DVD(String codigo, String titulo, String autor, int anioPublicacion,
               boolean estaPrestado, int duracionMinutos, String genero, boolean tieneSubtitulos) {
        super(codigo, titulo, autor, anioPublicacion, estaPrestado);
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException("✗ Error capturado: La duración debe de ser mayor a 0");
        }
        this.duracionMinutos = duracionMinutos;

        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("✗ Error capturado: El genero no puede estar vacio");
        }
        this.genero = genero;
        this.tieneSubtitulos = tieneSubtitulos;
    }

    // Getters
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isTieneSubtitulos() {
        return tieneSubtitulos;
    }

    // Sobreescritura
    @Override
    public double calcularMultaPorRetraso(int diasRetraso){
        if(diasRetraso < 0){
            throw new IllegalArgumentException("✗ Error capturado: Los días de retraso no pueden ser negativos");
        }
        return diasRetraso * 1.50;
    }

    @Override
    public int calcularTiempoMaximoPrestamo(){
        return 3;
    }

    // Sobrecarga
    public double calcularMultaPorRetraso(int diasRetraso, boolean esEstreno) {
        if (diasRetraso < 0) {
            throw new IllegalArgumentException("✗ Error capturado: Los días de retraso no pueden ser negativos");
        }
        double multaBase = diasRetraso * 1.50;
        if (esEstreno) {
            return multaBase * 2;
        } else {
            return multaBase;
        }
    }

    // Metodo toString
    @Override
    public String toString() {
        return "DVD{" +
                "codigo='" + getCodigo() + '\'' +
                ", titulo='" + getTitulo() + '\'' +
                ", autor='" + getAutor() + '\'' +
                ", anioPublicacion=" + getAnioPublicacion() +
                ", estaPrestado=" + isEstaPrestado() +
                ", tiempoMaximoPrestamo=" + calcularTiempoMaximoPrestamo() +
                ", duracionMinutos=" + duracionMinutos +
                ", genero='" + genero + '\'' +
                ", tieneSubtitulos=" + tieneSubtitulos +
                '}';
    }
}
