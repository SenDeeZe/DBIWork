package ru.dbi.restaurant.models;

public class Waiter {

    private String firstName;
    private String lastName;
    private double tips;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getTips() {
        return tips;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTips(double tips) {
        this.tips = tips;
    }

    @Override
    public String toString() {
        return "Waiter:" + '\n' + "Full name: " + this.firstName + " " + this.lastName +
                '\n' + "Tips: " + this.tips;
    }
}
