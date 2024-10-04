package Controller;

import Entity.Account;
import Entity.Gender;
import Service.AccountService;

import java.util.List;
import java.util.Optional;

public class AccountController {
    private List<Account> accounts;
    private AccountService as;
    public AccountController(AccountService as) {
        this.as = as;
        this.accounts = as.getAccounts();
    }
    public Account getAccountByCustomerCode(String code) {
        Account account = as.getAccountByCustomerCode(code);
        if(account == null) {
            return null;
        }
        return account;
    }
    public List<Account> getAccountByCustomerName(String keyword) {
        List<Account> accounts = as.getAccountByCustomerName(keyword);
        if(accounts == null) {
            return null;
        }
        return accounts;
    }
    public List<Account> getAccountByCustomer(Gender gender,double balance) {
        List<Account> accounts = as.getAccountByCustomer(gender,balance);
        if(accounts == null) {
            return null;
        }
        return accounts;
    }
    public long countAccountByCustomer(Gender gender,double balance) {
        long countAccount = as.countAccountByCustomer(gender,balance);
        if(countAccount > 0) {
            return countAccount;
        }
        return 0;
    }
    public Account getMaxBalance(Gender gender) {
        Optional<Account> maxBalance = as.getMaxBalance(gender);
        if(maxBalance.isPresent()) {
            return maxBalance.get();
        }
        return null;
    }
}
