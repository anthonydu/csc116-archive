import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GUI application for RationalNumber
 *
 * @author Jessica Young Schmidt
 * @author Om Pandey and Anthony Du
 */
public class RationalNumberGUI extends JFrame implements ActionListener {

    /** Label for numerator 1 */
    private JLabel numerator1Label;

    /** Text field for numerator 1 */
    private JTextField numerator1Text;

    /** Label for denominator 1 */
    private JLabel denominator1Label;

    /** Text field for denominator 1 */
    private JTextField denominator1Text;

    /** Label for numerator 2 */
    private JLabel numerator2Label;

    /** Text field for numerator 2 */
    private JTextField numerator2Text;

    /** Label for denominator 2 */
    private JLabel denominator2Label;

    /** Text field for denominator 2 */
    private JTextField denominator2Text;

    /** Label for Answer */
    private JLabel ansLabel;

    /** Text field for Answer */
    private JTextField ansText;

    /** Button for Add */
    private JButton addButton;

    /** Button for Subtract */
    private JButton subtractButton;

    /** Button for Multiply */
    private JButton multiplyButton;

    /** Button for Divide */
    private JButton divideButton;

    /**
     * Default constructor
     */
    public RationalNumberGUI() {
        super("Rational Number GUI");
        setSize(500, 500);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a JPanel
        JPanel panel = new JPanel(new GridLayout(7, 2));
        // Add JPanel to the frame
        add(panel);

        numerator1Label = new JLabel("Numerator 1");
        panel.add(numerator1Label);
        numerator1Text = new JTextField("", 20);
        panel.add(numerator1Text);

        numerator2Label = new JLabel("Numerator 2");
        panel.add(numerator2Label);
        numerator2Text = new JTextField("", 20);
        panel.add(numerator2Text);

        denominator1Label = new JLabel("Denominator 1");
        panel.add(denominator1Label);
        denominator1Text = new JTextField("", 20);
        panel.add(denominator1Text);

        denominator2Label = new JLabel("Denominator 2");
        panel.add(denominator2Label);
        denominator2Text = new JTextField("", 20);
        panel.add(denominator2Text);

        ansLabel = new JLabel("Answer");
        panel.add(ansLabel);
        ansText = new JTextField(5);
        panel.add(ansText);

        addButton = new JButton("Add");
        panel.add(addButton);

        subtractButton = new JButton("Subtract");
        panel.add(subtractButton);

        multiplyButton = new JButton("Multiply");
        panel.add(multiplyButton);

        divideButton = new JButton("Divide");
        panel.add(divideButton);

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        setVisible(true);
    }

    /**
     * Performs specific action(s) based on the event that occurs
     *
     * @param e event that occurred
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                int numerator1 = Integer.parseInt(numerator1Text.getText());
                int numerator2 = Integer.parseInt(numerator2Text.getText());
                int denominator1 = Integer.parseInt(denominator1Text.getText());
                int denominator2 = Integer.parseInt(denominator2Text.getText());
                RationalNumber first = new RationalNumber(numerator1, denominator1);
                RationalNumber second = new RationalNumber(numerator2, denominator2);
                ansText.setText(first.add(second).toString());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid integer.");
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null,
                                "Denomintor of zero in given number or result of operation.");
            }
        }

        if (e.getSource() == subtractButton) {
            try {
                int numerator1 = Integer.parseInt(numerator1Text.getText());
                int numerator2 = Integer.parseInt(numerator2Text.getText());
                int denominator1 = Integer.parseInt(denominator1Text.getText());
                int denominator2 = Integer.parseInt(denominator2Text.getText());
                RationalNumber first = new RationalNumber(numerator1, denominator1);
                RationalNumber second = new RationalNumber(numerator2, denominator2);
                ansText.setText(first.subtract(second).toString());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid integer.");
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null,
                                "Denominator of zero in given number or result of operation.");
            }
        }

        if (e.getSource() == multiplyButton) {
            try {
                int numerator1 = Integer.parseInt(numerator1Text.getText());
                int numerator2 = Integer.parseInt(numerator2Text.getText());
                int denominator1 = Integer.parseInt(denominator1Text.getText());
                int denominator2 = Integer.parseInt(denominator2Text.getText());
                RationalNumber first = new RationalNumber(numerator1, denominator1);
                RationalNumber second = new RationalNumber(numerator2, denominator2);
                ansText.setText(first.multiply(second).toString());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid integer.");
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null,
                                "Denominator of zero in given number or result of operation.");
            }
        }

        if (e.getSource() == divideButton) {
            try {
                int numerator1 = Integer.parseInt(numerator1Text.getText());
                int numerator2 = Integer.parseInt(numerator2Text.getText());
                int denominator1 = Integer.parseInt(denominator1Text.getText());
                int denominator2 = Integer.parseInt(denominator2Text.getText());
                RationalNumber first = new RationalNumber(numerator1, denominator1);
                RationalNumber second = new RationalNumber(numerator2, denominator2);
                ansText.setText(first.divide(second).toString());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid integer.");
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null,
                                "Denominator of zero in given number or result of operation.");
            }
        }
    }

    /**
     * Starts the program
     *
     * @param args array of command line arguments
     */
    public static void main(String[] args) {
        new RationalNumberGUI();
    }
}
