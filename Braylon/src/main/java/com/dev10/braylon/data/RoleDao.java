package com.dev10.braylon.data;

import com.dev10.braylon.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
    
    public Role findRoleByRole(String role);
    
}
