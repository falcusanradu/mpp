import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class SwingGUIEclipse {

    private ClientCtrl userClientCtrl;

    public JFrame frame;
    private JTextField textFieldUsername;
    private JPasswordField textFieldPassword;


    /**
     * Create the application.
     */
    public SwingGUIEclipse(ClientCtrl clientCtrl) throws RemoteException {
        this.userClientCtrl = clientCtrl;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 471, 337);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(62, 61, 208, 22);
        frame.getContentPane().add(textFieldUsername);
        textFieldUsername.setColumns(10);

        JButton btnLogin = new JButton("login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String username = textFieldUsername.getText();
                String password = textFieldPassword.getText();
                try {
                    if (userClientCtrl.login(username, password) == false) {
                        JOptionPane.showMessageDialog(btnLogin, "wrong username or password");
                    } else {
                        frame.dispose();
                        AfterLoginEclipse afterLogin = new AfterLoginEclipse(userClientCtrl);
                        afterLogin.frame.setVisible(true);
                        // this.dispose();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        });
        btnLogin.setBounds(62, 177, 97, 25);
        frame.getContentPane().add(btnLogin);

        textFieldPassword = new JPasswordField();
        textFieldPassword.setBounds(62, 112, 208, 25);
        frame.getContentPane().add(textFieldPassword);
    }
}
