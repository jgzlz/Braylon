package com.dev10.braylon.service;

import com.dev10.braylon.data.ProductDao;
import com.dev10.braylon.models.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productService {

    @Autowired
    ProductDao dao;
    
    public List<Product> findAllProducts() {
        return dao.findAll();
    }
    
}
