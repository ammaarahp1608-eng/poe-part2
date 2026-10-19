public class Message {
        private static int totalMessages = 0;
        private String messageID;
        private String recipient;
        String messageText;
        private String messageHash;

        public Message(String string, String string2, int i) {
            //TODO Auto-generated constructor stub
        }

        public static void main(String[] args) {
        }

        public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    String checkRecipientCell(String recipient) {
        if (recipient.length() <= 10 && recipient.startsWith("+")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    String createMessageHash() {
        String[] words = messageText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        messageHash = messageID.substring(0,2) + ":" + totalMessages + ":" + firstWord + lastWord;
        return messageHash.toUpperCase();
    }

    String sentMessage(String option) {
        switch(option) {
            case "Send": return "Message successfully sent.";
            case "Discard": return "Press 0 to delete the message.";
            case "Store": return "Message successfully stored.";
            default: return "Invalid option.";
        }
    }

    String printMessages() {
        return "ID: " + messageID + " | Hash: " + messageHash + " | Recipient: " + recipient + " | Message: " + messageText;
    }

    public static int returnTotalMessages() {
        return totalMessages;
    }

    public void storeMessage() {
        System.out.println("Message stored in JSON file (to be implemented).");
    }
}

