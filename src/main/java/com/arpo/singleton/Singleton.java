package com.arpo.singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arpo.models.Rol;
import com.arpo.models.User;
import com.arpo.service.UserService;

import jakarta.annotation.PostConstruct;

@Component
public class Singleton {
	
    private ArrayList<User> listUser;
    
    @Autowired
    private UserService user;

    @PostConstruct
private void init() {
 
    // listUser = leerUser();
    
    // ✅ REEMPLAZAR con esto:
    listUser = new ArrayList<>(user.listUser());
    
    // Solo crear usuarios por defecto si la base de datos está vacía
    if (listUser.isEmpty()) {
        User user1 = new User(100L, "Sebastian", "Arce", 30, "sebas@eam.com", "user1", "123 Main St", "555-1234", new Rol(1, "Cliente"));
        User admin = new User(1010L, "Mariana", "Portela", 25, "admin@eam.com", "admin", "456 Elm St", "555-5678", new Rol(2, "Administrador"));
        User user2 = new User(1094L, "Juanpa", "Valencia", 30, "juanVa@eam.com", "user2", "12322 Barcelona St", "555-98752", new Rol(1, "Cliente"));
        
        user.save(user1);
        user.save(user2);
        user.save(admin);
        
        listUser.add(user1);
        listUser.add(admin);
        listUser.add(user2);
        
        System.out.println("✅ Usuarios iniciales creados para demo");
    }
}

    public ArrayList<User> getListUser() {
        return listUser;  
    }

    public void escribirObjetoListUser() {
    
    System.out.println("📝 Datos guardados en PostgreSQL");
}

    private ArrayList<User> leerUser() {
        try {
            FileInputStream archivo = new FileInputStream("user.data");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (ArrayList<User>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    
    
    public Optional<User> login(String email, String password) {
        for (User user : listUser) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return Optional.of(user); 
            }
        }
        return Optional.empty();
    }
    
    
    public Optional<User> getUser(Long id) {
        for (User user : listUser) {
            if (user.getIdUser().equals(id)) {
                return Optional.of(user); 
            }
        }
        return Optional.empty();
    }

	

}
