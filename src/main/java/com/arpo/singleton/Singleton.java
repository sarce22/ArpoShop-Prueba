package com.arpo.singleton;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arpo.models.Rol;
import com.arpo.models.User;
import com.arpo.service.RolService;
import com.arpo.service.UserService;

import jakarta.annotation.PostConstruct;

@Component
public class Singleton {
    
    private ArrayList<User> listUser;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RolService rolService;

    @PostConstruct
    private void init() {
        try {
            // Inicializar lista desde la base de datos
            listUser = new ArrayList<>(userService.listUser());
            
            // Solo crear datos iniciales si la base de datos está vacía
            if (listUser.isEmpty()) {
                System.out.println("🚀 Inicializando datos por defecto para demo...");
                
                // PASO 1: Esperar un poco para que las tablas se creen
                Thread.sleep(2000);
                
                // PASO 2: Crear usuarios por defecto
                createDefaultUsers();
                
                System.out.println("✅ Datos iniciales creados correctamente");
            } else {
                System.out.println("📊 Base de datos ya contiene " + listUser.size() + " usuarios");
            }
        } catch (Exception e) {
            System.err.println("❌ Error al inicializar datos: " + e.getMessage());
            e.printStackTrace();
            // Inicializar lista vacía para evitar errores
            listUser = new ArrayList<>();
        }
    }
    
    /**
     * Crear usuarios por defecto para la demo
     */
    private void createDefaultUsers() {
        try {
            // Obtener roles desde la base de datos
            Rol clienteRole = rolService.getRolById(1);
            Rol adminRole = rolService.getRolById(2);
            
            if (clienteRole == null || adminRole == null) {
                System.err.println("❌ Error: Los roles no están disponibles en la base de datos");
                return;
            }
            
            // Crear usuarios por defecto
            User user1 = new User(100L, "Sebastian", "Arce", 30, "sebas@eam.com", "user1", "123 Main St", "555-1234", clienteRole);
            User admin = new User(1010L, "Mariana", "Portela", 25, "admin@eam.com", "admin", "456 Elm St", "555-5678", adminRole);
            User user2 = new User(1094L, "Juanpa", "Valencia", 30, "juanVa@eam.com", "user2", "12322 Barcelona St", "555-98752", clienteRole);
            
            // Verificar que no existan ya (por email)
            if (!userService.isEmailDuplicated(user1.getEmail())) {
                userService.save(user1);
                listUser.add(user1);
                System.out.println("✅ Usuario cliente creado: " + user1.getEmail());
            }
            
            if (!userService.isEmailDuplicated(admin.getEmail())) {
                userService.save(admin);
                listUser.add(admin);
                System.out.println("✅ Usuario admin creado: " + admin.getEmail());
            }
            
            if (!userService.isEmailDuplicated(user2.getEmail())) {
                userService.save(user2);
                listUser.add(user2);
                System.out.println("✅ Usuario cliente 2 creado: " + user2.getEmail());
            }
            
        } catch (Exception e) {
            System.err.println("❌ Error al crear usuarios por defecto: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Obtener lista de usuarios (siempre actualizada desde la base de datos)
     */
    public ArrayList<User> getListUser() {
        try {
            // Actualizar desde la base de datos para tener datos frescos
            listUser = new ArrayList<>(userService.listUser());
            return listUser;
        } catch (Exception e) {
            System.err.println("❌ Error al obtener lista de usuarios: " + e.getMessage());
            return listUser != null ? listUser : new ArrayList<>();
        }
    }

    /**
     * Método para persistir datos (en producción se guarda automáticamente en PostgreSQL)
     */
    public void escribirObjetoListUser() {
        // En producción no usamos archivos, la persistencia es automática via JPA
        System.out.println("📝 Datos persistidos en base de datos PostgreSQL");
    }
    
    /**
     * Método de login - buscar en la base de datos
     */
    public Optional<User> login(String email, String password) {
        try {
            return userService.listUser().stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst();
        } catch (Exception e) {
            System.err.println("❌ Error en login: " + e.getMessage());
            return Optional.empty();
        }
    }
    
    /**
     * Obtener usuario por ID
     */
    public Optional<User> getUser(Long id) {
        try {
            return userService.findById(id);
        } catch (Exception e) {
            System.err.println("❌ Error al buscar usuario: " + e.getMessage());
            return Optional.empty();
        }
    }
}