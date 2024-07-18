package swing;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MyFrame {

	public static void main(String[] args) {

		new MouseListenerEx();
		
	}
	
}

class MouseListenerEx extends JFrame{
	JPanel jp = new JPanel();		// default는 FlowLayout으로 설정되어 있음
	JLabel la = new JLabel("No Mouse Event");
	
	MouseListenerEx(){
		this.setContentPane(jp);	// 컨테이너 위에 판넬 실행
		jp.add(la);					// 판넬 위에 레이블 실`행
		this.setSize(300, 400); 	// 윈도우 사이즈 설정
		this.setVisible(true);		// 윈도우 실행
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 윈도우 종료시 메모리에서 삭제
		
		jp.addMouseListener(new MyMouseListener());
		jp.addMouseMotionListener(new MyMouseListener());
	}
	
	//		마우스 이벤트		마우스 모션 이벤트
	class MyMouseListener implements MouseListener, MouseMotionListener{

		@Override
		public void mouseClicked(MouseEvent e) {	// 마우스 클릭 이벤트
			la.setText("click(" + e.getX() + ", " + e.getY() + ")");
		}

		@Override
		public void mousePressed(MouseEvent e) {	// 마우스를 누르고 있을 때 발생하는 이벤트
			la.setText("press(" + e.getX() + ", " + e.getY() + ")");

		}

		@Override
		public void mouseReleased(MouseEvent e) {	
			la.setText("release(" + e.getX() + ", " + e.getY() + ")");
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {	// 윈도우에 마우스가 있을 때 발생하는 이벤트
			jp.setBackground(Color.CYAN);

		}

		@Override
		public void mouseExited(MouseEvent e) {		// 윈도우에서 마우스가 나갈 때 발생하는 이벤트
			jp.setBackground(Color.YELLOW);
		}

		@Override
		public void mouseDragged(MouseEvent e) {	// 윈도우에서 마우스를 드레그 할 때 발생하는 이벤트
			la.setText("dragg(" + e.getX() + ", " + e.getY() + ")");

		}

		@Override
		public void mouseMoved(MouseEvent e) {		// 윈도우에서 마우스를 움직일 때 발생하는 이벤트
			la.setText("move(" + e.getX() + ", " + e.getY() + ")");
			
		}

	}
	
}


