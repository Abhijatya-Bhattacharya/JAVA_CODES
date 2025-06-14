import java.util.*;
import java.io.*;
import java.net.*;
public class SMRS
{
public static void main(String[] args)
{
System.out.println("Hello Welcome...");
try (ServerSocket serverSocket = new ServerSocket(8001))
{
System.out.println("\nServer Running.....");
while(true)
{
System.out.println("Server waiting for Client Request....");
try(Socket clientSocket = serverSocket.accept())
{
System.out.println("Server established connection with client.");
DataInputStream in=new DataInputStream(clientSocket.getInputStream());
String msg=in.readUTF();
System.out.println("Message From Client : "+msg);
DataOutputStream out=new DataOutputStream(clientSocket.getOutputStream());
out.writeUTF("Server has received: "+msg);
}
catch(IOException e)
{
System.out.println("Error in communication with client:"+e.getMessage());
}
}
}catch(IOException e)
{
System.out.println("Error in starting server: "+e.getMessage());
}
}
}



/*ALGORITHM
Step 1: Start
Step 2: Create a server socket (TCP)
Step 3: Bind the socket to an IP address and port
Step 4: Listen for incoming client connections
Step 5: Accept the connection from a client
Step 6: Receive message/request from the client
Step 7: IF message = "TIME" THEN
- Get current system time
- Prepare a response with the time
ELSE
- Prepare a response: "Invalid Request"
Step 8: Send the response back to the client
Step 9: Close the client connection
Step 10: Go back to Step 5 to accept next client or Stop*/
