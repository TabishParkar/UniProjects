import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PaintApp extends JFrame {
    private JLabel lengthLabel, widthLabel, heightLabel, areaLabel, tinsLabel, costLabel, vatLabel, totalLabel,
            tenderedLabel, changeLabel;
    private JTextField lengthField, widthField, heightField, tenderedField;
    private JButton calculateButton;

    public PaintApp() {
        setTitle("Paint App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        lengthLabel = new JLabel("Length:");
        widthLabel = new JLabel("Width:");
        heightLabel = new JLabel("Height:");
        areaLabel = new JLabel("Wall Area:");
        tinsLabel = new JLabel("Number of Tins:");
        costLabel = new JLabel("Paint Cost:");
        vatLabel = new JLabel("VAT:");
        totalLabel = new JLabel("Total Cost:");
        tenderedLabel = new JLabel("Amount Tendered:");
        changeLabel = new JLabel("Change:");

        lengthField = new JTextField(10);
        widthField = new JTextField(10);
        heightField = new JTextField(10);
        tenderedField = new JTextField(10);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculatePaint();
            }
        });

        add(lengthLabel);
        add(lengthField);
        add(widthLabel);
        add(widthField);
        add(heightLabel);
        add(heightField);
        add(calculateButton);
        add(areaLabel);
        add(tinsLabel);
        add(costLabel);
        add(vatLabel);
        add(totalLabel);
        add(tenderedLabel);
        add(tenderedField);
        add(changeLabel);

        pack();
        setVisible(true);
    }

    private void calculatePaint() {
        double length = Double.parseDouble(lengthField.getText());
        double width = Double.parseDouble(widthField.getText());
        double height = Double.parseDouble(heightField.getText());

        double wallArea = calculateWallArea(length, width, height);
        int tinsNeeded = calculateTinsNeeded(wallArea);
        double paintCost = calculatePaintCost(tinsNeeded);
        double vat = calculateVAT(paintCost);
        double totalCost = paintCost + vat;
        double tenderedAmount = Double.parseDouble(tenderedField.getText());
        double change = calculateChange(totalCost, tenderedAmount);

        areaLabel.setText("Wall Area: " + wallArea + " square meters");
        tinsLabel.setText("Number of Tins: " + tinsNeeded);
        costLabel.setText("Paint Cost: R" + paintCost);
        vatLabel.setText("VAT: R" + vat);
        totalLabel.setText("Total Cost: R" + totalCost);
        changeLabel.setText("Change: R" + change);
    }

    private double calculateWallArea(double length, double width, double height) {
        double area = 2 * (length * height + width * height);
        return area;
    }

    private int calculateTinsNeeded(double wallArea) {
        int tins = (int) Math.ceil(wallArea / 10);
        return tins;
    }

    private double calculatePaintCost(int tinsNeeded) {
        double paintCost = tinsNeeded * 30;
        return paintCost;
    }

    private double calculateVAT(double paintCost) {
        double vat = paintCost * 0.15;
        return vat;
    }

    private double calculateChange(double totalCost, double tenderedAmount) {
        double change = tenderedAmount - totalCost;
        return change;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PaintApp();
            }
        });
    }
}