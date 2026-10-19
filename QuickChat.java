import java.util.Scanner;

public class QuickChat {
    private static class Message {
        private final String recipient;
        private final String text;
        private static int totalMessages;

        Message(String recipient, String text) {
            this.recipient = recipient;
            this.text = text;
        }

        String checkRecipientCell() {
            return recipient == null || recipient.trim().isEmpty()
                    ? "Invalid recipient number."
                    : "Recipient number accepted.";
        }

        String SentMessage(int action) {
            if (action == 1) {
                totalMessages++;
                return "Message sent.";
            }
            if (action == 2) {
                return "Message discarded.";
            }
            if (action == 3) {
                return "Message stored.";
            }
            return "Invalid action.";
        }

        String createMessageHash() {
            return Integer.toHexString((recipient + text).hashCode());
        }

        static int returnTotalMessages() {
            return totalMessages;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if(user.equals("admin") && pass.equals("1234")) {
            System.out.println("Welcome to QuickChat.");
        } else {
            System.out.println("Login failed.");
            sc.close();
            return;
        }

        boolean running = true;
        while(running) {
            System.out.println("\nMenu:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("How many messages do you want to send? ");
                    int num = sc.nextInt();
                    sc.nextLine();

                    for(int i=0; i<num; i++) {
                        System.out.print("Enter recipient number: ");
                        String recipient = sc.nextLine();
                        System.out.print("Enter message text: ");
                        String msgText = sc.nextLine();

                        if(msgText.length() > 250) {
                            System.out.println("Message exceeds 250 characters by " + (msgText.length()-250) + "; please reduce the size.");
                            continue;
                        }

                        Message m = new Message(recipient, msgText);
                        System.out.println(m.checkRecipientCell());
                        System.out.println("Choose action: 1) Send 2) Discard 3) Store");
                        int action = sc.nextInt();
                        sc.nextLine();
                        System.out.println(m.SentMessage(action));
                        System.out.println("Message Hash: " + m.createMessageHash());
                    }
                    System.out.println("Total messages sent: " + Message.returnTotalMessages());
                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
