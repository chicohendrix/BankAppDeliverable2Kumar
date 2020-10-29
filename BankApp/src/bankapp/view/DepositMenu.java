/*
Bank Application by Ritvik Kumar K 
IST 261 
Latest Update 10/29/20
 */

package bankapp.view;


import bankapp.model.Bank;
import bankapp.model.Customer;
import bankapp.model.InvalidAmountException;
import javax.swing.JOptionPane;


public class DepositMenu extends javax.swing.JDialog {

    private final Customer customer;

    /**
     * Creates new form DepositMenu
     * @param parent
     * @param modal
     * @param customer
     */
    public DepositMenu(java.awt.Frame parent, boolean modal, Customer customer) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.customer = customer;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        amountLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        depositButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Deposit Menu");
        getContentPane().setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        amountLabel.setText("Deposit Amount:");
        getContentPane().add(amountLabel);
        getContentPane().add(amountField);

        depositButton.setText("Deposit");
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });
        getContentPane().add(depositButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositButtonActionPerformed
        StringBuilder warnings = new StringBuilder();
        //Verify the deposit is not empty
        if (amountField.getText().isEmpty()) {
            warnings.append("Deposit amount is required.\n");
        } else {
            double amount = 0;
            //Verify the deposit is a positive number
            try {
                amount = Bank.round(Double.parseDouble(amountField.getText()), 2);
                int result = JOptionPane.showConfirmDialog(this, "Deposit $" + String.format("%.2f", amount) + " to the account?\nInterest Earned: $" + String.format("%.2f", (customer.getAccount().getInterest() * amount)));
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        //Make the deposit
                        customer.getAccount().deposit(amount);
                        this.dispose();
                    } catch (InvalidAmountException ex) {
                        warnings.append("Deposit amount is invalid.\n");
                    }
                    
                }
            } catch (NumberFormatException ex) {
                warnings.append("Deposit must be a number.\n");
            }
        }
        if (warnings.length() > 0) {
            JOptionPane.showMessageDialog(this, warnings.toString(), "Deposit Warnings", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_depositButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton depositButton;
    // End of variables declaration//GEN-END:variables
}
