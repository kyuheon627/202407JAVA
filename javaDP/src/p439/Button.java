package p439;

public class Button {

	OnClickListener listener;
	
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	void touch() {
		listener.OnClick();
	}
	
	static interface OnClickListener{
		void OnClick();
	}
	
}
