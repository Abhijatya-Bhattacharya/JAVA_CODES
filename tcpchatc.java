import java.util.*;
import java.io.*;
import java.net.*;
public class tcpchatc
{
public static void main(String args[])throws IOException
{
System.out.println("Hello Welcome!!!");
ServerSocket ss=new ServerSocket(8001);
System.out.println("Server waiting for client");
Socket cs=ss.accept();
DataInputStream in=new DataInputStream(cs.getInputStream());
String msg=in.readUTF();
System.out.println(msg);
DataOutputStream out=new DataOutputStream(cs.getOutputStream());
out.writeUTF("Message received by server");
}
}
