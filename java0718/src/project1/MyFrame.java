package project1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	JButton btnOut = new JButton("정보저장");
	JButton btn1 = new JButton("예금");
	JButton btn2 = new JButton("출금");
	JButton btn3 = new JButton("잔고");
	JTextArea ta = new JTextArea();
	
	JPanel jpUp = new JPanel();
	JPanel jpCenter = new JPanel();
	JPanel jpDown = new JPanel();
	JPanel jpRight = new JPanel();
	
	
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
		con.setLayout(new BorderLayout());
		
//		Border 상단 ------------------------------------------------
		
		con.add(jpUp, BorderLayout.NORTH);
		jpUp.setLayout(new FlowLayout());
		jpUp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		jpUp.add(lb1);
		lb1.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 10));
		
		jpUp.add(jt1);
		jt1.setPreferredSize(new Dimension(100, 30));
		
		jpUp.add(lb2);
		lb2.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 10));
		
		jpUp.add(jt2);
		jt2.setPreferredSize(new Dimension(100, 30));
		
		jpUp.add(lb3);
		lb3.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 10));
		
		jpUp.add(jt3);
		jt3.setPreferredSize(new Dimension(100, 30));
		
//		Border 우측 --------------------------------------------------
		
		con.add(jpRight, BorderLayout.EAST);
		jpRight.setLayout(new BorderLayout());
		jpRight.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JPanel jpBank = new JPanel();
		jpRight.add(jpBank, BorderLayout.NORTH);
		jpBank.setLayout(new FlowLayout());
		jpBank.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		jpBank.add(lb4);
		lb4.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 10));
		
		jpBank.add(jt4);
		jt4.setPreferredSize(new Dimension(100, 30));
		
		JPanel jpMoney = new JPanel();
		jpRight.add(jpMoney, BorderLayout.CENTER);
		jpMoney.setLayout(new GridLayout(3, 1, 10, 50));
		jpMoney.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		jpMoney.add(btn1);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(member != null) {
					member.deposit(Integer.parseInt(jt4.getText()));
					ta.setText("예금액> " + jt4.getText());
				}else {
					ta.setText("로그인을 먼저 해주세요");
				}
				
				
			}
		});
		
		jpMoney.add(btn2);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(member != null) {
					member.withdraw(Integer.parseInt(jt4.getText()));
					ta.setText("출금액> " + jt4.getText());
				}else {
					ta.setText("로그인을 먼저 해주세요");
				}
				
			}
		});
		
		jpMoney.add(btn3);
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(member != null) {
					ta.setText("잔고> " + member.getBalance());
				}else {
					ta.setText("로그인을 먼저 해주세요");
				}
				
			}
		});
		
//		Border 중단 --------------------------------------------------
		
		con.add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(new FlowLayout());
		jpCenter.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		jpCenter.add(ta);
		ta.setPreferredSize(new Dimension(500, 280));
		
//		Border 하단 ---------------------------------------------------
		
		con.add(jpDown, BorderLayout.SOUTH);
		jpDown.setLayout(new GridLayout(1, 3, 10, 10));
		jpDown.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		jpDown.add(btnIn);
		btnIn.addActionListener(new btnLogin());
		
		jpDown.add(btnIn2);
		btnIn2.addActionListener(new btnJoin());
		
		jpDown.add(btnOut);
		btnOut.addActionListener(new btnOutput());
		
//		----------------------------------------------------------------
		
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
			
			if(name.equals(null) || strPassword.equals(null)) {
				
				ta.setText("로그인 성공!");
				System.out.println("로그인 실패!");
				
			}else {
				
				for (Member member2 : list) {
					if (member2.getName().equals(name) && member2.getSsn().equals(strPassword)) {
						member = member2;
						System.out.println("로그인 성공!");
						ta.setText("로그인 성공!");
						System.out.println(member);
						break;
					}
				}
				
			}
		}
	}
	
	class btnJoin implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			// 회원 가입
			String name = jt1.getText(); 
			String ssn = jt2.getText(); 
			String tel = jt3.getText();
			
			if(!name.equals(null) || !ssn.equals(null) || !tel.equals(null)) {
				System.out.println();
				System.out.println("[입력된 내용]");
				System.out.println("1. 이름: " + name);
				System.out.println("2. 주민번호 앞 6자리: " + ssn); 
				System.out.println("3. 전화번호: " + tel);
				list.add(new Member(name, ssn, tel));
				
				ta.setText("회원가입 성공 \n\n");
				ta.append("[입력된 내용] \n");
				ta.append("1. 이름: " + name + "\n");
				ta.append("2. 주민번호 앞 6자리: " + ssn + "\n");
				ta.append("3. 전화번호: " + tel + "\n");
				
				jt1.setText("");
				jt2.setText("");
				jt3.setText("");
			} else {
				ta.setText("정보를 모두 작성해주세요.");
			}
		}
		
	}
	
	class btnOutput implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			Member[] list2 = list.toArray(new Member[list.size()]); // ArrayList를 배열로
			try (FileOutputStream fos = new FileOutputStream("c:\\temp\\members.dat");
		             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				 oos.writeObject(list2);
		         System.out.println("객체를 파일에 저장했습니다.");
				
				
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {

		new MyFrame();
		
	}

}
