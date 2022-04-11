import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyFrame extends JFrame {
	String id = "test";
	String password = "12345678";
	JPanel panel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JLabel id_label = new JLabel("Id");
	JPanel idPanel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel pwPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JLabel pw_label = new JLabel("Password");
	JPanel pwPanel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel loginPanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	JTextField field_id = new JTextField();
	JPasswordField field_pw = new JPasswordField();
	JButton loginButton = new JButton("login");
	
	public MyFrame() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(2,2));
		//size setting for each component
		panel.setPreferredSize(new Dimension(240,60));
		id_label.setPreferredSize(new Dimension(80,20));
		pw_label.setPreferredSize(new Dimension(80,20));
		field_id.setPreferredSize(new Dimension(160,20));
		field_pw.setPreferredSize(new Dimension(160,20));
		loginButton.setPreferredSize(new Dimension(240,20));
		
		//information field
		idPanel.add(id_label);
		idPanel2.add(field_id);
		pwPanel.add(pw_label);
		pwPanel2.add(field_pw);
		loginPanel.add(loginButton);
		
		panel.add(idPanel); panel.add(idPanel2);
		panel.add(pwPanel); panel.add(pwPanel2);
		topPanel.add(loginPanel);
		
		setLayout(new BorderLayout());
		add(topPanel, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
		
		pack();
		// display setting
		this.setVisible(true);
		this.setLocationRelativeTo(null); //display on center
		
		
	loginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//check id&pw
			String idInput = field_id.getText();
			String pwInput = field_pw.getText();
			
			if(idInput == id || idInput.length() == 0) {
				System.out.println("retry ID");
				field_id.setText("");
				field_pw.setText("");
				return;
			}
			if(pwInput == password || pwInput.length() == 0) {
				System.out.println("retry PW");
				field_id.setText("");
				field_pw.setText("");
				return;
			}
			
			if(id.equals(idInput) && password.equals(pwInput)) {
				System.out.println("completed login");
				return;
			}
		}
	});
	}
	public static void main(String[] args) {
			MyFrame frame = new MyFrame();
	}
}