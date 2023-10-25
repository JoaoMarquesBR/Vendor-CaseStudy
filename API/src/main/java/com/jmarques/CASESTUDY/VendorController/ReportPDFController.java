package com.jmarques.CASESTUDY.VendorController;

import com.jmarques.CASESTUDY.Entities.PurchaseOrderLineitem;
import com.jmarques.CASESTUDY.Repositories.ProductRepository;
import com.jmarques.CASESTUDY.Repositories.PurchaseOrderRepository;
import com.jmarques.CASESTUDY.Repositories.VendorRepository;
import com.jmarques.CASESTUDY.Services.ReportPDFGenerator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@CrossOrigin
@RestController
public class ReportPDFController {

    @Autowired
    private VendorRepository vendorRepo;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PurchaseOrderRepository purchaseRepo;


    @GetMapping(value = "/ReportPDF", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> streamPDF(@RequestParam("venid") String venid) throws IOException {

         ByteArrayInputStream bis = ReportPDFGenerator.generateReport(String.valueOf(venid),
                purchaseRepo,
                vendorRepo,
                productRepository);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=examplereport.pdf");
        // dump stream to browser
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));


    }
}
