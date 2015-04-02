import java.util.ArrayList;


public class TestDriveAsterix {

	public static void main(String[] args) {
		
		Connect connection = new Connect();
		Asterix ast = new Asterix();
		
		connection.setConnection("239.192.0.16", 2121);
		int iteration = 1;
		
		while (true) {
			ArrayList<Byte> newMsg = new ArrayList<>(); 
			newMsg = connection.getAsterixMsg();
			ast.AsterixMsgProcessing(newMsg, ast.getAstMsgLen(newMsg));
			System.out.println(iteration + " " + ast.getAstMsgCat(newMsg) + " " + ast.getAstMsgLen(newMsg));
			iteration++;
		}

	}

}
