import java.util.Scanner;

public class first {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long sd, rd;
        int i, senderOnes = 0, receiverOnes = 0;
        char c;
        String ssd, srd;

        // Sender input
        System.out.print("Enter Sender in Binary: ");
        sd = sc.nextLong();
        ssd = String.valueOf(sd);

        for (i = 0; i < ssd.length(); i++) {
            c = ssd.charAt(i);
            if (c == '1')
                senderOnes++;
            else if (c != '0') {
                System.out.println("Invalid input in sender!");
                return;
            }
        }

        // Receiver input
        System.out.print("Enter Receiver in Binary: ");
        rd = sc.nextLong();
        srd = String.valueOf(rd);

        for (i = 0; i < srd.length(); i++) {
            c = srd.charAt(i);
            if (c == '1')
                receiverOnes++;
            else if (c != '0') {
                System.out.println("Invalid input in receiver!");
                return;
            }
        }

        // Even parity check
        if (senderOnes % 2 == receiverOnes % 2)
            System.out.println("No Error in Data Transmission.");
        else
            System.out.println("Error Detected in Data Transmission.");
    }
}

