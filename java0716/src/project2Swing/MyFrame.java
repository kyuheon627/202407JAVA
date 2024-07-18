package project2Swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	JLabel lb4 = new JLabel("금액");
	JTextField jt4 = new JTextField();
	JButton btnIn = new JButton("로그인");
	JButton btnIn2 = new JButton("회원가입");
	JButton btn1 = new JButton("예금");
	JButton btn2 = new JButton("출금");
	JButton btn3 = new JButton("잔고");
	JTextArea ta = new JTextArea();
	
	List<Member> list = null;
	Member member; // 로그인 된 현재 사용자

	public MyFrame() {
		
		try (FileInputStream fis = new FileInputStream("c:\\temp\\members.dat");
	             ObjectInputStream ois = new ObjectInputStream(fis)) {
			Member[] list2 = (Member[]) ois.readObject();
			list = new ArrayList<>(Arrays.asList(list2));   // 배열을 ArrayList로
			System.out.println("파일에서 객체를 가져왔습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (Member member : list) {
			System.out.println(member);
		}
		System.out.println("총회원수:"+list.size());
		
		
		Container con = this.getContentPane();
		con.setLayout(null);
		
		con.add(lb1);
		lb1.setLocation(20, 50);
		lb1.setSize(100, 30);
		
		con.add(jt1);
		jt1.setLocation(70, 50);
		jt1.setSize(100, 30);
		
		con.add(lb2);
		lb2.setLocation(190, 50);
		lb2.setSize(100, 30);
		
		con.add(jt2);
		jt2.setLocation(240, 50);
		jt2.setSize(100, 30);
		
		con.add(lb3);
		lb3.setLocation(360, 50);
		lb3.setSize(100, 30);
		
		con.add(jt3);
		jt3.setLocation(410, 50);
		jt3.setSize(100, 30);
		
		con.add(lb4);
		lb4.setLocation(530, 50);
		lb4.setSize(100, 30);
		
		con.add(jt4);
		jt4.setLocation(580, 50);
		jt4.setSize(100, 30);
		
		con.add(ta);
		ta.setLocation(20, 120);
		ta.setSize(700, 200);
		
		con.add(btnIn);
		btnIn.setLocation(20, 350);
		btnIn.setSize(100, 30);
		btnIn.addActionListener(new btnLogin());
		
		con.add(btnIn2);
		btnIn2.setLocation(170, 350);
		btnIn2.setSize(100, 30);
		btnIn2.addActionListener(new btnJoin());
		
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
	
	class btnLogin implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			// 로그인 처리
			String name = jt1.getText(); // name 변수의 값 입력
			String strPassword = jt2.getText(); //패스워드입력
			
			for (Member member2 : list) {
				if (member2.getName().equals(name) && member2.getSsn().equals(strPassword)) {
					member = member2;
					System.out.println("로그인 성공!");
					ta.setText("로그인 성공");
					break;
				}
			}
			System.out.println(member);
		}
	}
	
	class btnJoin implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			// 회원 가입
			String name2 = jt1.getText(); 
			String ssn = jt2.getText(); 
			String tel = jt3.getText();
			System.out.println();
			System.out.println("[입력된 내용]");
			System.out.println("1. 이름: " + name2);
			System.out.println("2. 주민번호 앞 6자리: " + ssn); 
			System.out.println("3. 전화번호: " + tel);
			list.add(new Member(name2, ssn, tel));

			ta.setText("회원가입 성공");
		}
		
	}
	
	class btnDeposit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			member.deposit(Integer.parseInt(jt4.getText()));
			
		}
		
	}
	
	class btnWithdraw implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			member.withdraw(Integer.parseInt(jt4.getText()));
			
		}
		
	}
	
	class btnBlance implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

		}
		
	}
	
	public static void main(String[] args) {

		new MyFrame();
		
	}

}
