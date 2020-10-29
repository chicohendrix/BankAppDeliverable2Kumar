/*
Bank Application by Ritvik Kumar K 
IST 261 
Latest Update 10/29/20
 */

package bankapp.model;


public class Checking extends Account{
    private static final String accountType = "Checking";
    
    public Checking(double initialDeposit){
        this.setBalance(initialDeposit);
        this.checkInterest(0);
        this.setTransactionFee(5);
    }
    
    @Override
    public String toString(){
        return "Account Type: " + accountType + " Account\n" +
                "Account Number: " + this.getAccountNumber() + "\n" +
                "Balance: " + this.getBalance() + "\n" + 
                "Interest Rate: " + (this.getInterest() * 100) + "%\n";
    }

    @Override
    public String getAccountType() {
        return accountType;
    }
}
