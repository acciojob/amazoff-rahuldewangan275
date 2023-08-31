package com.driver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Slf4j
@Repository
public class OrderRepository {
    HashMap<String,Order> onlyOrders = new HashMap<>();
    HashMap<String,DeliveryPartner> onlyDeliveryPartners = new HashMap<>();
    HashMap<String, List<Order>> partnerId_Orders = new HashMap<>();
    HashMap<String,String> order_Partner = new HashMap<>();


    public void addOrder(Order order) {
onlyOrders.put(order.getId(),order);

    }

    public void addPartner(DeliveryPartner deliveryPartner) {
onlyDeliveryPartners.put(deliveryPartner.getId(),deliveryPartner); // only delivery-partner
List<Order> list = new ArrayList<>();
if(partnerId_Orders.containsKey(deliveryPartner.getId())){
    list = partnerId_Orders.get(deliveryPartner.getId());
}
partnerId_Orders.put(deliveryPartner.getId(),list);
    }


    public Order getOrderById(String orderId) {
        return onlyOrders.get(orderId);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        if(onlyOrders.get(orderId) == null){
            return;
        }
        if(onlyDeliveryPartners.get(partnerId)==null){
            return;
        }
        order_Partner.put(orderId,partnerId);
        if(partnerId_Orders.get(partnerId)==null){
            partnerId_Orders.put(partnerId,new ArrayList<>());
        }
        partnerId_Orders.get(partnerId).add(onlyOrders.get(orderId));
    }
    public DeliveryPartner getPartnerById(String partnerId) {
        return onlyDeliveryPartners.get(partnerId);
    }
    public int getOrderCountByPartnerId(String partnerId) {
        return onlyOrders.size();
    }

    public List<Order> getOrdersByPartnerId(String partnerId) {
        List<Order> odr = new ArrayList<>();
        for(Order order : partnerId_Orders.get(partnerId)){
            odr.add(order);
        }
        return odr;
    }

    public List<Order> getAllOrders() {
        List<Order> odr = new ArrayList<>();
        for(String oId : onlyOrders.keySet()){
            odr.add(onlyOrders.get(oId));
        }
        return odr;
    }

    public int getCountOfUnassignedOrders() {
        int count=0;
        for(String oId : order_Partner.keySet()){
            String pId = order_Partner.get(oId);
            if(pId==null){
                count++;
            }
        }
        return count;
    }

    public int getOrdersLeftAfterGivenTimeByPartnerI(String time, String partnerId) {
    String t1=time.substring(0,2);
    String t2=time.substring(3);
    int givenTime = Integer.parseInt(t1)*60 + Integer.parseInt(t2);
    int count=0;
    for(Order order : partnerId_Orders.get(partnerId)){
        if(givenTime<order.getDeliveryTime()){
            count++;
        }
    }
    return count;
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
String lastTime="";
if(onlyDeliveryPartners.get(partnerId)==null){
    return "Partner not Found";
}
if(partnerId_Orders.get(partnerId)==null){
    return "No Orders Left";
}

int time =0;
for(Order order : partnerId_Orders.get(partnerId)){
    time = Math.max(time,order.getDeliveryTime());
}
int h = time/60;
int m = time%60;

String hh="";
String mm="";

if(h>=0 && h<=9){
    hh="0"+String.valueOf(h);
}else{
    hh=String.valueOf(h);
}

if(m>=0 && m<=9){
    mm="0"+String.valueOf(m);
}else{
    mm=String.valueOf(m);
}

lastTime = hh+":"+mm;
return lastTime;
    }

    // mighnt be need changes i s test cases not passed// i have another approach
    public void deletePartnerById(String partnerId) {
        onlyDeliveryPartners.remove(partnerId); // 1
        for(String oId : order_Partner.keySet()){ //2
            String pId = order_Partner.get(oId);
            if(pId.equals(partnerId)){
                order_Partner.put(oId,null);
            }
        }
        partnerId_Orders.remove(partnerId);

    }

    public void deleteOrderById(String orderId) {
String partnerId = order_Partner.get(orderId);
Order order = onlyOrders.get(orderId);
        onlyOrders.remove(orderId);//1
        order_Partner.remove(orderId);//2
        partnerId_Orders.get(partnerId).remove(order);
    }


}
