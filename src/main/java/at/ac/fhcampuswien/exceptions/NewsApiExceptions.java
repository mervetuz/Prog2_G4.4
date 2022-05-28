package at.ac.fhcampuswien.exceptions;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.IOException;



public class NewsApiExceptions {
    //https://java-tutorial.org/exception-handling.html
    private static final String HOST = "localhost";
    public static void main(String[] args) throws UnknownHostException {
        boolean isConnected = !HOST.equals(InetAddress.getLocalHost().getHostAddress().toString());
        if (isConnected) System.out.println("Connected");
        else System.out.println("Not connected");
    }

    //https://stackoverflow.com/questions/1402005/how-to-check-if-internet-connection-is-present-in-java
    public static boolean isInternetAvailable() throws IOException
    {
        return isHostAvailable("google.com");
    }

    private static boolean isHostAvailable(String hostName) throws IOException
    {
        try(Socket socket = new Socket())
        {
            int port = 80;
            InetSocketAddress socketAddress = new InetSocketAddress(hostName, port);
            socket.connect(socketAddress, 3000);

            return true;
        }
        catch(UnknownHostException unknownHost)
        {
            return false;
        }
    }
}