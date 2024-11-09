package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        
        JTextField tfNumber1 = new JTextField();
        tfNumber1.setBounds(50, 20, 200, 30);
        frame.add(tfNumber1);

        JTextField tfNumber2 = new JTextField();
        tfNumber2.setBounds(50, 60, 200, 30);
        frame.add(tfNumber2);

        JComboBox<String> cbOperations = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        cbOperations.setBounds(50, 100, 200, 30);
        frame.add(cbOperations);

        JButton btnCompute = new JButton("Compute");
        btnCompute.setBounds(50, 140, 200, 30);
        frame.add(btnCompute);

        JLabel lblResult = new JLabel("Result: ");
        lblResult.setBounds(50, 180, 200, 30);
        frame.add(lblResult);

        
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    double num1 = Double.parseDouble(tfNumber1.getText());
                    double num2 = Double.parseDouble(tfNumber2.getText());
                    String operator = (String) cbOperations.getSelectedItem();
                    double result = 0;

                    
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                JOptionPane.showMessageDialog(frame, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            break;
                    }

                    
                    lblResult.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        frame.setVisible(true);
    }
}
