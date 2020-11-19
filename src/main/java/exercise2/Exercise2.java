package exercise2;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Exercise2 {
    public static void main(String[] args) {
        final String address = "tcp://gvs.lxd-vs.uni-ulm.de:27347";
        final String message = "Echo test";

        try (ZContext context = new ZContext()) {
            ZMQ.Socket socket = context.createSocket(SocketType.REQ);
            socket.setIPv6(true);
            socket.connect(address);
            // Send message
            socket.send(message.getBytes(ZMQ.CHARSET));
            System.out.println("Message: " + message);
            // Read and print answer
            byte[] reply = socket.recv();
            String answer = new String(reply, ZMQ.CHARSET);
            System.out.println("Answer : " + answer);
        }
    }
}
