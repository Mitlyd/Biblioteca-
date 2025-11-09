import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
            System.out.println("1. Agregar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Realizar préstamo");
            System.out.println("4. Devolver libro");
            System.out.println("5. Consultar libros disponibles");
            System.out.println("6. Consultar préstamos de usuario");
            System.out.println("7. Listar usuarios con multas");
            System.out.println("8. Top 5 libros más prestados");
            System.out.println("9. Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1 -> {
                        System.out.print("ISBN (13 dígitos): ");
                        String isbn = sc.nextLine();
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        System.out.print("Autor: ");
                        String autor = sc.nextLine();
                        System.out.print("Año: ");
                        int anio = sc.nextInt();
                        System.out.print("Ejemplares: ");
                        int ejemplares = sc.nextInt();
                        biblioteca.agregarLibro(new Libro(isbn, titulo, autor, anio, ejemplares));
                        System.out.println("✅ Libro agregado correctamente.");
                    }
                    case 2 -> {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        biblioteca.registrarUsuario(new Usuario(nombre, email));
                        System.out.println("✅ Usuario registrado correctamente.");
                    }
                    case 3 -> {
                        System.out.print("ISBN del libro: ");
                        String isbn = sc.nextLine();
                        System.out.print("ID del usuario: ");
                        int id = sc.nextInt();
                        biblioteca.realizarPrestamo(isbn, id);
                        System.out.println("✅ Préstamo realizado con éxito.");
                    }
                    case 4 -> {
                        System.out.print("ISBN del libro: ");
                        String isbn = sc.nextLine();
                        System.out.print("ID del usuario: ");
                        int id = sc.nextInt();
                        biblioteca.devolverLibro(isbn, id);
                        System.out.println("📘 Libro devuelto correctamente.");
                    }
                    case 5 -> biblioteca.listarLibrosDisponibles();
                    case 6 -> {
                        System.out.print("Ingrese el ID del usuario: ");
                        int id = sc.nextInt();
                        biblioteca.consultarPrestamosDeUsuario(id);
                    }
                    case 7 -> {
                        System.out.println("=== Usuarios con multas pendientes ===");
                        biblioteca.obtenerUsuariosConMultas().forEach(System.out::println);
                    }
                    case 8 -> {
                        System.out.println("=== Top 5 libros más prestados ===");
                        biblioteca.obtenerTopLibrosPrestados().forEach(System.out::println);
                    }
                    case 9 -> System.out.println("👋 Saliendo del sistema...");
                    default -> System.out.println("⚠️ Opción no válida, intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Error: " + e.getMessage());
            }
        } while (opcion != 9);
    }
}
