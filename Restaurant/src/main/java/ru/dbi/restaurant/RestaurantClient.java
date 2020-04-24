package ru.dbi.restaurant;

import ru.dbi.restaurant.models.*;

import java.util.Arrays;

public class RestaurantClient {

    public static void main(String[] args) throws Exception{

        Client client = new Client();
        client.setId("ClId23");
        client.setFirstName("Ivan");
        client.setLastName("Ivanov");
        client.setPhoneNumber("+79198874532");
//CRUD only for Client
//        Cook cook = new Cook();
//        cook.setFirstName("Ivan");
//        cook.setLastName("Ivanov");
//        cook.setSkillLevel(3);
//
//        Waiter waiter = new Waiter();
//        waiter.setFirstName("Anton");
//        waiter.setLastName("Antonov");
//        waiter.setTips(5.25);
//
//        Order order = new Order();
//        order.setId(23);
//        order.setClient(client);
//        order.setCook(cook);
//        order.setWaiter(waiter);
//
//        System.out.println(order);

//////CRUD for Client/////////
//        client.createClient();
//        client.readClient("ClId12");
//        client.updateClient("ClId12", "First name", "Ivan");
//        client.readClient("ClId12");
//        client.deleteClient("ClId12");
    }
}
