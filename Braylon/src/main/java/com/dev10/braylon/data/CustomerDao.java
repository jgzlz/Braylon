
package com.dev10.braylon.data;

import com.dev10.braylon.models.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jeromepullenjr
 */

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

    public List<Customer> findAllCustomersByUserUsername(String username);
    
}
