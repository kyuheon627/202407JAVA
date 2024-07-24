package templateMethod;

public class CharDisplay extends AbstractDisplay{

	private char ch;
	
	public CharDisplay(char ch) {
		super();
		this.ch = ch;
	}

	@Override
	public void open() {
		System.out.print("<<");		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print(ch);
	}

	@Override
	public void close() {
		System.out.print(">>");
	}

}
