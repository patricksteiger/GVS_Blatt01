package aufgabe1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Aufgabe1 {
    public static void main(String[] args) {
        final String hostName = "gvs.lxd-vs.uni-ulm.de";
        final int port = 3211;
        final String message = "Echo test";

        try {
            Socket socket = new Socket(hostName, port);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(message);
            System.out.println("Gesendet: " + message);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String answer = in.readLine();
            System.out.println("Erhalten: " + answer);
        } catch (UnknownHostException e) {
            System.err.println("Couldn't create IP of server!");
        } catch (IOException e) {
            System.err.println("Couldn't create socket or send or write message to/from server!");
        }
    }
}
