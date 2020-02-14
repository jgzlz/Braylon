package com.dev10.braylon.service;

import com.dev10.braylon.models.Bill;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev10.braylon.data.BillDao;

@Service
public class billService {

    @Autowired
    BillDao dao;
    
    public void addOrder(Bill order) {
        //Validate
        if(order.getCustomer() == null || order.getOrderDate() == null || order.getPrice() == null || order.getProducts() == null || order.getProducts().size() == 0 || order.getStatus() == null) {
            return;
        }
        dao.save(order);
    }

    Collection<? extends Bill> getOrdersByCustId(Integer customerId) {
        List<Bill> orders = dao.findAll();
        List<Bill> toReturn = new ArrayList();
        for(Bill o : orders) {
            if(o.getCustomer().getCustomerId() == customerId) {
                toReturn.add(o);
            }
        }
        return toReturn;
    }
    
}
