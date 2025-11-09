public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anio;
    private int ejemplaresTotales;
    private int ejemplaresDisponibles;
    private int vecesPrestado;

    public Libro(String isbn, String titulo, String autor, int anio, int ejemplaresTotales) {
        if (!isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException("El ISBN debe tener 13 dígitos.");
        }
        if (anio < 1500 || anio > 2025) {
            throw new IllegalArgumentException("Año inválido.");
        }
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.ejemplaresTotales = ejemplaresTotales;
        this.ejemplaresDisponibles = ejemplaresTotales;
        this.vecesPrestado = 0;
    }

    public boolean estaDisponible() {
        return ejemplaresDisponibles > 0;
    }

    public void prestar() throws excepciones.LibroNoDisponibleException {
        if (!estaDisponible()) {
            throw new excepciones.LibroNoDisponibleException("No hay ejemplares disponibles del libro: " + titulo);
        }
        ejemplaresDisponibles--;
        vecesPrestado++;
    }

    public void devolver() {
        if (ejemplaresDisponibles < ejemplaresTotales) {
            ejemplaresDisponibles++;
        }
    }

    // Getters
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnio() { return anio; }
    public int getEjemplaresDisponibles() { return ejemplaresDisponibles; }
    public int getVecesPrestado() { return vecesPrestado; }

    @Override
    public String toString() {
        return titulo + " (" + autor + ") - " + ejemplaresDisponibles + "/" + ejemplaresTotales + " disponibles";
    }
}
