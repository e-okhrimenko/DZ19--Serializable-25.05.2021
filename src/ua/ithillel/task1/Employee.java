package ua.ithillel.task1;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String address;
    private transient int SSN;
    private int number;

    public Employee(int number, String name, int SSN, String address) {
        this.name = name;
        this.address = address;
        this.SSN = SSN;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Employee: "
                + "Number=" + number
                + ", Name='" + name
                + "', Address='" + address
                + "', SSN=" + SSN;
    }
}
