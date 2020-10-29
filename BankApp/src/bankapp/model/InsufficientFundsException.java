/*
Bank Application by Ritvik Kumar K 
IST 261 
Latest Update 10/29/20
 */

package bankapp.model;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("You have insufficient funds to complete the transaction.");
    }
    
}
