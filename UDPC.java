import java.net.*;
import java.util.Scanner;
public class UDPC {
public static void main(String[] args) {
DatagramSocket socket = null;
Scanner scanner = new Scanner(System.in);
try {
// Create a DatagramSocket to send data to the server
socket = new DatagramSocket();
InetAddress serverAddress = InetAddress.getByName("localhost"); // Server address (can be changed to the server's IP)
int serverPort = 9876; // Server port
while (true) {
// Get the message from the user
System.out.print("Enter message to send to server: ");
String message = scanner.nextLine();
// Convert message to bytes
byte[] sendData = message.getBytes();
// Create a DatagramPacket to send the message to the server
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
socket.send(sendPacket);
System.out.println("Message sent to server.");
// Receive the response from the server
byte[] receiveData = new byte[1024];
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
socket.receive(receivePacket);
// Extract the server's response message
String serverMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
System.out.println("Response from server: " + serverMessage);
}
} catch (Exception e) {
e.printStackTrace();
} finally {
if (socket != null && !socket.isClosed()) {
socket.close();
}
scanner.close();
}
}
}


/*  ALGORITHM
SERVER SIDE :
Start
Create a UDP socket using socket()
Bind the socket to a specific IP address and port using bind()
Loop:
Wait to receive data from client using recvfrom()
Extract the data and client address
Process the data if needed
Optionally, send a response using sendto()
End Loop (or close socket on termination)
Close the socket
End
CLIENT SIDE:
Start
Create a UDP socket using socket()
Get the server IP address and port number
Prepare the data to be sent
Use sendto() to send the packet to server
Optionally, wait and receive the response from server using recvfrom()
Close the socket
End*/
