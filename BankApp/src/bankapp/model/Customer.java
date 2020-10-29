/*
Bank Application by Ritvik Kumar K 
IST 261 
Latest Update 10/29/20
 */

package bankapp.model;

import java.io.Serializable;


public class Customer  implements Serializable{
    private final String firstName;
    private final String lastName;
    private final String ssn;
    private final Account account;

    public Customer(String firstName, String lastName, String ssn, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.account = account;
    }
    
    @Override
    public String toString(){
        return "\nCustomer Information\n" +
                "First Name: " + getFirstName() + "\n" + 
                "Last Name: " + getLastName() +  "\n" + 
                "SSN: " + getSsn() +  "\n" + 
                account;
    }
    
    public String basicInfo(){
        return " Account Number: " + account.getAccountNumber() + " - Name: " + getFirstName() + " " + getLastName();
    }
    
    public Account getAccount(){
        return account;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the ssn
     */
    public String getSsn() {
        return ssn;
    }
    
}
