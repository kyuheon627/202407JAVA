package java0719;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Project4 extends JFrame{

	
	JButton btnDept = new JButton("dept 출력");
	JButton btnEmp = new JButton("emp 출력");
	JTextArea ta = new JTextArea();
	JLabel txt1 = new JLabel("SELECT 입력  ");
	JTextArea taSelect = new JTextArea();
	JButton btnIn = new JButton("입력!");
	
	JPanel jpUp = new JPanel();
	JPanel jpCenter = new JPanel();
	JPanel jpDown = new JPanel();
	
	String strDept = "select * from dept";
	String strEmp = "select * from emp";
	
	String URL = "jdbc:mysql://localhost:3306/spring5fs";
	Connection connect = null;
	Statement stmt = null;

	public Project4(){
		
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
//		Border 상단 ---------------------------------------------------------
		
		con.add(jpUp, BorderLayout.NORTH);
		jpUp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		jpUp.add(txt1);

		jpUp.add(taSelect);
		taSelect.setPreferredSize(new Dimension(600, 60));
		
		jpUp.add(btnIn);
		btnIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String strSelect = taSelect.getText();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connect = DriverManager.getConnection(URL, "spring5", "spring5");
					stmt = connect.createStatement();
					int num = stmt.executeUpdate(strSelect);
					ta.setText("입력 완료!");
					taSelect.setText("");
				} catch (ClassNotFoundException | SQLException err) {
					err.printStackTrace();
				}
				
			}
		});
		
//		Border 중단 ---------------------------------------------------------
		
		con.add(jpCenter, BorderLayout.CENTER);
		jpCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		jpCenter.add(ta);
		ta.setPreferredSize(new Dimension(700, 400));
		
//		Border 하단 ---------------------------------------------------------
		
		con.add(jpDown, BorderLayout.SOUTH);
		jpDown.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		jpDown.add(btnDept);
		btnDept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connect = DriverManager.getConnection(URL, "spring5", "spring5");
					stmt = connect.createStatement();
					ResultSet rs = stmt.executeQuery(strDept);
					ta.setText("");
					ta.append("====================================\n");
					ta.append("DEPTNO\tDNAME\tLOC\n");
					ta.append("====================================\n");
					
					while(rs.next()) {
						ta.append(rs.getString(1) + "\t " + rs.getString(2) + "\t " + rs.getString(3) + "\n");
					}
					ta.append("====================================\n");
					
				} catch (ClassNotFoundException | SQLException err) {
					err.printStackTrace();
				}
				
			}
		});

		jpDown.add(btnEmp);
		btnEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connect = DriverManager.getConnection(URL, "spring5", "spring5");
					stmt = connect.createStatement();
					ResultSet rs = stmt.executeQuery(strEmp);
					ta.setText("");
					ta.append("================================================================================================\n");
					ta.append("EMPNO\tENAME\tJOB\tMGR\tHIREDATE\tSAL\tCOMM\tDEPTNO\n");
					ta.append("================================================================================================\n");
					
					while(rs.next()) {
						ta.append(rs.getString(1) + "\t " + rs.getString(2) + "\t " + rs.getString(3) + "\t" 
								+ rs.getString(4) + "\t " + rs.getString(5) + "\t " + rs.getString(6) + "\t"
								+ rs.getString(7) + "\t " + rs.getString(8) + "\n");
					}
					ta.append("================================================================================================\n");
					
				} catch (ClassNotFoundException | SQLException err) {
					err.printStackTrace();
				}
				
			}
		});
		
//		--------------------------------------------------------------------
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("안녕 스윙");
		this.setLocation(400, 300);
		this.setSize(900, 600);
		
	}
	
	
	public static void main(String[] args) {

		new Project4();
		
	}

}
