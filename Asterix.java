import java.util.ArrayList;

public class Asterix {
	
	public int getAstMsgCat(ArrayList<Byte> rcvdMsg) { //Returns Asterix message category
		return Byte.toUnsignedInt(rcvdMsg.get(0));
	}
	
	public int getAstMsgLen(ArrayList<Byte> rcvdMsg) { //Returns Asterix message length
		int oct1 = Byte.toUnsignedInt(rcvdMsg.get(1));
		int oct2 = Byte.toUnsignedInt(rcvdMsg.get(2));
		return ((oct1 << 8) | oct2);
		
	}
	
	public long getAstMsgRecFSPEC(ArrayList<Byte> rcvdMsg) { //Returns Asterix Field Specification
		int pos = 0;
		long fspec = Byte.toUnsignedInt(rcvdMsg.get(pos));
		while ((fspec & 0b1) != 0) {
			pos++;
			fspec = (fspec << 8) | Byte.toUnsignedInt(rcvdMsg.get(pos));
		}
		return fspec;
	}
	
	public long getAstMsgRecFSPECreversed(ArrayList<Byte> rcvdMsg) { //Returns reversed Asterix Field Specification
		int pos = 0;
		long fspec = Byte.toUnsignedInt(rcvdMsg.get(pos));
		while ((fspec & 0b1) != 0) {
			pos++;
			fspec = (fspec << 8) | Byte.toUnsignedInt(rcvdMsg.get(pos));
		}
		long fspecRev = Long.reverse(fspec) >> (64 - ((pos + 1) * 8));
		return fspecRev;
	}
	
	public void AsterixMsgProcessing(ArrayList<Byte> inpMsg, int lenth) {
		Asterix astProc = new Asterix();
		int astCat = astProc.getAstMsgCat(inpMsg);
		switch (astCat) {
		case 8:
			AsterixCat008 ast008 = new AsterixCat008();
			ast008.messageLen = lenth;
			ast008.go(inpMsg);
			break;
		case 34:
			AsterixCat034 ast034 = new AsterixCat034();
			ast034.messageLen = lenth;
			ast034.go(inpMsg);
			break;
		case 48:	
			AsterixCat048 ast048 = new AsterixCat048();
			ast048.messageLen = lenth;
			ast048.go(inpMsg);
			break;
		}
	}
	
}
