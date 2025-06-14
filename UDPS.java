import java.net.*;
public class UDPS {
public static void main(String[] args) {
DatagramSocket socket = null;
try {
// Create a DatagramSocket to listen on a specific port
socket = new DatagramSocket(9876); // Server port
System.out.println("Server is listening on port 9876...");
byte[] receiveData = new byte[1024];
while (true) {
// Create a DatagramPacket to receive data from the client
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
// Receive data from the client
socket.receive(receivePacket);
// Extract message from the packet
String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
System.out.println("Received message: " + message);
// Get client's address and port to send a response
InetAddress clientAddress = receivePacket.getAddress();
int clientPort = receivePacket.getPort();
// Prepare response message
String responseMessage = "Message received: " + message;
byte[] sendData = responseMessage.getBytes();
// Send the response to the client
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
socket.send(sendPacket);
System.out.println("Response sent to client.");
}
} catch (Exception e) {
e.printStackTrace();
} finally {
if (socket != null && !socket.isClosed()) {
socket.close();
}
}
}
}
