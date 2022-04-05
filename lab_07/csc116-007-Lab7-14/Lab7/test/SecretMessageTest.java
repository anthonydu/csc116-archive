import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests SecretMessage program, which encrypts and decrypts messages
 *
 * @author Jessica Young Schmidt
 * @author Anthony Du
 * @author Shuhao Liu
 */
public class SecretMessageTest {

    /**
     * Tests swapCharacter method - If first and last characters are letters,
     * swap first and last characters of message.
     */
    @Test
    public void testSwapCharacterEncryptHello() {
        assertEquals("oellH", SecretMessage.swapCharacter("Hello"),
                "Tests swapCharacter if first and last characters are letters");
    }

    /**
     * Tests swapCharacter method - If first character is digit,
     * swap second and next to last characters of message.
     */
    @Test
    public void testSwapCharacterEncrypt6Hello() {
        assertEquals("6lelHo", SecretMessage.swapCharacter("6Hello"),
                "Tests swapCharacter if first character is digit");
    }

    /**
     * Tests swapCharacter method - If first character is not a digit
     * and last character is not a letter, swap second and next to last characters of message.
     */
    @Test
    public void testSwapCharacterEncryptBeijing2022() {
        assertEquals("Beijing2022", SecretMessage.swapCharacter("Beijing2022"),
                "Tests swapCharacter for all other cases");
    }

    /**
     * Tests moveCharacter method - Move character at index (length - 2) to the end
     * of the string
     */
    @Test
    public void testMoveCharacterEncryptHello() {
        assertEquals("oelHl", SecretMessage.moveCharacter("oellH"),
                "Tests moveCharacter for string of length 5");
    }

    /**
     * Tests moveCharacter method - Move character at index (length - 2) to the end
     * of the string
     */
    @Test
    public void testMoveCharacterEncryptYes() {
        assertEquals("Yse", SecretMessage.moveCharacter("Yes"),
                "Tests moveCharacter for string of length 3");
    }

    /**
     * Tests moveCharacter method - Move character at index (length - 2) to the end
     * of the string
     */
    @Test
    public void testMoveCharacterEncryptHi() {
        assertEquals("iH", SecretMessage.moveCharacter("Hi"),
                "Tests moveCharacter for string of length 2");
    }

    /**
     * Tests swapSubstrings method - If length is odd and not divisible by three,
     * leave middle character as is and swap substrings before and after it.
     */
    @Test
    public void testSwapSubstringsEncryptHello() {
        assertEquals("lolHe", SecretMessage.swapSubstrings("Hello"),
                "Tests swapSubstrings if length is odd and not divisible by three");
    }

    /**
     * Tests swapSubstrings method - If length is odd and divisible by three,
     * swap first third of message with last third of message.
     */
    @Test
    public void testSwapSubstringsEncryptHelloaqwe() {
        assertEquals("Helloaqwe", SecretMessage.swapSubstrings("qweloaHel"),
                "Tests swapSubstrings if length is odd and divisible by three");
    }

    /**
     * Tests swapSubstrings method - If length is even,
     * swap first half of message with second half of message.
     */
    @Test
    public void testSwapSubstringsEncryptHelloa() {
        assertEquals("Helloa", SecretMessage.swapSubstrings("loaHel"),
                "Tests swapSubstrings if length is even");
    }

    /**
     * Tests encrypt method - where
     * (1) first and last characters are letters and
     * (2) length is odd and not divisible by three
     */
    @Test
    public void testEncryptHello() {
        assertEquals("Hlloe", SecretMessage.encrypt("Hello"), "Tests encrypting Hello to Hlloe");
    }

    /**
     * Tests encrypt method - where
     * (1) first character is not a number and the last character is not a letter and
     * (2) length is odd and divisible by three
     */
    @Test
    public void testEncryptWintergames2022() {
        assertEquals("s2022rgameWinte", SecretMessage.encrypt("Wintergames2022"),
                        "Tests encrypting wintergames2022 to s2022rgamewinte");
    }

    /**
     * Tests encrypt method - where
     * (1) the first character is a number and
     * (2) length is even
     */
    @Test
    public void testEncrypt2022BJ() {
        assertEquals("2J02B2", SecretMessage.encrypt("2022BJ"),
                        "Tests encrypting 2022BJ to 2J02B2");
    }

    /**
    * Tests encrypt method - where the message length is less than three
    */
    @Test
    public void testEncryptHi() {
        assertEquals("Hi", SecretMessage.encrypt("Hi"),
                    "Tests encrypting message with length less than three");
    }

    /**
     * Tests decrypt method - where (1) length is odd and not divisible by three and
     * (2) first and last characters are letters
     */
    @Test
    public void testDecryptHlloe() {
        assertEquals("Hello", SecretMessage.decrypt("Hlloe"), "Tests decrypting Hlloe to Hello");
    }

    /**
     * Tests decrypt method - where
     * (1) first character is not a number and the last character is not a letter and
     * (2) length is odd and divisible by three
     */
    @Test
    public void testDecryptWintergames2022() {
        assertEquals("Wintergames2022", SecretMessage.decrypt("s2022rgameWinte"),
                        "Tests decrypting s2022rgamewinte to wintergames2022");
    }

    /**
     * Tests decrypt method - where
     * (1) the first character is a number and
     * (2) length is even
     */
    @Test
    public void testDecrypt2022BJ() {
        assertEquals("2022BJ", SecretMessage.decrypt("2J02B2"),
                    "Tests decrypting 2J02B2 to 2022BJ");
    }

    /**
    * Tests decrypt method - where the message length is less than three
    */
    @Test
    public void testDecryptHi() {
        assertEquals("Hi", SecretMessage.decrypt("Hi"),
                    "Tests decrypting message with length less than three");
    }

    /**
     * Tests moveCharacter method for invalid length
     */
    @Test
    public void testMoveCharacterInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> SecretMessage.moveCharacter("A"));
        assertEquals("Invalid string", exception.getMessage(),
                "Tests invalid length for moveCharacter method");
    }
}
