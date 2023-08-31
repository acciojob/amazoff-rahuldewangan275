package com.driver;

public class Order {

    private String id;
    private int deliveryTime;

    public Order(String id, String deliveryTime) {
         this.id=id;
        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
String a =deliveryTime.substring(0,2);
String b =deliveryTime.substring(3);
int x = Integer.parseInt(a)*60;
int y = Integer.parseInt(b);
this.deliveryTime=x+y;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return deliveryTime;}
}
