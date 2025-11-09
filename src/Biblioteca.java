import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {
    private Map<String, Libro> libros;
    private Map<Integer, Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        libros = new HashMap<>();
        usuarios = new HashMap<>();
        prestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.put(libro.getIsbn(), libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public void realizarPrestamo(String isbn, int idUsuario)
            throws excepciones.LibroNoDisponibleException, excepciones.UsuarioSinCupoException {
        Libro libro = libros.get(isbn);
        Usuario usuario = usuarios.get(idUsuario);

        if (libro == null || usuario == null) {
            throw new IllegalArgumentException("Libro o usuario no encontrado.");
        }

        libro.prestar();
        Prestamo prestamo = new Prestamo(libro, usuario);
        usuario.agregarPrestamo(prestamo);
        prestamos.add(prestamo);
    }

    public void devolverLibro(String isbn, int idUsuario) {
        prestamos.stream()
                .filter(p -> p.getLibro().getIsbn().equals(isbn) && p.getUsuario().getId() == idUsuario)
                .findFirst()
                .ifPresent(p -> {
                    p.devolver();
                    p.getLibro().devolver();
                });
    }

    public List<Libro> obtenerTopLibrosPrestados() {
        return libros.values().stream()
                .sorted(Comparator.comparingInt(Libro::getVecesPrestado).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Usuario> obtenerUsuariosConMultas() {
        return usuarios.values().stream()
                .filter(u -> u.getMultas() > 0)
                .collect(Collectors.toList());
    }

    public void listarLibrosDisponibles() {
        libros.values().forEach(System.out::println);
    }

    public void listarUsuarios() {
        usuarios.values().forEach(System.out::println);
    }

    // 🔹 Nuevo método agregado (opción 6 del menú)
    public void consultarPrestamosDeUsuario(int idUsuario) {
        Optional<Usuario> usuarioOpt = Optional.ofNullable(usuarios.get(idUsuario));
        if (usuarioOpt.isEmpty()) {
            System.out.println("⚠️ Usuario no encontrado.");
            return;
        }

        Usuario usuario = usuarioOpt.get();
        if (usuario.getPrestamos().isEmpty()) {
            System.out.println("📘 El usuario no tiene préstamos activos.");
        } else {
            System.out.println("📚 Préstamos de " + usuario.getNombre() + ":");
            usuario.getPrestamos().forEach(System.out::println);
        }
    }
}
