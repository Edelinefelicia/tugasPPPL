import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    //kurang jumlah digitnya
    @Test
    void TestIsValidCardNumberAmount(){
        Card kartu1 = new Card("ATM", "101010");
        Assertions.assertFalse(kartu1.isValidCardNumber(kartu1.getCardNumber()));
    }

    //kurang mengandung huruf
    @Test
    void TestIsValidCardNumberLetter(){
        Card kartu2 = new Card("ATM", "101010aa");
        Assertions.assertFalse(kartu2.isValidCardNumber(kartu2.getCardNumber()));
    }

    //valid
    @Test
    void TestIsValidCardNumberValid(){
        Card kartu1 = new Card("ATM", "10101010");
        Assertions.assertTrue(kartu1.isValidCardNumber(kartu1.getCardNumber()));
    }

}