import java.util.*;

public class SBPC {
    static int calculateParity(String binary) {
        int count = 0;
        for (char bit : binary.toCharArray()) {
            if (bit == '1') {
                count++;
            }
        }
        return count % 2;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Sender Side
        System.out.println("Enter the binary number: ");
        String binaryInput = scanner.nextLine();
        int parityBit = calculateParity(binaryInput);
        String transmittedData = binaryInput + parityBit;
        System.out.println("Transmitted data with parity bit: " + transmittedData);

        // Receiver Side
        System.out.println("Enter received binary data: ");
        String receivedData = scanner.nextLine();

        // Separate data and parity bit
        String receivedBinary = receivedData.substring(0, receivedData.length() - 1);
        int receivedParityBit = Character.getNumericValue(receivedData.charAt(receivedData.length() - 1));

        int calculatedParity = calculateParity(receivedBinary); // fixed name here

        if (calculatedParity == receivedParityBit) {
            System.out.println("No error detected in the received data.");
        } else {
            System.out.println("Error detected in the received data.");
        }

        scanner.close(); // fixed method call here
    }
}



/*ALGORITHM
Algorithm: Check_Single_Bit_Parity
Input: A binary string of n bits including 1 parity bit (e.g., 8 bits where 1 is parity)
Parity_Type (Even or Odd)
Output: Message indicating whether the data has an error
Step 1: Initialize count ← 0
Step 2: For i ← 0 to n-1
If bit[i] == 1 then
count ← count + 1
Step 3: If Parity_Type == "Even" then
If count % 2 == 0 then
Print "No Error Detected"
Else
Print "Error Detected"
Else If Parity_Type == "Odd" then
If count % 2 == 1 then
Print "No Error Detected"
Else
Print "Error Detected"
*/
