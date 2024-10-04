package Controller;

import Entity.Customer;
import Service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private  List<Customer> customers;
    private CustomerService cs;
    public CustomerController(CustomerService cs) {
        this.cs = cs;
        this.customers = cs.getCustomers();
    }
    public Customer getById(int id) {
        Customer customer = cs.getById(id);
        if(customer != null) {
            return customer;
        }
        return null;
    }
    public Customer getByCode(String code) {
        Customer customer = cs.getByCode(code);
        if(customer != null) {
            return customer;
        }
        return null;
    }
    public List<Customer> getCustomers(String name) {
        List<Customer> customers = cs.getByName(name);
        if(customers != null) {
            return customers;
        }
        return null;
    }
}
