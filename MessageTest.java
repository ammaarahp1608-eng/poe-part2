public class MessageTest {
    public static void main(String[] args) {
        MessageTest test = new MessageTest();
        test.testMessageLengthSuccess();
        test.testMessageLengthFailure();
        test.testRecipientSuccess();
        test.testRecipientFailure();
        test.testMessageHash();
    }

    public void testMessageLengthSuccess() {
        Message m = new Message("Hi Mike, can you join us for dinner tonight?", "+27718693002", 1);
        check(m.messageText.length() <= 250, "Message should be at most 250 characters");
    }

    public void testMessageLengthFailure() {
        String longMsg = "a".repeat(300);
        Message m = new Message(longMsg, "+27718693002", 2);
        check(m.messageText.length() > 250, "Long message should exceed 250 characters");
    }

    public void testRecipientSuccess() {
        Message m = new Message("Hello", "+27718693002", 3);
        check("Cell phone number successfully captured.".equals(m.checkRecipientCell("+27718693002")),
            "Expected: Cell phone number successfully captured.");
    }

    public void testRecipientFailure() {
        Message m = new Message("Hello", "08575975889", 4);
        check("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again."
            .equals(m.checkRecipientCell("08575975889")),
            "Recipient number should be rejected when incorrectly formatted");
    }

    public void testMessageHash() {
        Message m = new Message("Hi Mike, can you join us for dinner tonight?", "+27718693002", 5);
        String hash = m.createMessageHash();
        check(hash.contains("HI") && hash.contains("TONIGHT"), "Hash should contain the first and last words");
    }

    private void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

}
