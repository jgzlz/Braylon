package com.dev10.braylon.data;

import com.dev10.braylon.models.Role;
import com.dev10.braylon.models.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserStubDao {
    
    private List<User> users = new ArrayList<>();
    
    public UserStubDao() {
        Role user = new Role();
        user.setRoleId(1);
        user.setRole("ROLE_USER");
        
        Role admin = new Role();
        admin.setRoleId(2);
        admin.setRole("ROLE_ADMIN");
        
        
        User user1 = new User();
        user1.setEmail("totallyFake1@fakeyFakey.com");
        user1.setEnabled(true);
        user1.setFirstName("Fakey");
        user1.setLastName("Faker");
        user1.setPassword("password");
        user1.setUserId(1);
        user1.setUsername("user1");
        List<Role> user1Roles = new ArrayList<>();
        user1Roles.add(user);
        
        User admin1 = new User();
        admin1.setEmail("totallyFake2@fakeyFakey.com");
        admin1.setEnabled(true);
        admin1.setFirstName("Admin");
        admin1.setLastName("Faker");
        admin1.setPassword("password");
        admin1.setUserId(2);
        admin1.setUsername("admin1");
        List<Role> admin1Roles = new ArrayList<>();
        admin1Roles.add(user);
        admin1Roles.add(admin);
        
        users.add(user1); users.add(admin1);
    }
    
    
    public User findUserByUserId(int userId) {
        
        List<User> myUser = findAllUsers();
        
        return myUser.stream().filter(u -> u.getUserId().equals(userId)).findFirst().orElse(null);
    }
    
    public User findUserByUsername(String username) {
        List<User> myUsers = findAllUsers();
        
        return myUsers.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }
    
    public List<User> findAllUsers() {
        List<User> myUsers = new ArrayList<>(users);
        
        return myUsers;
    }
    
}

