import javax.swing.*;
import java.awt.event.*;

public class TotalPriceExample extends JFrame {
    private JLabel bot; // variable name changed to 'bot'
    private JButton btnCalculate;

    public TotalPriceExample() {
        // Set up frame
        setTitle("Total Price Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Initialize label with the new variable name 'bot'
        bot = new JLabel("Total: ₱0.00");
        bot.setBounds(50, 50, 150, 30);
        add(bot);

        // Initialize button
        btnCalculate = new JButton("Calculate Total");
        btnCalculate.setBounds(50, 100, 150, 30);
        add(btnCalculate);

        // Add action listener to button
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTotalPrice();
            }
        });
    }

    private void updateTotalPrice() {
        double subtotal = 100.00; // Example subtotal
        double tax = subtotal * 0.12; // 12% tax
        double total = subtotal + tax;

        // Update label text
        bot.setText(String.format("₱%.2f", total));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TotalPriceExample().setVisible(true);
        });
    }
}