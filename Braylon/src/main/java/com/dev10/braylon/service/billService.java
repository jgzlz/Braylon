
package com.dev10.braylon.service;

import com.dev10.braylon.data.CustomerDao;
import com.dev10.braylon.data.BillDao;
import com.dev10.braylon.models.Customer;
import com.dev10.braylon.models.Bill;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class billService {

    @Autowired
    BillDao dao;
    
    @Autowired
    CustomerDao cDao;
    
    public void addBill(Bill bill) {
        //Validate
        if(bill.getBillDate() == null || bill.getPrice() == null || bill.getProducts() == null || bill.getProducts().size() == 0 || bill.getStatus() == null) {
            return;
        }
        dao.save(bill);
    }
    
    public List<Bill> findAllBills() {
        
        return dao.findAll();
        
    }
    
    public List<Bill> findAllBillsByUsername(String username) {
        
        List<Customer> customers = cDao.findAllCustomersByUserUsername(username);
        List<Bill> bills = new ArrayList<>();
        
        for (Customer customer : customers) {
            
            bills.addAll(customer.getBills());
        }
        
        return bills;
    }
    
}
