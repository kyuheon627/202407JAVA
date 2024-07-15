package java0712;

public class Ex03 {

	public static void main(String[] args) {
		
		int[][] scores = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		for(int i=0; i<scores.length; i++) {
			for(int j=0; j<scores[i].length; j++){
				System.out.println(scores[i][j]);
			}
		}
	
	}

}
