package Service;

import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Global.Global;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AccountService {
    private List<Account> accounts;
    public AccountService(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Account getAccountByCustomerCode(String code){
        Optional<Account> foundByCodeAccount = accounts.stream()
                .filter(account -> Global.ignoreCase(code,account.getCustomer().getCode()))
                .findFirst();
        if(foundByCodeAccount.isPresent()){
            return foundByCodeAccount.get();
        }
        return null;
    }
    public List<Account> getAccountByCustomerName(String keyword){
        List<Account> foundByNameAccount = accounts.stream()
                .filter(account -> Global.ignoreCase(keyword,account.getCustomer().getName()))
                .toList();
        if(foundByNameAccount.isEmpty()){
            return null;
        }
        return foundByNameAccount;
    }
    public List<Account> getAccountByCustomer(Gender gender,double balance) {
        List<Account> foundByGenderAccounts = accounts.stream()
                .filter(account -> account.getCustomer().getGender().equals(gender) && account.getBalance() > balance)
                .toList();
        if(foundByGenderAccounts.isEmpty()){
            return null;
        }
        return foundByGenderAccounts;
    }
    public long countAccountByCustomer(Gender gender,double balance) {
        return accounts.stream()
                .filter(account -> account.getCustomer().getGender().equals(gender) && account.getBalance() > balance)
                .count();
    }
    public Optional<Account> getMaxBalance(Gender gender) {
        Optional<Account> maxBalanceAccount = accounts.stream()
                .max(Comparator.comparing(Account::getBalance))
                .filter(account -> account.getCustomer().getGender().equals(gender));
        if(maxBalanceAccount.isPresent()){
            return maxBalanceAccount;
        }
        return Optional.empty();
    }
    public List<Account> getAccounts(){
        return accounts;
    }
}
