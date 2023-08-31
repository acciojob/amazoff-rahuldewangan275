package com.driver.test;

import com.driver.Application;
import com.driver.DeliveryPartner;
import com.driver.OrderController;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = Application.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCases {
//    @Autowired
//    OrderController orderController;
//
//    public void prepare(){
//       orderController.addPartner(new DeliveryPartner("1"));
//       orderController.addPartner(new DeliveryPartner("2"));
//       orderController.addPartner(new DeliveryPartner("3"));
//    }
//    @Test
//    public void addPartnerTest(){
//        DeliveryPartner exp1 = new DeliveryPartner("1");
//        DeliveryPartner exp2 = new DeliveryPartner("2");
//
//        ResponseEntity out1 = orderController.getPartnerById("1");
//        ResponseEntity out2 = orderController.getPartnerById("2");
//
//



}