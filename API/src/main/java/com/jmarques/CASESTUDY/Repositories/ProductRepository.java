package com.jmarques.CASESTUDY.Repositories;

import com.jmarques.CASESTUDY.Entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends CrudRepository<Product, Long> {
    // extend so we can return the number of rows deleted
    @Modifying//important, since it will be modifrying the DB
    @Transactional//needed for delete and update operations
    @Query("delete from Product where id = ?1")
    int deleteOne(String expenseId);

    List<Product> findByVendorid(Long vendorid);

    Optional<Product> findById(String productid);

}

