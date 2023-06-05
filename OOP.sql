CREATE DATABASE Sport_Commerce;
USE Sport_Commerce;

CREATE TABLE Product
(
  Product_ID INT NOT NULL UNIQUE AUTO_INCREMENT,
  Product_Name VARCHAR(30) NOT NULL,
  Price DOUBLE(10,2) NOT NULL,
    
  CONSTRAINT Product_Pk PRIMARY KEY (Product_ID)
);

CREATE TABLE Admin
(
  Admin_ID INT NOT NULL UNIQUE AUTO_INCREMENT,
  Admin_Name VARCHAR(30) NOT NULL,
  Product_ID INT NOT NULL UNIQUE,
  Admin_Password VARCHAR(30) NOT NULL,
  Admin_Username VARCHAR(30) NOT NULL,
    
  CONSTRAINT Admin_Pk PRIMARY KEY (Admin_ID),
  CONSTRAINT Admin_Product_Fk FOREIGN KEY (Product_ID) REFERENCES Product (Product_ID)
);

CREATE TABLE Customer
(
  Customer_ID INT NOT NULL UNIQUE AUTO_INCREMENT,
  Customer_Name VARCHAR(30) NOT NULL,
  Customer_IC VARCHAR(20) NOT NULL,
  Customer_Address VARCHAR(60) NOT NULL,
  Customer_Password VARCHAR(30) NOT NULL,
  Customer_Username VARCHAR(30) NOT NULL,
    
    CONSTRAINT Customer_Pk PRIMARY KEY (Customer_ID)
);

CREATE TABLE Payment
(
  Payment_ID INT NOT NULL UNIQUE AUTO_INCREMENT,
  Payment_Type VARCHAR(30) NOT NULL,
  Status VARCHAR(20) NOT NULL,
    
    CONSTRAINT Payment_Pk PRIMARY KEY (Payment_ID)
);

CREATE TABLE Orders
(
  Order_ID INT NOT NULL UNIQUE AUTO_INCREMENT,
  Payment_ID INT NOT NULL UNIQUE,
  Customer_ID INT NOT NULL UNIQUE,
  Total_Price double(10,2) NOT NULL,  
  Ship_Address VARCHAR(60) NOT NULL,
  ORDER_DATE DATE NOT NULL,
    
    CONSTRAINT Orders_Pk PRIMARY KEY (Order_ID),
    CONSTRAINT Orders_Payment_Fk FOREIGN KEY (Payment_ID) REFERENCES Payment (Payment_ID),
    CONSTRAINT Orders_Customer_Fk FOREIGN KEY (Customer_ID) REFERENCES Customer (Customer_ID)
);

CREATE TABLE Order_List
(
  List_ID INT NOT NULL UNIQUE AUTO_INCREMENT,
  Product_ID INT NOT NULL UNIQUE,
  Order_ID INT NOT NULL UNIQUE,
  Quantity INT(10) NOT NULL,
    
    CONSTRAINT List_Pk PRIMARY KEY (List_ID),
    CONSTRAINT List_Product_Fk FOREIGN KEY (Product_ID) REFERENCES Product (Product_ID),
    CONSTRAINT List_Order_Fk FOREIGN KEY (Order_ID) REFERENCES Orders (Order_ID)
);


	

