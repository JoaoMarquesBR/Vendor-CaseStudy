package com.jmarques.CASESTUDY.VendorController;
import com.jmarques.CASESTUDY.DAO.PurchaseOrderDAO;
import com.jmarques.CASESTUDY.Entities.Product;
import com.jmarques.CASESTUDY.Entities.PurchaseOrder;
import com.jmarques.CASESTUDY.Repositories.ProductRepository;
import com.jmarques.CASESTUDY.Repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class PurchaseOrderController {

    @Autowired
    private PurchaseRepository repo;
    @GetMapping("/api/purchases")
    public ResponseEntity<Iterable<PurchaseOrder>>findAll(){
        Iterable<PurchaseOrder> list = repo.findAll();
        return new ResponseEntity<Iterable<PurchaseOrder>>(list,HttpStatus.OK);
    }

    @PutMapping("/api/purchases")
    public ResponseEntity<PurchaseOrder>updateOne(@RequestBody PurchaseOrder entity){
        PurchaseOrder updatedEntity = repo.save(entity);
        return new ResponseEntity<PurchaseOrder>(updatedEntity,HttpStatus.OK);
    }

    @PostMapping("/api/purchases")
    public ResponseEntity<PurchaseOrder> addOne(@RequestBody PurchaseOrder entity) {
        PurchaseOrder newEntity = repo.save(entity);
        return new ResponseEntity<PurchaseOrder>(newEntity, HttpStatus.OK);
    }
    @DeleteMapping("/api/purchases/{id}")
    public ResponseEntity<Integer> deleteOne(@PathVariable String id) {
        return new ResponseEntity<Integer>(repo.deleteOne(id), HttpStatus.OK);
    }

    @GetMapping("/api/purchases/{vendorid}")
    public ResponseEntity<Iterable<PurchaseOrder>> findByEmployee(@PathVariable Long vendorid) {
        Iterable<PurchaseOrder> expenses = repo.findByVendorid(vendorid);
        return new ResponseEntity<Iterable<PurchaseOrder>>(expenses, HttpStatus.OK);
    }

}

