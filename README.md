# Biblioteca-
<div align="center">

# 🌸📚 **Sistema de Gestión de Biblioteca** 🌸  
### ✨ *Parcial Final – Programación Orientada a Objetos (Java)* ✨  

💻 *Desarrollado por:*  
**MICHEEL FERNANDA QUINTERO 💕**

</div>

---

## 💫 Objetivo  

Desarrollar un **sistema de gestión de biblioteca** aplicando los fundamentos de **Programación Orientada a Objetos (OOP)**, manejo de **excepciones personalizadas**, validaciones, y reglas de negocio.  
El proyecto busca simular cómo una biblioteca real administra **libros, usuarios, préstamos y multas**. 📖💡  

---

## 🎀 Funcionalidades Principales  

| 🌟 Opción | ✨ Descripción |
|:----------:|:--------------|
| **1. ➕ Agregar libro** | Permite registrar un nuevo libro validando ISBN y año. |
| **2. 👩‍💻 Registrar usuario** | Crea usuarios con ID autogenerado y correo validado. |
| **3. 📖 Realizar préstamo** | Gestiona préstamos (máx. 3 libros por usuario). |
| **4. 🔁 Devolver libro** | Registra la devolución y actualiza la disponibilidad. |
| **5. 📘 Consultar libros disponibles** | Muestra todos los libros disponibles en la biblioteca. |
| **6. 🔍 Consultar préstamos de usuario** | Lista los préstamos activos de un usuario por su ID. |
| **7. 💸 Usuarios con multas** | Muestra los usuarios que tienen multas pendientes. |
| **8. 🏆 Top 5 libros más prestados** | Presenta los libros más populares del sistema. |
| **9. 🚪 Salir** | Finaliza la ejecución del programa. |

---

## 🧠 Conceptos Aplicados  

✨ **Programación Orientada a Objetos (OOP)**  
🔹 Encapsulación, métodos, clases y objetos.  
🔹 Reutilización de código y modularidad.  

💖 **Manejo de Excepciones Personalizadas**  
- `LibroNoDisponibleException`  
- `UsuarioSinCupoException`  

🪄 **Validaciones y Reglas de Negocio**  
- ISBN de 13 dígitos  
- Año válido del libro  
- Límite de 3 préstamos por usuario  
- Multas máximas de $5000  

🌼 **Colecciones y Streams**  
Uso de `HashMap`, `ArrayList`, `Optional` y `Streams` para búsquedas y reportes.  

⚡ **Concurrencia**  
Generación automática de IDs con `AtomicInteger`.  

---

## 🗂️ Estructura del Proyecto  
📁 Biblioteca/
│
├── 📁 src/
│ ├── 📁 excepciones/
│ │ ├── LibroNoDisponibleException.java
│ │ └── UsuarioSinCupoException.java
│ │
│ ├── Biblioteca.java
│ ├── BibliotecaApp.java
│ ├── Libro.java
│ ├── Prestamo.java
│ └── Usuario.java
│
├── .gitignore
└── README.md
