import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    //kurang jumlah digitnya
    @Test
    void TestIsValidCardNumber(){
        Card kartu1 = new Card("ATM", "101010a");
        Assertions.assertFalse(kartu1.isValidCardNumber(kartu1.getCardNumber()));
    }

}