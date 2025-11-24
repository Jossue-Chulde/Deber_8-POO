public abstract class MaterialBiblioteca {
    // Atributos
    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean estaPrestado;

    // Constructor
    public MaterialBiblioteca(String codigo, String titulo, String autor,
                              int anioPublicacion, boolean estaPrestado) {
        if(codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: El código no puede estar vacio");
        }
        this.codigo = codigo;

        if(titulo == null || titulo.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: El titulo no puede estar vacio");
        }
        this.titulo = titulo;

        if(autor == null || autor.trim().isEmpty()){
            throw new IllegalArgumentException("✗ Error capturado: El autor no puede estar vacio");
        }
        this.autor = autor;

        if(anioPublicacion < 1000 || anioPublicacion > 2025){
            throw new IllegalArgumentException("✗ Error capturado: Tiene que estar entre el año 1000 y 2025");
        }
        this.anioPublicacion = anioPublicacion;
        this.estaPrestado = estaPrestado;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public boolean isEstaPrestado() {
        return estaPrestado;
    }

    // Metodos abstractos
    public abstract double calcularMultaPorRetraso(int diasRetraso);
    public abstract int calcularTiempoMaximoPrestamo();

    // Metodos
    public void prestar() throws MaterialNoDisponibleException {
        if (estaPrestado) {
            throw new MaterialNoDisponibleException("✗ Error capturado: El material no está disponible para préstamo");
        }
        this.estaPrestado = true;
    }

    public void devolver() {
        if (!estaPrestado) {
            throw new MaterialNoDisponibleException("✗ Error capturado: El material no estaba prestado");
        }
        this.estaPrestado = false;
    }

    @Override
    public String toString() {
        return "MaterialBiblioteca{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", estaPrestado=" + estaPrestado +
                '}';
    }
}
