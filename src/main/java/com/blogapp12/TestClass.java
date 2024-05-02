package com.blogapp12;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        List<Employee> data = Arrays.asList(
                new Employee(1, "nilu",2500),
                new Employee(1, "chandan",6000),
                new Employee(1, "sanu",8000)
        );

        List<Employee> newData = data.stream().filter(e -> e.getSalary() > 5000).collect(Collectors.toList());

        for (Employee emp:newData){
            System.out.println(emp.getId());
            System.out.println(emp.getName());
            System.out.println(emp.getSalary());
        }
    }
}

