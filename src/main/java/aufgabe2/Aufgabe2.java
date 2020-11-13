package aufgabe2;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Aufgabe2 {
    public static void main(String[] args) {
        final String address = "tcp://gvs.lxd-vs.uni-ulm.de:27347";
        final String message = "Echo test";

        try (ZContext context = new ZContext()) {
            // Erstelle Request-Socket um mit Response-Socket im Server zu kommunizieren.
            ZMQ.Socket socket = context.createSocket(SocketType.REQ);
            socket.connect(address);

            socket.send(message.getBytes(ZMQ.CHARSET));
            System.out.println("Gesendet: " + message);

            byte[] reply = socket.recv(0);
            String answer = new String(reply, ZMQ.CHARSET);
            System.out.println("Erhalten: " + answer);
        }
    }
}
