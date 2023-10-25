package com.jmarques.CASESTUDY.DAO;

import com.jmarques.CASESTUDY.Entities.PurchaseOrder;
import com.jmarques.CASESTUDY.Entities.PurchaseOrderLineitem;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class PurchaseOrderDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public PurchaseOrder create(PurchaseOrder clientrep) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setVendorid(clientrep.getVendorid());
        purchaseOrder.setAmount(new BigDecimal(0));
        purchaseOrder.setPodate(LocalDateTime.now());

        entityManager.persist(purchaseOrder);

        for (PurchaseOrderLineitem item : clientrep.getItems()) {
            PurchaseOrderLineitem realItem = new PurchaseOrderLineitem();
            realItem.setPrice(item.getPrice());
            realItem.setQty(item.getQty());
            realItem.setProductid(item.getProductid());
            realItem.setPoid(purchaseOrder.getId().toString());

            int quantity = item.getQty();
            BigDecimal decimalQuantity = new BigDecimal(quantity);
            BigDecimal price = item.getPrice();
            BigDecimal result = price.multiply(decimalQuantity);

            purchaseOrder.setAmount(purchaseOrder.getAmount().add(result));


            purchaseOrder.getItems().add(realItem);
            entityManager.persist(realItem);
        }

        entityManager.flush();
        entityManager.refresh(purchaseOrder);
        return purchaseOrder;
    }
}
