package project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Project2 extends JFrame{

	JTextField tf = new JTextField(20);
	JButton bt = new JButton("조회");
	JTextArea ta = new JTextArea(15, 40);
	JLabel jl = new JLabel("테스트");

	String URL = "jdbc:mysql://localhost:3307/spring5fs";
	Connection conn = null;
	Statement stmt = null;
	
	JFrame jf;
	public Project2() {
		jf = this;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("접속 성공!");
			stmt = conn.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
//		상단 ------------------------------------------------------------
		
		JPanel jpUp = new JPanel(new FlowLayout());
		jpUp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		con.add(jpUp, BorderLayout.NORTH);
		
		jpUp.add(tf);
		
		jpUp.add(bt);
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String input = tf.getText();
				String sql = String.format("select * from dept where loc like '%%%s%%'", input);
				
				try {
					ResultSet rs = stmt.executeQuery(sql);
			
					ta.setText("");
					
					boolean flag = true;
					while (rs.next()) {
						flag = false;
						int deptno = rs.getInt("deptno");
						String dname = rs.getString("dname");
						String loc = rs.getString("loc");
						ta.append(String.format("%d %s %s \n", deptno, dname, loc));
					}
					if(flag) {
						JOptionPane.showMessageDialog(jf, "해당 자료가 없습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
					}
					
				} catch (SQLException err) {
					err.printStackTrace();
				}
				
			}
		});
		
//		중단 ------------------------------------------------------------
		
		JPanel jpCenter = new JPanel(new FlowLayout());
		con.add(jpCenter, BorderLayout.CENTER);
		
		jpCenter.add(ta);
		
//		하단 ------------------------------------------------------------
		
		JPanel jpDown = new JPanel(new FlowLayout());
		con.add(jpDown, BorderLayout.SOUTH);
		jpDown.add(jl);
		
//		----------------------------------------------------------------
		
		this.setTitle("view dept 테이블");
		this.setBounds(1200, 200, 500, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {

		Project2 pro = new Project2();
		
		while(true) {
			LocalTime localTime = LocalTime.now();
			pro.jl.setText(String.format("%d:%d:%d\n", localTime.getHour(), localTime.getMinute(), localTime.getSecond()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
