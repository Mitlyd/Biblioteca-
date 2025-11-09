import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Usuario {
    private static final AtomicInteger generadorId = new AtomicInteger(1);
    private int id;
    private String nombre;
    private String email;
    private List<Prestamo> prestamos;
    private double multas;

    public Usuario(String nombre, String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.id = generadorId.getAndIncrement();
        this.nombre = nombre;
        this.email = email;
        this.prestamos = new ArrayList<>();
        this.multas = 0.0;
    }

    public boolean puedePedirPrestado() {
        return prestamos.size() < 3 && multas <= 5000;
    }

    public void agregarPrestamo(Prestamo p) throws excepciones.UsuarioSinCupoException {
        if (!puedePedirPrestado()) {
            throw new excepciones.UsuarioSinCupoException("El usuario no puede realizar más préstamos o tiene multas pendientes.");
        }
        prestamos.add(p);
    }

    public void agregarMulta(double valor) {
        multas += valor;
    }

    public void pagarMultas() {
        multas = 0;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public double getMultas() { return multas; }
    public List<Prestamo> getPrestamos() { return prestamos; }

    @Override
    public String toString() {
        return nombre + " (" + email + ") - Multas: $" + multas;
    }
}
