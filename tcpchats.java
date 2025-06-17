import java.util.*;
import java.io.*;
import java.net.*;
public class tcpchats
{
public static void main(String args[])throws IOException
{
Socket cs=new Socket("localhost",8001);
DataOutputStream out=new DataOutputStream(cs.getOutputStream());
out.writeUTF("Hello from client side");
DataInputStream in=new DataInputStream(cs.getInputStream());
String msg=in.readUTF();
System.out.println(msg);
}
}


/* Algorithm :
Server-Side Algorithm (TCP Server)
1.
Start
2.
Display a welcome message.
3.
Create a ServerSocket on a specified port (e.g., 8001).
4.
Wait for a client connection using accept() method.
5.
When a client connects:
o
Create an input stream (DataInputStream) to read message from the client.
o
Read the message sent by the client using readUTF().
o
Display the received message.
o
Create an output stream (DataOutputStream) to send response back to the client.
o
Write a response message (e.g., “Message received by server”) using writeUTF().
6.
Close all streams and the socket.
7.
End
Client-Side Algorithm (TCP Client)
1.
Start
2.
Create a Socket and connect to the server using the server's IP address (e.g., localhost) and port (e.g., 8001).
3.
Create an output stream (DataOutputStream) to send a message to the server.
4.
Send a message to the server using writeUTF().
5.
Create an input stream (DataInputStream) to receive response from the server.
6.
Read the server's response using readUTF().
7.
Display the received message.
8.
Close all streams and the socket.
9.
End */
