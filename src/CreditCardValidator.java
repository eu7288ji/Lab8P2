import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditCardValidator extends JFrame{
    private JPanel rootPane;
    private JTextField ccNumTextField;
    private JButton btnValidate;
    private JLabel resultLabel;
    private JButton quitButton;
    private JLabel enterCard;

    public CreditCardValidator() {

        super("Credit Card Validator");
        setContentPane(rootPane);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        btnValidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ccNum = ccNumTextField.getText();
                boolean valid = isVisaCCNumValid(ccNum);

                if (valid) {
                    resultLabel.setText("Credit Card is Valid");
                } else {
                    resultLabel.setText("Credit Card is Invalid");
                }
            }
        });


        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(CreditCardValidator.this,
                        "Are you sure you want to quit?", "Quit?",
                        JOptionPane.OK_CANCEL_OPTION);

                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

        private boolean isVisaCCNumValid(String cc) {

            if (!cc.startsWith("4")){
                return false;
            }
            if (cc.length() != 16){
                return false;
            }

            int sum = 0;

            for (int n = 0; n < 16; n++) {
                int thisDigit = Integer.parseInt((cc.substring(n, n + 1)));

                if (n % 2 == 1) {
                    sum = sum + thisDigit;
                } else {
                    int doubled = thisDigit * 2;
                    if (doubled > 9) {
                        int toAdd = 1 + (doubled % 10);
                        sum = sum + toAdd;
                    } else {
                        sum = sum + (thisDigit * 2);
                    }
                }
            }
            if (sum % 10 == 0){
                return true;
        }
        return false;

    }
}
