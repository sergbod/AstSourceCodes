import java.util.ArrayList;

public class AsterixCat034 extends Asterix {
	
	ArrayList<Byte> procMsg = new ArrayList<>();
	public int messageLen = 0;
	String textOut = null;
	
	public void go(ArrayList<Byte> cat034Msg) {
		cat034Msg.subList(0, 3).clear();
		procMsg = cat034Msg;
		Asterix ast48 = new Asterix();
		while (procMsg.size() != 0) {
			long fspec = ast48.getAstMsgRecFSPEC(procMsg);
			
		}
		
	}
	
}
