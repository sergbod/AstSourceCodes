import java.net.*;
import java.util.ArrayList;
public class Connect {
	public DatagramPacket rcvdMsg;
	public MulticastSocket socket;
	
	public void setConnection(String IPaddr, int portAddr) { // Provides connection to specified Multicast IP and Port
	try {	
		InetAddress group = InetAddress.getByName(IPaddr);
		socket = new MulticastSocket(portAddr);
		socket.joinGroup(group);
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	}
	
	public ArrayList<Byte> getAsterixMsg() {	// receives new asterix message
		byte[] buf = new byte[65536];
		rcvdMsg = new DatagramPacket(buf, buf.length);
		try {
			socket.receive(rcvdMsg);
			int msgLn = rcvdMsg.getLength();
			byte[] msg = new byte[msgLn];
			msg = rcvdMsg.getData();
			ArrayList<Byte> msgAsArrayList = new ArrayList<>();
			for (int i = 0; i < msgLn; i++) {
				msgAsArrayList.add(msg[i]);
			}
			return msgAsArrayList;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
