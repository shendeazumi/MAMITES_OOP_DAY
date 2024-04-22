import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {

    private final JTextField displayField;
    private final JButton[] numberButtons;
    private final JButton[] operationButtons;
    private final JButton clearButton;
    private final JButton equalsButton;
    private final JPanel panel;

    private double num1, num2, result;
    private String operator;

    public CalculatorGUI() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayField = new JTextField(10);
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);

        numberButtons = new JButton[10];
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        operationButtons = new JButton[4];
        String[] operations = {"+", "-", "*", "/"};
        for (int i = 0; i < operationButtons.length; i++) {
            operationButtons[i] = new JButton(operations[i]);
            operationButtons[i].addActionListener(this);
        }

        clearButton = new JButton("C");
        clearButton.addActionListener(this);

        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        panel.add(clearButton);
        panel.add(displayField);
        panel.add(equalsButton);

        for (JButton button : numberButtons) {
            panel.add(button);
        }

        for (JButton button : operationButtons) {
            panel.add(button);
        }

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numberButtons.length; i++) {
            if (e.getSource() == numberButtons[i]) {
                displayField.setText(displayField.getText() + i);
            }
        }

        if (e.getSource() == clearButton) {
            displayField.setText("");
        }

        if (e.getSource() == operationButtons[0]) {
            num1 = Double.parseDouble(displayField.getText());
            operator = "+";
            displayField.setText("");
        }

        if (e.getSource() == operationButtons[1]) {
            num1 = Double.parseDouble(displayField.getText());
            operator = "-";
            displayField.setText("");
        }

        if (e.getSource() == operationButtons[2]) {
            num1 = Double.parseDouble(displayField.getText());
            operator = "*";
            displayField.setText("");
        }

        if (e.getSource() == operationButtons[3]) {
            num1 = Double.parseDouble(displayField.getText());
            operator = "/";
            displayField.setText("");
        }

        if (e.getSource() == equalsButton) {
            num2 = Double.parseDouble(displayField.getText());

            switch (operator) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> {
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        displayField.setText("Error");
                        return;
                    }
                }
            }

            displayField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
    }
}