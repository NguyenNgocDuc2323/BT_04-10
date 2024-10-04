package Service;

import Entity.Customer;
import Global.Global;
import IGeneric.IGeneral;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService implements IGeneral<Customer> {
    private List<Customer> customers;
    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }
    @Override
    public Customer getById(int id) {
        Optional<Customer> customer = customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        if(customer.isPresent()){
            return customer.get();
        }
        else{
            return null;
        }
    }

    @Override
    public Customer getByCode(String code) {
        Optional<Customer> customer = customers.stream()
                .filter(c -> Global.ignoreCase(code,c.getCode()))
                .findFirst();
        if(customer.isPresent()){
            return customer.get();
        }
        else{
            return null;
        }
    }

    @Override
    public List<Customer> getByName(String keyword) {
        List<Customer> lstCus = customers.stream()
                .filter(c -> Global.ignoreCase(keyword,c.getName()))
                .toList();
        if(lstCus.isEmpty()){
            return new ArrayList<>();
        }
        else{
            return lstCus;
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
