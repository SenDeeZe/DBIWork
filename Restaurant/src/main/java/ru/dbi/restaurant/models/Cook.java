package ru.dbi.restaurant.models;

public class Cook {

    private String firstName;
    private String lastName;
    private int skillLevel;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return "Cook:" + '\n' + "Full name: " + this.firstName + " " + this.lastName +
                '\n' + "Level of skill: " + this.skillLevel;
    }
}
