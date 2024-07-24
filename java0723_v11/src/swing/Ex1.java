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

public class Ex1 extends JFrame {
	
	String[] walk = {"walk1.gif", "walk2.gif"};
	String[] stand = {"stand.gif"};
	String[] run = {"run1.gif", "run2.gif", "run3.gif"};
	
	JLabel lbl;
	
	Ex1() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Field field = new Field();
		Control control = new Control();
		this.add(field, BorderLayout.CENTER);
		this.add(control, BorderLayout.SOUTH);
		this.setBounds(1200, 100, 500, 500);
		this.setVisible(true);
		
		//여기에 Thread를 객체 생성하여 start()메소드를 호출하세요.
		Thread thread = new Thread(field);
		thread.start();
	}
	
	private class Field extends JPanel implements Runnable {
		
		Field() {
			this.setLayout(new BorderLayout());
			lbl = new JLabel();
			lbl.setIcon(new ImageIcon("./src/stand.gif"));
			this.add(lbl, BorderLayout.CENTER);
		}
		@Override
		public void run() {
			while (true) {

				String[] path = walk;
				for (int i = 0; i < path.length; i++) {
					lbl.setIcon(new ImageIcon("./src/" + path[i]));
					System.out.println(i);
					try {
						Thread.sleep(300);  // 0.3초
					} catch (InterruptedException e) {}
				}
			}
			
		}
	}
	
	private class Control extends JPanel implements ActionListener {
		private JButton standingBtn, walkingBtn, runningBtn;
		public Control() {
			this.setLayout(new FlowLayout());

			standingBtn = new JButton("Standing");
			walkingBtn = new JButton("Walking");
			runningBtn = new JButton("Running");

			standingBtn.addActionListener(this);
			walkingBtn.addActionListener(this);
			runningBtn.addActionListener(this);
			this.add(standingBtn);
			this.add(walkingBtn);
			this.add(runningBtn);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == standingBtn) {
				
				while(true) {
					
					for(int i=0; i<stand.length; i++) {
						lbl.setIcon(new ImageIcon("./src/" + stand[i]));
						System.out.println("./src/" + stand[i]);
						try {
							Thread.sleep(300);
						} catch (InterruptedException err) {
							err.printStackTrace();
						}
					}
				}
				
			} else if (e.getSource() == walkingBtn) {
				
				while(true) {
					
					for(int i=0; i<walk.length; i++) {
						lbl.setIcon(new ImageIcon("./src/" + walk[i]));
						System.out.println("./src/" + walk[i]);
						try {
							Thread.sleep(300);
						} catch (InterruptedException err) {
							err.printStackTrace();
						}
					}
				}
				
			} else if (e.getSource() == runningBtn) {
				
				while(true) {
					
					for(int i=0; i<run.length; i++) {
						lbl.setIcon(new ImageIcon("./src/" + run[i]));
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
	
	public static void main(String[] ar) {
		new Ex1();
	}
}