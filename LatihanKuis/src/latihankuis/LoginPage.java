package latihankuis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;

class LoginPage extends JFrame implements ActionListener{
    JLabel username = new JLabel("Username : ");
    JLabel password = new JLabel("Password : ");
    JLabel lblMessage = new JLabel("", SwingConstants.CENTER);
    
    JTextField usernameTextField = new JTextField();
    JTextField passwordTextField = new JTextField();
    
    JButton btnLogin = new JButton("Login");
    
    public LoginPage(){
        setTitle("Halaman Login");
        setVisible(true);
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setLayout(null);
        add(username);
        add(password);
        add(usernameTextField);
        add(passwordTextField);
        add(lblMessage);
        add(btnLogin);
        
        username.setBounds(50,10,120,20);
        password.setBounds(50,35,120,20);
        usernameTextField.setBounds(150,10,120,20);
        passwordTextField.setBounds(150,35,120,20);
        btnLogin.setBounds(100,80,75,20);
        lblMessage.setBounds(20, 110, 250, 20); 
        lblMessage.setForeground(java.awt.Color.BLACK);
        btnLogin.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == btnLogin){
                String username = usernameTextField.getText(); 
                String password = passwordTextField.getText();
                
                if(username.equals("pbo") && password.equals("if-d")){
                   new HalamanInputData();
                   this.dispose();
                   
                }else {
                    lblMessage.setText("Username atau Password salah.");
                }
            } 
        
    } catch(Exception error){
        lblMessage.setText("Gagal Login");
    }
 }
}
