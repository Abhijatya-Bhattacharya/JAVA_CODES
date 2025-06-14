import java.util.*;
import java.io.*;
import java.net.*;
public class SMRC
{
public static void main(String[] args)
{
try(Socket socket = new Socket("localhost",8001))
{
DataOutputStream out=new DataOutputStream(socket.getOutputStream());
String messageToSend = "Hello! This message is sent from Client Side.";
out.writeUTF(messageToSend);
DataInputStream in=new DataInputStream(socket.getInputStream());
String msg=in.readUTF();
System.out.println("Message From Server: "+msg);
}
catch(IOException e)
{
System.out.println("Error in communication with server: "+e.getMessage());
}
}
}
