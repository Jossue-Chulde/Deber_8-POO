public class Revista extends MaterialBiblioteca{
    // Atributos
    private int numeroEdicion;
    private String mesPublicacion;
    private boolean esEspecializada;

    // Constructor
    public Revista(String codigo, String titulo, String autor, int anioPublicacion, boolean estaPrestado,
                   int numeroEdicion, String mesPublicacion, boolean esEspecializada) {
        super(codigo, titulo, autor, anioPublicacion, estaPrestado);
        if (numeroEdicion <= 0) {
            throw new IllegalArgumentException("✗ Error capturado: El numero de Edición debe de ser mayor a 0");
        }
        this.numeroEdicion = numeroEdicion;
        if (mesPublicacion == null || mesPublicacion.trim().isEmpty()) {
            throw new IllegalArgumentException("✗ Error capturado: El mes de publicacion no puede estar vacio");
        }
        this.mesPublicacion = mesPublicacion;
        this.esEspecializada = esEspecializada;
    }

    // Getters
    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public String getMesPublicacion() {
        return mesPublicacion;
    }

    public boolean isEsEspecializada() {
        return esEspecializada;
    }

    // Sobreescritura
    @Override
    public double calcularMultaPorRetraso(int diasRetraso){
        if (diasRetraso < 0) {
            throw new IllegalArgumentException("✗ Error capturado: Los dias de retraso no pueden ser negativos");
        }

        if(esEspecializada){
            return diasRetraso * 2.00;
        }else {
            return diasRetraso * 0.75;
        }

    }

    @Override
    public int calcularTiempoMaximoPrestamo(){
        if(esEspecializada){
            return 5;
        }else {
            return 7;
        }
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Revista{" +
                "codigo='" + getCodigo() + '\'' +
                ", titulo='" + getTitulo() + '\'' +
                ", autor='" + getAutor() + '\'' +
                ", anioPublicacion=" + getAnioPublicacion() +
                ", estaPrestado=" + isEstaPrestado() +
                ", tiempoMaximoPrestamo=" + calcularTiempoMaximoPrestamo() +
                ", numeroEdicion=" + numeroEdicion +
                ", mesPublicacion='" + mesPublicacion + '\'' +
                ", esEspecializada=" + esEspecializada +
                '}';
    }
}
