package swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame{

	JLabel lb1;
	
	String[] stand = {"stand.gif"};
	String[] walk = {"walk1.gif", "walk2.gif"};
	String[] run = {"run1.gif", "run2.gif", "run3.gif"};
	
	Thread th = new Thread(new Field());
	
	MyFrame(){
		
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Field field = new Field();
		Control control = new Control();
		this.add(field, BorderLayout.CENTER);
		this.add(control, BorderLayout.SOUTH);
		this.setBounds(1200, 100, 500, 500);
		this.setVisible(true);
		
		th.start();
		
	}
	
	private class Field extends JPanel implements Runnable{
		
		Field(){
			this.setLayout(new BorderLayout());
			lb1 = new JLabel();
			lb1.setIcon(new ImageIcon("./src/stand.gif"));
			this.add(lb1, BorderLayout.CENTER);
		}

		@Override
		public void run() {
			
//			while(true) {
//				
//				for(int i=0; i<stand.length; i++) {
//					lb1.setIcon(new ImageIcon("./src/" + stand[i]));
//					System.out.println("./src/" + stand[i]);
//					try {
//						Thread.sleep(300);
//					} catch (InterruptedException err) {
//						err.printStackTrace();
//					}
//					
//				}
//			}
			
		}

	}
	
	private class Control extends JPanel implements ActionListener{

		private JButton standingBtn;
		private JButton walkingBtn;
		private JButton runningBtn;
		
		public Control() {
			
			this.setLayout(new FlowLayout());
			
			standingBtn = new JButton("Standing");
			walkingBtn = new JButton("Walking");
			runningBtn = new JButton("Running");
			
			this.add(standingBtn);
			this.add(walkingBtn);
			this.add(runningBtn);
			
			standingBtn.addActionListener(this);
			walkingBtn.addActionListener(this);
			runningBtn.addActionListener(this);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == standingBtn) {
				
				while(true) {
					
					for(int i=0; i<stand.length; i++) {
						lb1.setIcon(new ImageIcon("./src/" + stand[i]));
						System.out.println("./src/" + stand[i]);
						try {
							Thread.sleep(300);
						} catch (InterruptedException err) {
							err.printStackTrace();
						}
					}
				}
				
			}else if(e.getSource() == walkingBtn) {
				
				while(true) {
					
					for(int i=0; i<walk.length; i++) {
						lb1.setIcon(new ImageIcon("./src/" + walk[i]));
						System.out.println("./src/" + walk[i]);
						try {
							Thread.sleep(300);
						} catch (InterruptedException err) {
							err.printStackTrace();
						}
					}
				}
				
			}else if(e.getSource() == runningBtn) {
				
				while(true) {
					
					for(int i=0; i<run.length; i++) {
						lb1.setIcon(new ImageIcon("./src/" + run[i]));
						System.out.println("./src/" + run[i]);
						try {
							Thread.sleep(300);
						} catch (InterruptedException err) {
							err.printStackTrace();
						}
					}
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
	
}
