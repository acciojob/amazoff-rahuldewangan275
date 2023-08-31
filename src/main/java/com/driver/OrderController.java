package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/add-order")
    public ResponseEntity addOrder( @RequestBody  Order order){
         orderService.addOrder(order);
         return new ResponseEntity<>("order added successfully", HttpStatus.OK);
    }
    @PostMapping("/add-partner")
    public ResponseEntity addPartner(@RequestBody DeliveryPartner deliveryPartner){
         orderService.addPartner(deliveryPartner);
         return new ResponseEntity<>("Delivery Partner added successfully", HttpStatus.OK);
    }
    @PutMapping("/add-order-partner-pair")
    public ResponseEntity addOrderPartnerPair(@RequestParam("orderId") String orderId,@RequestParam("partnerId") String partnerId){
        orderService.addOrderPartnerPair(orderId,partnerId);
        return new ResponseEntity<>("Order is alloted to Partner Successfully", HttpStatus.CREATED);

    }

    @GetMapping("/get-order-by-id/{OrderId}")
    public  ResponseEntity getOrderById(@PathVariable("OrderId") String orderId){
        Order response = null;
        response = orderService.getOrderById(orderId);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping("/get-partner-by-id/{partnerId}")
    public  ResponseEntity getPartnerById(@PathVariable("partnerId") String partnerId){
        DeliveryPartner response = null;
        response = orderService.getPartnerById(partnerId);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @GetMapping("/get-order-count-by-partner-id/{partnerId}")
    public  ResponseEntity getOrderCountByPartnerId(@PathVariable("partnerId") String partnerId){
int response = orderService.getOrderCountByPartnerId(partnerId);
return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @GetMapping("/get-orders-by-partner-id/{partnerId}")
    public  ResponseEntity getOrdersByPartnerId(@PathVariable("partnerId") String partnerId){
    List<Order> response = orderService.getOrdersByPartnerId(partnerId);
    return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/get-all-orders")
    public  ResponseEntity getAllOrders(){
        List<Order> response = orderService.getAllOrders();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/get-count-of-unassigned-orders")
    public  ResponseEntity getCountOfUnassignedOrders(){
        int response = orderService. getCountOfUnassignedOrders();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/get-count-of-orders-left-after-given-time/{time}/{partnerId}")
    public  ResponseEntity getOrdersLeftAfterGivenTimeByPartnerId(@PathVariable("time") String time,@PathVariable("partnerId")String partnerId){
        int response = orderService.getOrdersLeftAfterGivenTimeByPartnerId(time,partnerId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/get-last-delivery-time/{partnerId}")
    public  ResponseEntity  getLastDeliveryTimeByPartnerId(@PathVariable("partnerId") String partnerId){
        String response = orderService.getLastDeliveryTimeByPartnerId(partnerId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/delete-partner-by-id/{partnerId}")
    public  ResponseEntity deletePartnerById(@PathVariable("partnerId") String partnerId){
         orderService.deletePartnerById(partnerId);
        return new ResponseEntity<>("Partner deleted successfully",HttpStatus.OK);
    }

    @DeleteMapping("/delete-order-by-id/{orderId}")
    public  ResponseEntity deleteOrderById(@PathVariable("orderId") String orderId){
        orderService.deleteOrderById(orderId);
        return new ResponseEntity<>("Order deleted successfully",HttpStatus.OK);
    }

}
