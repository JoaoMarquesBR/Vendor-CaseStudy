INSERT INTO Vendor (Address1,City,Province,PostalCode,Phone,Type,Name,Email)VALUES ('123 Maple
St','London','On', 'N1N-1N1','(555)555-5555','Trusted','ABC Supply Co.','abc@supply.com');
INSERT INTO Vendor (Address1,City,Province,PostalCode,Phone,Type,Name,Email) VALUES ('543
Sycamore Ave','Toronto','On', 'N1P-1N1','(999)555-5555','Trusted','Big Bills
Depot','bb@depot.com');
INSERT INTO Vendor (Address1,City,Province,PostalCode,Phone,Type,Name,Email) VALUES ('922 Oak
St','London','On', 'N1N-1N1','(555)555-5599','Untrusted','Shady Sams','ss@underthetable.com');
INSERT INTO Vendor (Address1,City,Province,PostalCode,Phone,Type,Name,Email) VALUES ('110 oxford',
'London','On', 'N6H-1R9','(555)555-1312','  Untrusted','Joao Marques','jmarques@dev.com');
INSERT INTO Vendor (Address1,City,Province,PostalCode,Phone,Type,Name,Email) VALUES ('123 Oak Ave',
'London','Ontario', 'N1N-1N1','(555)555-5551','Trusted','Case One','case1@here.com');
--inserting products
INSERT INTO Product (id, vendorid, name, costprice, msrp, rop, eoq, qoh, qoo, qrcode, qrcodetxt)
VALUES ('P1', 1, 'Gadgets', 15.99, 159.99, 40, 13, 13, 10, 'G12345', 'QR Code for Gadgets');
INSERT INTO Product (id, vendorid, name, costprice, msrp, rop, eoq, qoh, qoo, qrcode, qrcodetxt)
VALUES ('P2', 2, 'Hammers', 9.99, 359.99, 15, 5, 5, 5, 'H67890', 'QR Code for Hammers');
INSERT INTO Product (id, vendorid, name, costprice, msrp, rop, eoq, qoh, qoo, qrcode, qrcodetxt)
VALUES ('P3', 1, 'Screwdrivers', 8.49, 14.99, 8, 40, 90, 10, 'S54321', 'QR Code for Screwdrivers');
INSERT INTO Product (id, vendorid, name, costprice, msrp, rop, eoq, qoh, qoo, qrcode, qrcodetxt)
VALUES ('P4', 3, 'Power Drills', 39.99, 79.99, 15, 25, 50, 5, 'PD24680', 'QR Code for Power Drills');
INSERT INTO Product (id, vendorid, name, costprice, msrp, rop, eoq, qoh, qoo, qrcode, qrcodetxt)
VALUES ('P5', 4, 'Pliers', 6.99, 12.99, 6, 35, 70, 8, 'PL98765', 'QR Code for Pliers');
INSERT INTO Product (id, vendorid, name, costprice, msrp, rop, eoq, qoh, qoo, qrcode, qrcodetxt)
VALUES ('C1001', 5, 'Super Widget', 122.99, 109.99, 10, 8, 15, 0, 'PL98765', 'QR Code for Pliers');
INSERT INTO Product (id, vendorid, name, costprice, msrp, rop, eoq, qoh, qoo, qrcode, qrcodetxt)
VALUES ('C1002', 5, 'POS Widget', 22.99, 19.99, 10, 10, 15, 0, 'PL98765', 'QR Code for Pliers');
