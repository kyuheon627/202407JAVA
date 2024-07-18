package java0716;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame{

	JLabel lb1 = new JLabel("아이디");
	JTextField jt1 = new JTextField();
	JLabel lb2 = new JLabel("SSN");
	JTextField jt2 = new JTextField();
	JLabel lb3 = new JLabel("전화번호");
	JTextField jt3 = new JTextField();
	JButton btnIn = new JButton("로그인");
	JButton btnOut = new JButton("회원가입");
	JButton btn1 = new JButton("예금");
	JButton btn2 = new JButton("출금");
	JButton btn3 = new JButton("잔고");
	JTextArea ta = new JTextArea();
	
	public MyFrame() {
		
		Container con = this.getContentPane();
		con.setLayout(null);
		
		con.add(lb1);
		lb1.setLocation(20, 50);
		lb1.setSize(100, 30);
		
		con.add(jt1);
		jt1.setLocation(80, 50);
		jt1.setSize(100, 30);
		
		con.add(lb2);
		lb2.setLocation(270, 50);
		lb2.setSize(100, 30);
		
		con.add(jt2);
		jt2.setLocation(330, 50);
		jt2.setSize(100, 30);
		
		con.add(lb3);
		lb3.setLocation(520, 50);
		lb3.setSize(100, 30);
		
		con.add(jt3);
		jt3.setLocation(580, 50);
		jt3.setSize(100, 30);
		
		con.add(ta);
		ta.setLocation(20, 120);
		ta.setSize(700, 200);
		
		con.add(btnIn);
		btnIn.setLocation(20, 350);
		btnIn.setSize(100, 30);
		btnIn.addActionListener(new MyListener());
		
		con.add(btnOut);
		btnOut.setLocation(170, 350);
		btnOut.setSize(100, 30);
		
		con.add(btn1);
		btn1.setLocation(320, 350);
		btn1.setSize(100, 30);
		
		con.add(btn2);
		btn2.setLocation(470, 350);
		btn2.setSize(100, 30);
		
		con.add(btn3);
		btn3.setLocation(620, 350);
		btn3.setSize(100, 30);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("안녕 스윙");
		this.setLocation(700, 300);
		this.setSize(760, 450);
		
	}
	
	public static void main(String[] args) {

		new MyFrame();
		
	}

}
