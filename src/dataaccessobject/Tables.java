/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccessobject;

import javax.swing.JOptionPane;

/**
 *
 * @author chloeglynn
 */
public class Tables {
    //add tables to database
    public static void main(String[] args){
       try{
           String userTable = "create table user(id int AUTO_INCREMENT primary key, name varchar(200), email varchar(200), mobileNumber varchar(10), password varchar(200), securityQuestion varchar(200), answer varchar(200), status varchar(20), UNIQUE (email))";
           String adminDetails = "insert into user (name,email,mobileNumber,password,securityQuestion,answer,status) values('admin','admin@gmail.com','1234567890','admin','what is the name of your primary school?','corbon','true')";
           String categoryTable = "create table category(id int AUTO_INCREMENT primary key, name varchar(200))";
           String productTable = "create table product(id int AUTO_INCREMENT primary key, name varchar(200),category varchar(200), price varchar(200))";
           String billTable = "create table bill(id int primary key, name varchar(200), mobileNumber varchar(200), email varchar(200), date varchar(50), total varchar(200), createdBy varchar(200))";
           DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
           DbOperations.setDataOrDelete(adminDetails, "Admin Details Added Successfully");
           DbOperations.setDataOrDelete(categoryTable, "Category Table Created Successfully");
           DbOperations.setDataOrDelete(productTable, "Product Table Created Successfully");
           DbOperations.setDataOrDelete(billTable, "Bill Table Created Successfully");
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
    }
}
