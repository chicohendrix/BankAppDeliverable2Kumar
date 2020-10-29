/*
Bank Application by Ritvik Kumar K 
IST 261 
Latest Update 10/29/20
 */

package bankapp.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


public class Bank implements Serializable{
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    
    public void addCustomer(Customer customer) {
        if(accountExists(customer.getAccount().getAccountNumber())){
            customer.getAccount().setAccountNumber(findValidAccountNumber());
        }
        customers.add(customer);
    }
    
    private int findValidAccountNumber(){
        int accountNumber;
        do {
            accountNumber = Account.getNextAccountNumber();
        } while(accountExists(accountNumber));      
        return accountNumber;
    }
    
    private boolean accountExists(int accountNumber){
        return customers.stream().anyMatch(c -> (c.getAccount().getAccountNumber() == accountNumber));
    }

    public Customer getCustomer(int account) {
        return customers.get(account);
    }
    
    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    public Customer getCustomerByAccountNumber(int accountNumber) {
        Customer customer = null;
        for(Customer c : customers){
            if(c.getAccount().getAccountNumber() == accountNumber){
                customer = c;
                break;
            }
        }
        return customer;
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }
    
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
}
