package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Leap Year Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(null);

        
        JTextField yearTextField = new JTextField();
        yearTextField.setName("yearTextField");
        yearTextField.setBounds(50, 20, 200, 30);
        frame.add(yearTextField);

        
        JButton checkYearButton = new JButton("Check Year");
        checkYearButton.setName("checkYearButton");
        checkYearButton.setBounds(50, 60, 200, 30);
        frame.add(checkYearButton);

        
        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = yearTextField.getText();
                try {
                    
                    int year = Integer.parseInt(input);
                    if (isLeapYear(year)) {
                        JOptionPane.showMessageDialog(frame, "Leap year", "Message", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Not a leap year", "Message", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    
                    JOptionPane.showMessageDialog(frame, "Please enter a valid year", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            
            private boolean isLeapYear(int year) {
                return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            }
        });

        
        frame.setVisible(true);
    }
}
