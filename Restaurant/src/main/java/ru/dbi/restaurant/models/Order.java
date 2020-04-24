package ru.dbi.restaurant.models;

public class Order {

    private long id;
    private Client client;
    private  Cook cook;
    private Waiter waiter;

    public long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Cook getCook() {
        return cook;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public String toString() {
        return "Order id: " + this.id + '\n' +
                client.toString() +
                '\n' + cook.toString() +
                '\n' + waiter.toString();
    }
}
