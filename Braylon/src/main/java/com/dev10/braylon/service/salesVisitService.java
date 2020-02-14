package com.dev10.braylon.service;

import com.dev10.braylon.data.SalesVisitDao;
import com.dev10.braylon.models.SalesVisit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class salesVisitService {

    @Autowired
    SalesVisitDao dao;
    
    public List<SalesVisit> findAllSalesVisits() {
        
        List<SalesVisit> all = dao.findAll();
        return all;
    }
    
    public void addSalesVisit(SalesVisit visit) {
        //Validate
        if(visit.getCustomer() == null || visit.getLocation() == null || visit.getUser() == null || visit.getVisitDate() == null) {
            return;
        }
        dao.save(visit);
    }
    
}
