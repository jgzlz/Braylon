package com.dev10.braylon.service;

import com.dev10.braylon.data.OrderDao;
import com.dev10.braylon.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderService {

    @Autowired
    OrderDao dao;
    
    public void addOrder(Order order) {
        //Validate
        if(order.getCustomer() == null || order.getOrderDate() == null || order.getPrice() == null || order.getProducts() == null || order.getProducts().size() == 0 || order.getStatus() == null) {
            return;
        }
        dao.save(order);
    }
    
}
