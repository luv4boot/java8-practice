package com.realtime.interviews.immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public final class Employee {

    private final int id;
    private final String name;
    private final Date date;
    private final List<String> mobile;
    private final Address address;

    public Employee(int id, String name, Date date, List<String> mobile, Address address) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.mobile = mobile;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return (Date) date.clone();
    }

    public List<String> getMobile() {
        return new ArrayList<>(mobile);
    }

    public Address getAddress() {
        return new Address(address.getCity(), address.getPincode());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", mobile=" + mobile +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args) {
        Address address = new Address("HYD", "500038");
        Employee employee = new Employee(1, "Madhav", new Date(), Arrays.stream(new String[]{"1234", "2345"}).collect(Collectors.toList()), address);
        employee.getDate().setDate(32);
        employee.getMobile().add("2678");
        employee.getAddress().setCity("PUNE");
        System.out.println(employee);
    }
}
