package exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Exercise1 {
    public static void main(String[] args) {
        final String hostName = "gvs.lxd-vs.uni-ulm.de";
        final int port = 3211;
        final String message = "Echo test";

        Socket socket = null;
        try {
            socket = new Socket(hostName, port);
            // Send message
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(message);
            System.out.println("Message: " + message);
            // Read and print answer
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String answer = in.readLine();
            System.out.println("Answer : " + answer);
        } catch (UnknownHostException e) {
            System.err.println("Couldn't create IP of server!");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Couldn't create socket or send or write message to/from server!");
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Coudln't close socket!");
                    e.printStackTrace();
                }
            }
        }
    }
}
