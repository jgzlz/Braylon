package com.dev10.braylon.service;

import com.dev10.braylon.data.SalesVisitDao;
import com.dev10.braylon.models.SalesVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class salesVisitService {

    @Autowired
    SalesVisitDao dao;
    
    public void addSalesVisit(SalesVisit visit) {
        //Validate
        dao.save(visit);
    }
    
}
