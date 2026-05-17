package lab13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DensityCalculator extends JFrame {

    private JTextField massField, volumeField, densityField;
    private JComboBox<String> massUnitCombo, volumeUnitCombo, densityUnitCombo;
    private JButton calculateBtn, clearBtn;
    private JTextArea answerArea;

    public DensityCalculator() {
        setTitle("Density Calculator");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        JLabel titleLabel = new JLabel("Density Calculator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(20, 60, 100));
        
        JLabel formulaLabel = new JLabel("<html><body><center><i>p</i> = <font size='+1'><sup>m</sup>&frasl;<sub>V</sub></font></center></body></html>", SwingConstants.CENTER);
        formulaLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        
        topPanel.add(titleLabel);
        topPanel.add(formulaLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        centerPanel.add(new JLabel("density p =", SwingConstants.RIGHT), gbc);
        
        densityField = new JTextField("calculated density", 15);
        densityField.setEditable(false);
        densityField.setBackground(new Color(230, 230, 230));
        gbc.gridx = 1;
        centerPanel.add(densityField, gbc);
        
        String[] densityUnits = {"g/cm³", "kg/m³", "g/mL", "lb/ft³"};
        densityUnitCombo = new JComboBox<>(densityUnits);
        gbc.gridx = 2;
        centerPanel.add(densityUnitCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        centerPanel.add(new JLabel("mass m =", SwingConstants.RIGHT), gbc);
        
        massField = new JTextField(15);
        gbc.gridx = 1;
        centerPanel.add(massField, gbc);
        
        String[] massUnits = {"g", "kg", "mg", "lb"};
        massUnitCombo = new JComboBox<>(massUnits);
        gbc.gridx = 2;
        centerPanel.add(massUnitCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        centerPanel.add(new JLabel("volume V =", SwingConstants.RIGHT), gbc);
        
        volumeField = new JTextField(15);
        gbc.gridx = 1;
        centerPanel.add(volumeField, gbc);
        
        String[] volumeUnits = {"cm³", "m³", "mL", "L", "ft³"};
        volumeUnitCombo = new JComboBox<>(volumeUnits);
        gbc.gridx = 2;
        centerPanel.add(volumeUnitCombo, gbc);

        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        clearBtn = new JButton("Tseverleh");
        calculateBtn = new JButton("Bodoh");
        calculateBtn.setFont(new Font("Arial", Font.BOLD, 14));
        
        buttonPanel.add(clearBtn);
        buttonPanel.add(calculateBtn);
        
        answerArea = new JTextArea(3, 30);
        answerArea.setEditable(false);
        answerArea.setBorder(BorderFactory.createTitledBorder("Hariu:"));
        
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(answerArea, BorderLayout.SOUTH);
        
        add(bottomPanel, BorderLayout.SOUTH);

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                massField.setText("");
                volumeField.setText("");
                densityField.setText("bodson nygt");
                answerArea.setText("");
            }
        });

        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double mass = Double.parseDouble(massField.getText());
                    double volume = Double.parseDouble(volumeField.getText());

                    if (volume == 0) {
                        throw new ArithmeticException("ezelhvvn 0 baij bolohgui");
                    }
                    
                    if (volume < 0 || mass < 0) {
                         throw new IllegalArgumentException("Mass bolon ezemhvvn hasah utgatai baij bolohgui!");
                    }

                    double density = mass / volume;
                    String resultText = String.format("%.4f", density);
                    densityField.setText(resultText);
                    
                    String unitStr = densityUnitCombo.getSelectedItem().toString();
                    answerArea.setText("nygt (p) = " + resultText + " " + unitStr);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(DensityCalculator.this, 
                            "mass ezelhvvnii talbart zovhon too oruulna uu!", 
                            "aldaa (toonii fromat buruu baina)", 
                            JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(DensityCalculator.this, 
                            ex.getMessage(), 
                            "matimatic aldaa", 
                            JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(DensityCalculator.this, 
                            ex.getMessage(), 
                            "utgiin aldaa", 
                            JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(DensityCalculator.this, 
                            "bodohod aldaa garlaa: " + ex.getMessage(), 
                            "aldaa", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}