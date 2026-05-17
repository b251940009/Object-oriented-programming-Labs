package lab15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private DatabaseManager dbManager;

    public LoginFrame() {
        dbManager = new DatabaseManager();

        setTitle("Login App");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(225, 235, 250));

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 32));
        titleLabel.setForeground(new Color(0, 80, 150));
        titleLabel.setBounds(155, 40, 100, 40);
        add(titleLabel);

        usernameField = new JTextField();
        usernameField.setBounds(50, 120, 280, 40);
        usernameField.setBorder(BorderFactory.createTitledBorder("User Name"));
        add(usernameField);

        passwordField = new JPasswordField();
        passwordField.setBounds(50, 180, 280, 40);
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 260, 280, 40);
        loginButton.setBackground(new Color(0, 102, 204));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        loginButton.setFocusPainted(false);
        add(loginButton);

        JLabel registerLabel = new JLabel("Register Now");
        registerLabel.setBounds(150, 330, 100, 20);
        registerLabel.setForeground(new Color(0, 102, 204));
        registerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(registerLabel);

        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterFrame regFrame = new RegisterFrame();
                regFrame.setVisible(true);
                dispose();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                boolean isValid = dbManager.authenticateUser(username, password);

                if (isValid) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Амжилттай нэвтэрлээ!", "Амжилттай", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Нэвтрэх нэр эсвэл нууц үг буруу байна!", "Алдаа", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}