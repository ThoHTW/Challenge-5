package transmission;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DataConnector implements DataConnection {
    private Socket socket;
    private ServerSocket serverSocket;
    /**
     * Create client side - open connection to address / port
     * @param address
     */
    public DataConnector(String address, int port) {
        // TODO
        try {
            socket = new Socket(address, port);
            serverSocket = null;
        }catch (IOException e){
            System.out.println("couldnt connect socket (client side");
        }
    }

    /**
     * Create server side - open port on this port and wait for one client
     * @param port
     */
    public DataConnector(int port) {
        // TODO
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
        }catch (IOException e){
            System.out.println("Couldnt connect serverSocket");
        }
    }


    @Override
    public DataInputStream getDataInputStream() throws IOException {
        return new DataInputStream(socket.getInputStream()); // TODO
    }

    @Override
    public DataOutputStream getDataOutputStream() throws IOException {
        return new DataOutputStream(socket.getOutputStream()); // TODO
    }
}
