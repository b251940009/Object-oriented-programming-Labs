package lab15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton backButton;
    private DatabaseManager dbManager;

    public RegisterFrame() {
        dbManager = new DatabaseManager();

        setTitle("Register App");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(225, 235, 250));

        JLabel titleLabel = new JLabel("Register");
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 32));
        titleLabel.setForeground(new Color(0, 80, 150));
        titleLabel.setBounds(135, 40, 150, 40);
        add(titleLabel);

        usernameField = new JTextField();
        usernameField.setBounds(50, 120, 280, 40);
        usernameField.setBorder(BorderFactory.createTitledBorder("New User Name"));
        add(usernameField);

        passwordField = new JPasswordField();
        passwordField.setBounds(50, 180, 280, 40);
        passwordField.setBorder(BorderFactory.createTitledBorder("New Password"));
        add(passwordField);

        registerButton = new JButton("Register");
        registerButton.setBounds(50, 260, 280, 40);
        registerButton.setBackground(new Color(40, 167, 69));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        registerButton.setFocusPainted(false);
        add(registerButton);

        backButton = new JButton("Back to Login");
        backButton.setBounds(50, 310, 280, 40);
        backButton.setBackground(new Color(108, 117, 125));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        backButton.setFocusPainted(false);
        add(backButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if(username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Талбаруудыг бүрэн бөглөнө үү!", "Алдаа", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                boolean isRegistered = dbManager.registerUser(username, password);

                if (isRegistered) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Амжилттай бүртгэгдлээ!", "Амжилттай", JOptionPane.INFORMATION_MESSAGE);
                    LoginFrame loginFrame = new LoginFrame();
                    loginFrame.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Бүртгэхэд алдаа гарлаа.", "Алдаа", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
                dispose();
            }
        });
    }
}