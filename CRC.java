public class CRC {
// Perform XOR between two binary strings
static String xor(String a, String b) {
StringBuilder result = new StringBuilder();
for (int i = 1; i < b.length(); i++) {
result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
}
return result.toString();
}
// Perform CRC division and return remainder
static String mod2Division(String dividend, String divisor) {
int pick = divisor.length();
String tmp = dividend.substring(0, pick);
while (pick < dividend.length()) {
if (tmp.charAt(0) == '1') {
tmp = xor(divisor, tmp) + dividend.charAt(pick);
} else {
tmp = xor("0".repeat(pick), tmp) + dividend.charAt(pick);
}
pick++;
}
// Last step
if (tmp.charAt(0) == '1') {
tmp = xor(divisor, tmp);
} else {
tmp = xor("0".repeat(pick), tmp);
}
return tmp;
}
public static void main(String[] args) {
String data = "1100";
String generator = "1011";
// Append 0s equal to generator degree
String appendedData = data + "000";
// Sender side: calculate remainder and generate CRC code
String remainder = mod2Division(appendedData, generator);
String transmittedCode = data + remainder;
System.out.println("Sender Side:");
System.out.println("Original Data: " + data);
System.out.println("CRC Remainder: " + remainder);
System.out.println("Transmitted Codeword: " + transmittedCode);
// Receiver side: receive the codeword
String receivedCodeword = transmittedCode; // simulate correct transmission
// To simulate error, uncomment this line:
// receivedCodeword = "1100110"; // Flip a bit to introduce error
// Receiver checks for error
String receiverRemainder = mod2Division(receivedCodeword, generator);
boolean errorDetected = !receiverRemainder.contains("1");
System.out.println("\nReceiver Side:");
System.out.println("Received Codeword: " + receivedCodeword);
System.out.println("Remainder After Division: " + receiverRemainder);
if (errorDetected) {
System.out.println("No Error Detected in Received Data.");
} else {
System.out.println("Error Detected in Received Data!");
}
}
}




/* ALGORITHM
Algorithm: CRC Calculation
Input: Data bits, Generator polynomial (in binary)
Output: CRC bits and Transmitted frame
1. Convert the polynomial generator into binary.
2. Append n-1 zeros to the data bits (n = number of bits in generator).
3. Perform binary division (modulo-2 division) of the new data by the generator:
	a. Align the divisor with the leftmost 1 of the dividend.
	b. XOR the divisor with the aligned bits of dividend.
	c. Bring down the next bit from dividend.
	d. Repeat until all bits are processed.
4. The final remainder after division is the CRC bits.
5. Append the CRC bits to the original data to form the transmitted frame.
End. */
