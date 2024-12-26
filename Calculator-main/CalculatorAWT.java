import java.awt.*;
import java.awt.event.*;

public class CalculatorAWT extends Frame implements ActionListener {
    // Components
    private TextField input1, input2, result;
    private Button addBtn, subBtn, mulBtn, divBtn, clrBtn;
    private Label label1, label2, label3;

    // Constructor to set up the UI
    public CalculatorAWT() {
        // Set up the frame
        setTitle("AWT Calculator");
        setSize(400, 250);
        setLayout(new FlowLayout());
        setResizable(false);

        // Initialize Labels
        label1 = new Label("Enter first number: ");
        label2 = new Label("Enter second number: ");
        label3 = new Label("Result: ");

        // Initialize TextFields
        input1 = new TextField(10);
        input2 = new TextField(10);
        result = new TextField(15);
        result.setEditable(false);  // Make result field non-editable

        // Initialize Buttons
        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");
        clrBtn = new Button("Clear");

        // Add action listeners to buttons
        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);
        clrBtn.addActionListener(this);

        // Add components to the frame
        add(label1);
        add(input1);
        add(label2);
        add(input2);
        add(label3);
        add(result);
        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);
        add(clrBtn);

        // Add window listener for closing the window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        
        setVisible(true);  // Make frame visible
    }

    // Action listener method
    @Override
    public void actionPerformed(ActionEvent e) {
        String num1Text = input1.getText();
        String num2Text = input2.getText();

        try {
            // Parse inputs as doubles
            double num1 = Double.parseDouble(num1Text);
            double num2 = Double.parseDouble(num2Text);

            // Perform calculation based on the button pressed
            if (e.getSource() == addBtn) {
                result.setText(String.valueOf(num1 + num2));
            } else if (e.getSource() == subBtn) {
                result.setText(String.valueOf(num1 - num2));
            } else if (e.getSource() == mulBtn) {
                result.setText(String.valueOf(num1 * num2));
            } else if (e.getSource() == divBtn) {
                // Check for division by zero
                if (num2 != 0) {
                    result.setText(String.valueOf(num1 / num2));
                } else {
                    result.setText("Cannot divide by zero");
                }
            } else if (e.getSource() == clrBtn) {
                // Clear inputs and result fields
                input1.setText("");
                input2.setText("");
                result.setText("");
            }
        } catch (NumberFormatException ex) {
            result.setText("Invalid input");  // Handle invalid number format
        }
    }

    // Main method to run the calculator
    public static void main(String[] args) {
        new CalculatorAWT();
    }
}
