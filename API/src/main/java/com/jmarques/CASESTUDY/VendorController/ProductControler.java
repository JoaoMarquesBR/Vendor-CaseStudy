package com.jmarques.CASESTUDY.VendorController;
import com.jmarques.CASESTUDY.Entities.Product;
import com.jmarques.CASESTUDY.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ProductControler {

    @Autowired
    private ProductRepository repo;

    @GetMapping("/api/products")
    public ResponseEntity<Iterable<Product>>findAll(){
        Iterable<Product> list = repo.findAll();
        return new ResponseEntity<Iterable<Product>>(list,HttpStatus.OK);
    }

    @PutMapping("/api/products")
    public ResponseEntity<Product>updateOne(@RequestBody Product entity){
        Product updatedEntity = repo.save(entity);
        return new ResponseEntity<Product>(updatedEntity,HttpStatus.OK);
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> addOne(@RequestBody Product entity) {
        Product newEntity = repo.save(entity);
        return new ResponseEntity<Product>(newEntity, HttpStatus.OK);
    }
    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<Integer> deleteOne(@PathVariable String id) {
        return new ResponseEntity<Integer>(repo.deleteOne(id), HttpStatus.OK);
    }

    @GetMapping("/api/products/{vendorid}")
    public ResponseEntity<Iterable<Product>> findByVendor(@PathVariable Long vendorid) {
        Iterable<Product> products = repo.findByVendorid(vendorid);
        return new ResponseEntity<Iterable<Product>>(products, HttpStatus.OK);
    }


}

