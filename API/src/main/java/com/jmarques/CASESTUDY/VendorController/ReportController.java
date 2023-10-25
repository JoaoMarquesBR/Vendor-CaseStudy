package com.jmarques.CASESTUDY.VendorController;

import com.jmarques.CASESTUDY.DAO.PurchaseOrderDAO;
import com.jmarques.CASESTUDY.Entities.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ReportController {
    @Autowired
    private PurchaseOrderDAO dao;
    @PostMapping("/api/reports")
    public ResponseEntity<PurchaseOrder> addOne(@RequestBody PurchaseOrder clientrep) { // use RequestBody here
        return new ResponseEntity<PurchaseOrder>(dao.create(clientrep), HttpStatus.OK);
    }
}
