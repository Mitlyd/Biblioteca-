import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private EstadoPrestamo estado;

    public enum EstadoPrestamo {
        ACTIVO, DEVUELTO, VENCIDO
    }

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaPrestamo.plusDays(14);
        this.estado = EstadoPrestamo.ACTIVO;
    }

    public BigDecimal calcularMulta() {
        if (estado == EstadoPrestamo.DEVUELTO) return BigDecimal.ZERO;
        long diasRetraso = ChronoUnit.DAYS.between(fechaDevolucion, LocalDate.now());
        if (diasRetraso > 0) {
            return BigDecimal.valueOf(diasRetraso * 500);
        }
        return BigDecimal.ZERO;
    }

    public void devolver() {
        this.estado = EstadoPrestamo.DEVUELTO;
    }

    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }
    public EstadoPrestamo getEstado() { return estado; }

    @Override
    public String toString() {
        return libro.getTitulo() + " - Estado: " + estado + " (Devolver antes del " + fechaDevolucion + ")";
    }
}
