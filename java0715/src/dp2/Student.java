package dp2;

import java.util.Vector;

public class Student {

	private Vector<Transcript> transcripts;
	private String name;
	
	
	public Student(String name) {
		super();
		this.transcripts = new Vector<Transcript>();
		this.name = name;
	}
	
	
	public void registerTranscript(Transcript transcript) {
		transcripts.add(transcript);
	}
	
	public void dropTranscript(Transcript transcript) {
		if(transcripts.contains(transcript)) {
			transcripts.remove(transcript);
		}
	}

	

	public Vector<Transcript> getTranscripts() {
		return transcripts;
	}


	public void setTranscripts(Vector<Transcript> transcripts) {
		this.transcripts = transcripts;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}



	@Override
	public String toString() {
		return "Student [name=" + name + ", transcripts=" + transcripts + "]";
	}

}
