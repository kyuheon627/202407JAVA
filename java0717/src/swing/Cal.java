package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cal extends JFrame implements ActionListener{
	
	JLabel la1 = new JLabel("계산기");
	JLabel la2 = new JLabel("결과 : ");
	JTextField jt1 = new JTextField(5);
	JTextField jt2 = new JTextField(5);
	JButton jb1 = new JButton("+");
	JButton jb2 = new JButton("-");
	JButton jb3 = new JButton("*");
	JButton jb4 = new JButton("/");
	JPanel jpCenter = new JPanel();
	JPanel jpNorth = new JPanel();
	JPanel jpSouth = new JPanel();
	
	Cal(){
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
		con.add(jpNorth, BorderLayout.NORTH);
		jpNorth.add(la1);
		
		con.add(jpSouth, BorderLayout.SOUTH);
		jpSouth.add(la2);
		
		con.add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(new GridLayout(3, 2 , 20, 20));
		jpCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		jpCenter.add(jt1);
		jpCenter.add(jt2);
		jpCenter.add(jb1); 
		jpCenter.add(jb2); 
		jpCenter.add(jb3); 
		jpCenter.add(jb4); 
		
		
		this.setLocation(1000, 200);
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
	}

	public static void main(String[] args) {

		new Cal();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		System.out.println(e.getSource());
		if(e.getSource() == jb1) {
			System.out.println("+");
		}else if(e.getSource() == jb2) {
			System.out.println("-");
		}else if(e.getSource() == jb3) {
			System.out.println("*");
		}else if(e.getSource() == jb4) {
			System.out.println("/ ");
		}
		
	}

}
