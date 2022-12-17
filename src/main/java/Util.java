import java.security.SecureRandom;

public class Util {
    public static void waiter(int timeSeconds) {
        try {
            Thread.sleep(timeSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static String generateRandomInput(int len) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
}
