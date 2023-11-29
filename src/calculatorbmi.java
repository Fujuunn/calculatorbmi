/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Juanf
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculatorbmi extends JFrame implements ActionListener {
    private JLabel weightLabel, heightLabel, resultLabel;
    private JTextField weightField, heightField, resultField;
    private JButton calculateButton;

    public calculatorbmi() {
        setTitle("BMI Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        weightLabel = new JLabel("Enter Weight (kg): ");
        weightField = new JTextField();
        heightLabel = new JLabel("Enter Height (m): ");
        heightField = new JTextField();
        resultLabel = new JLabel("Your BMI: ");
        resultField = new JTextField();
        resultField.setEditable(false);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        add(weightLabel);
        add(weightField);
        add(heightLabel);
        add(heightField);
        add(resultLabel);
        add(resultField);
        add(new JLabel());
        add(calculateButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            calculateBMI();
        }
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            double bmi = weight / (height * height);

            // Menampilkan BMI dengan dua angka di belakang koma
            resultField.setText(String.format("%.2f", bmi));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid untuk berat dan tinggi!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            calculatorbmi calculator = new calculatorbmi();
            calculator.setVisible(true);
        });
    }
}