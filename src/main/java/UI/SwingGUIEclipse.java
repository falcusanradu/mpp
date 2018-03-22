package UI;

import org.springframework.beans.factory.annotation.Autowired;
import service.Service;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class SwingGUIEclipse {

	private Service userService = new Service();

	public JFrame frame;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;


	/**
	 * Create the application.
	 */
	public SwingGUIEclipse() {
		initialize();
	}

	/**
	 * main class
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingGUIEclipse swingGUIEclipse = new SwingGUIEclipse();
					swingGUIEclipse.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 571, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(62, 105, 116, 22);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);

		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(62, 149, 116, 22);
		frame.getContentPane().add(textFieldPassword);

		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textFieldUsername.getText();
				String password = textFieldPassword.getText();
				try {
					if (userService.login(username, password) == false) {
						JOptionPane.showMessageDialog(btnLogin, "wrong username or password");
					} else {
						frame.dispose();
						AfterLoginEclipse afterLogin = new AfterLoginEclipse();
						afterLogin.setVisible(true);
						// this.dispose();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		btnLogin.setBounds(62, 240, 97, 25);
		frame.getContentPane().add(btnLogin);
	}

}
