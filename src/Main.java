import Controller.AccountController;
import Controller.CustomerController;
import Controller.StaffController;
import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Staff;
import Service.AccountService;
import Service.CustomerService;
import Service.StaffService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<Customer>();
        List<Staff> staffs = new ArrayList<Staff>();
        List<Account> accounts = new ArrayList<Account>();
        CustomerService cs = new CustomerService(customers);
        StaffService sv = new StaffService(staffs);
        AccountService as = new AccountService(accounts);
        CustomerController csController = new CustomerController(cs);
        StaffController stController = new StaffController(sv);
        AccountController acController = new AccountController(as);
        customers.add(new Customer(1,"CS001","Duc", Gender.M));
        customers.add(new Customer(2,"CS002","Hoa", Gender.F));
        staffs.add(new Staff(1,"ST001","Nguyen Ngoc Duc", LocalDate.of(2001,3,23)));
        staffs.add(new Staff(2,"ST002","Nguyen Duy Duc", LocalDate.of(1994,4,10)));
        accounts.add(new Account(1,"012345",customers.get(0),1000,LocalDate.of(2024,9,10)));
        accounts.add(new Account(2,"043243",customers.get(1),1500,LocalDate.of(2024,10,5)));
        accounts.add(new Account(2,"432423",customers.get(1),2000000,LocalDate.of(2024,10,21)));
        Customer cus1 = csController.getById(1);
        List<Staff> foundStaffs = stController.getByName("Duy");
        List<Account> foundCusNameAccounts = acController.getAccountByCustomerName("Duc");
        List<Account> foundAccountByCustomerGender = acController.getAccountByCustomer(Gender.M,1000000);
        long countAccounts = acController.countAccountByCustomer(Gender.F,100000);
        Account maxBalanceAccount = acController.getMaxBalance(Gender.F);
        if(cus1 != null) {
            System.out.println(cus1);
        }
        else {
            System.out.println("Customer not found");
        }
        if(foundStaffs != null) {
            System.out.println(foundStaffs);
        }
        else {
            System.out.println("Staff not found");
        }
        if(foundCusNameAccounts != null) {
            System.out.println(foundCusNameAccounts);
        }
        else {
            System.out.println("Account Not Found");
        }
        if(foundAccountByCustomerGender != null) {
            System.out.println(foundAccountByCustomerGender);
        }
        else {
            System.out.println("Account Not Found");
        }
        if(countAccounts > 0){
            System.out.println("Count Accounts : " + countAccounts);
        }
        else {
            System.out.println("Account Not Found");
        }
        if(maxBalanceAccount != null) {
            System.out.println(maxBalanceAccount);
        }
        else {
            System.out.println("Account Not Found");
        }
    }
}