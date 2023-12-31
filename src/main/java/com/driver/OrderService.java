package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public void addPartner(DeliveryPartner deliveryPartner) {
         orderRepository.addPartner(deliveryPartner);
    }


    public Order getOrderById(String orderId) {
      return  orderRepository.getOrderById(orderId);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        orderRepository.addOrderPartnerPair(orderId,partnerId);
    }

    public DeliveryPartner getPartnerById(String partnerId) {
        return orderRepository.getPartnerById(partnerId);
    }

    public int getOrderCountByPartnerId(String partnerId) {
        return  orderRepository.getOrderCountByPartnerId(partnerId);
    }

    public List<Order> getOrdersByPartnerId(String partnerId) {
        return  orderRepository.getOrdersByPartnerId(partnerId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public int getCountOfUnassignedOrders() {
        return  orderRepository.getCountOfUnassignedOrders();
    }

    public int getOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId) {
        return  orderRepository.getOrdersLeftAfterGivenTimeByPartnerI(time,partnerId);
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        return  orderRepository.getLastDeliveryTimeByPartnerId(partnerId);
    }

    public void deletePartnerById(String partnerId) {
          orderRepository.deletePartnerById(partnerId);
    }

    public void deleteOrderById(String orderId) {
          orderRepository.deleteOrderById(orderId);
    }
}
