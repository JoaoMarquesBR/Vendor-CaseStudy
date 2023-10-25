package com.jmarques.CASESTUDY.Services;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.jmarques.CASESTUDY.Entities.Product;
import com.jmarques.CASESTUDY.Entities.PurchaseOrder;
import com.jmarques.CASESTUDY.Entities.PurchaseOrderLineitem;
import com.jmarques.CASESTUDY.Entities.Vendor;
import com.jmarques.CASESTUDY.Repositories.ProductRepository;
import com.jmarques.CASESTUDY.Repositories.PurchaseOrderRepository;
import com.jmarques.CASESTUDY.Repositories.VendorRepository;
import org.hibernate.generator.Generator;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ReportPDFGenerator extends AbstractPdfView {

    public static ByteArrayInputStream generateReport(String repid, PurchaseOrderRepository reportRepository,
                                                      VendorRepository employeeRepository, ProductRepository expenseRepository) throws IOException {
        PurchaseOrder report = new PurchaseOrder();
        URL imageUrl = Generator.class.getResource("/static/images/Expenses.png");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        // Initialize PDF document to be written to a stream not a file
        PdfDocument pdf = new PdfDocument(writer);

        // Document is the main object
        Document document = new Document(pdf);

//        //Add font
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
//        // add the image to the document
        PageSize pg = PageSize.A4;
        Image img = new Image(ImageDataFactory.create(imageUrl)).scaleAbsolute(120, 40)
                .setFixedPosition(pg.getWidth() / 2 - 60, 750);

//
//        //add img to document
        document.add(img);
//        // now let's add a big heading
        document.add(new Paragraph("\n\n"));
        Locale locale = Locale.of("en", "US");

        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);

        document.add(new Paragraph("\n\n"));

        try {


            document.add(new Paragraph("\n"));
            Optional<PurchaseOrder> reportOption = reportRepository.findById(Long.parseLong(repid));
            document.add(new Paragraph("Report# " + repid).setFont(font).setFontSize(18).setBold()
                    .setMarginRight(pg.getWidth() / 2 - 75).setMarginTop(-10)
                    .setTextAlignment(TextAlignment.RIGHT));


            document.add(new Paragraph("\n\n"));

            Table vendorTable = new Table(2).setWidth(new UnitValue(UnitValue.PERCENT, 30))
                    .setBorder(Border.NO_BORDER)
                    .setHorizontalAlignment(HorizontalAlignment.LEFT);

            Optional<Vendor> vendor =  employeeRepository.findById(reportOption.get().getVendorid());
            Cell vendorCell = new Cell().add(new Paragraph("Vendor")
                            .setFont(font)
                            .setFontSize(12)
                            .setBackgroundColor(ColorConstants.GRAY)
                            .setBorder(Border.NO_BORDER)
                            .setBold())
                    .setTextAlignment(TextAlignment.CENTER);
            vendorTable.addCell(vendorCell);

            vendorCell = new Cell().add(new Paragraph(vendor.get().getName())
                            .setFont(font)
                            .setFontSize(12)
                             .setBorder(Border.NO_BORDER)
                            .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY));

            vendorTable.addCell(vendorCell);

            vendorTable.addCell(
                    new Cell().add(new Paragraph(" ")
                            .setBorder(Border.NO_BORDER)
                    ));  // Create empty cells


            vendorCell = new Cell().add(new Paragraph(vendor.get().getAddress1())
                            .setFont(font)
                            .setFontSize(12)
                            .setBorder(Border.NO_BORDER)
                            .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY));

            vendorTable.addCell(vendorCell);

            vendorTable.addCell(
                    new Cell().add(new Paragraph(" ")
                            .setBorder(Border.NO_BORDER)
                    ));  // Create empty cells


            vendorCell = new Cell().add(new Paragraph(vendor.get().getCity())
                            .setFont(font)
                            .setBorder(Border.NO_BORDER)
                            .setFontSize(12)
                            .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY));

            vendorTable.addCell(vendorCell);

            vendorTable.addCell(
                    new Cell().add(new Paragraph(" ")
                            .setBorder(Border.NO_BORDER)
                    ));  // Create empty cells


            vendorCell = new Cell().add(new Paragraph(vendor.get().getProvince())
                            .setFont(font)
                            .setFontSize(12)
                            .setBorder(Border.NO_BORDER)
                            .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY));

            vendorTable.addCell(vendorCell);

            vendorTable.addCell(
                    new Cell().add(new Paragraph(" ")
                            .setBorder(Border.NO_BORDER)
                    ));  // Create empty cells


            vendorCell = new Cell().add(new Paragraph(vendor.get().getEmail())
                            .setFont(font)
                            .setFontSize(12)
                            .setBorder(Border.NO_BORDER)
                            .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY));

            vendorTable.addCell(vendorCell);

            document.add(vendorTable);

            document.add(new Paragraph("\n\n"));


            Table table = new Table(5);

            Cell cell = new Cell().add(new Paragraph("Product Code")
                            .setFont(font)
                            .setFontSize(12)
                            .setBold())
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);

            cell = new Cell().add(new Paragraph("Description")
                            .setFont(font)
                            .setFontSize(12)
                            .setBold())
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);

            cell = new Cell().add(new Paragraph("Qty Sold")
                            .setFont(font)
                            .setFontSize(12)
                            .setBold())
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);

            cell = new Cell().add(new Paragraph("Price")
                            .setFont(font)
                            .setFontSize(12)
                            .setBold())
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);

            cell = new Cell().add(new Paragraph("Ext. Price")
                            .setFont(font)
                            .setFontSize(12)
                            .setBold())
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);

            table.setWidth(new UnitValue(UnitValue.PERCENT, 100));



            Optional<PurchaseOrder> opt = reportRepository.findById(Long.parseLong(repid));
            if (opt.isPresent()) {
                report = opt.get();
            }

            BigDecimal tot = new BigDecimal(0.0);
            for (PurchaseOrderLineitem line : report.getItems()) {
                Optional<Product> optx = expenseRepository.findById(line.getProductid()); //should be PRODUCT ID?
                if (optx.isPresent()) {
                    Product expense = optx.get();
                    tot = tot.add(expense.getMsrp(), new MathContext(8, RoundingMode.UP));

                    //product code
                    cell = new Cell().add(new Paragraph(String.valueOf(expense.getId()))
                            .setFont(font)
                            .setFontSize(12)
                            .setTextAlignment(TextAlignment.CENTER));
                    table.addCell(cell);

                    //product name(description)
                    cell = new Cell().add(new Paragraph(optx.get().getName())
                            .setFont(font)
                            .setFontSize(12)
                            .setTextAlignment(TextAlignment.CENTER));
                    table.addCell(cell);

                    //qty sold
                    cell = new Cell().add(new Paragraph(String.valueOf(line.getQty()))
                            .setFont(font)
                            .setFontSize(12)
                            .setTextAlignment(TextAlignment.CENTER));
                    table.addCell(cell);

                    //price
                    cell = new Cell().add(new Paragraph("$"+optx.get().getMsrp().toString())
                            .setFont(font)
                            .setFontSize(12)
                            .setTextAlignment(TextAlignment.CENTER));
                    table.addCell(cell);

                    //ext price
                    cell = new Cell().add(new Paragraph("$"+line.getPrice().toString())
                            .setFont(font)
                            .setFontSize(12)
                            .setTextAlignment(TextAlignment.CENTER));
                    table.addCell(cell);

                }


            }

            for (int i = 0; i < 3; i++) {
                table.addCell(new Cell().add(new Paragraph(" ")));  // Create empty cells
            }
            cell = new Cell().add(new Paragraph("Sub Total:")
                    .setFont(font)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.RIGHT));
            table.addCell(cell);

            cell = new Cell().add(new Paragraph(formatter.format(tot))
                    .setFont(font)
                    .setFontSize(12)
                    .setBold()
                    .setBackgroundColor(ColorConstants.YELLOW)
                    .setTextAlignment(TextAlignment.CENTER));
            table.addCell(cell);

            for (int i = 0; i < 3; i++) {
                table.addCell(new Cell().add(new Paragraph(" ")));  // Create empty cells
            }

            cell = new Cell().add(new Paragraph("Tax:")
                    .setFont(font)
                    .setFontSize(12)
                    .setBold()
                    .setBackgroundColor(ColorConstants.YELLOW)
                    .setTextAlignment(TextAlignment.RIGHT));
            table.addCell(cell);

            cell = new Cell().add(new Paragraph(formatter.format(tot.multiply(new BigDecimal(0.13))))
                    .setFont(font)
                    .setFontSize(12)
                    .setBold()
                    .setBackgroundColor(ColorConstants.YELLOW)
                    .setTextAlignment(TextAlignment.CENTER));
            table.addCell(cell);


            for (int i = 0; i < 3; i++) {
                table.addCell(new Cell().add(new Paragraph(" ")));  // Create empty cells
            }

            cell = new Cell().add(new Paragraph("PO Total:")
                    .setFont(font)
                    .setFontSize(12)
                    .setBold()
                    .setBackgroundColor(ColorConstants.YELLOW)
                    .setTextAlignment(TextAlignment.RIGHT));
            table.addCell(cell);

            cell = new Cell().add(new Paragraph(formatter.format( tot.multiply(new BigDecimal(0.13)).add(tot))   ))
                    .setFont(font)
                    .setFontSize(12)
                    .setBold()
                    .setBackgroundColor(ColorConstants.YELLOW)
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);


            document.add(table);

            document.add(new Paragraph("\n\n"));
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a");
            document.add(new Paragraph(dateFormatter.format(LocalDateTime.now()))
                    .setTextAlignment(TextAlignment.CENTER));
            document.close();
        } catch (Exception e) {
            System.out.println("pdf error " + e.getMessage());
        }

        return new ByteArrayInputStream(baos.toByteArray());
    }

}



