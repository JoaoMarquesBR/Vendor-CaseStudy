package com.jmarques.CASESTUDY.VendorController;

import com.jmarques.CASESTUDY.DAO.PurchaseOrderDAO;
import com.jmarques.CASESTUDY.Entities.Vendor;
import com.jmarques.CASESTUDY.Repositories.VendorRepository;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@CrossOrigin
@RestController
public class VendorController {

    @Autowired
    private VendorRepository repo;

    @Autowired
    private PurchaseOrderDAO dao;

    @GetMapping("/api/vendors")
    public ResponseEntity<Iterable<Vendor>>findAll(){
        Iterable<Vendor>list = repo.findAll();
        return new ResponseEntity<Iterable<Vendor>>(list, HttpStatus.OK);
    }

    @PutMapping("/api/vendors")
    public ResponseEntity<Vendor>updateOne(@RequestBody Vendor vendor){
        Vendor updtVendor = repo.save(vendor);
        return new ResponseEntity<Vendor>(updtVendor,HttpStatus.OK);
    }

    @PostMapping("/api/vendors")
    public ResponseEntity<Vendor>addOne(@RequestBody Vendor vendor){
        Vendor newVendor = repo.save(vendor);
        return new ResponseEntity<>(newVendor,HttpStatus.OK);
    }

    @DeleteMapping("/api/vendors/{id}")
    public ResponseEntity<Integer> deleteOne(@PathVariable long id) {
        return new ResponseEntity<Integer>(repo.deleteOne(id), HttpStatus.OK);
    }

}
