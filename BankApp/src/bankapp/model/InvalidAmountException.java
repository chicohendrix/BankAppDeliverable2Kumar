/*
Bank Application by Ritvik Kumar K 
IST 261 
Latest Update 10/29/20
 */

package bankapp.model;

public class InvalidAmountException extends Exception {

    public InvalidAmountException() {
        super("Invalid amount for transaction.");
    }
    
}
