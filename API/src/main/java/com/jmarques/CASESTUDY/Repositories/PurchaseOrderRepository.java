package com.jmarques.CASESTUDY.Repositories;

import com.jmarques.CASESTUDY.Entities.Product;
import com.jmarques.CASESTUDY.Entities.PurchaseOrder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "purchaseorders", path = "purchaseorders")
public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Long> {
    // extend so we can return the number of rows deleted
    @Modifying//important, since it will be modifrying the DB
    @Transactional//needed for delete and update operations
    @Query("delete from PurchaseOrder where id = ?1")
    int deleteOne(String expenseId);

    List<PurchaseOrder> findByVendorid(Long vendorid);

}

