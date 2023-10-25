package com.jmarques.CASESTUDY.Repositories;
import com.jmarques.CASESTUDY.Entities.Vendor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "vendors",path="vendors")
public interface VendorRepository extends CrudRepository<Vendor,Long> {

    @Modifying
    @Transactional
    @Query("delete from Vendor where id = ?1")
    int deleteOne(Long vendorId);

}
