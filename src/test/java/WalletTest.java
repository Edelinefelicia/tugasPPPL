import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    void testSetOwner() {
        Owner owner1 = new Owner("budi", 19, "Yogya");
//        Owner owner2 = new Owner("andi", 10, "Jakarta");
//        Wallet dompet1 = new Wallet(owner2);
        Wallet dompet2 = new Wallet(owner1);
        dompet2.getOwner();
//        dompet1.getOwner();
        Assertions.assertEquals(owner1,dompet2);
//        Assertions.assertEquals(owner2,dompet1);
    }

    @Test
    void addCard() {
        Card kartu1 = new Card("ATM", "101010aa");
        Card kartu2 = new Card("KartuPelajar", "10101010");
        Card kartu3 = new Card("ATM2", "10101010");
        kartu.a
    }

    @Test
    void getCard() {
    }

    @Test
    void addMoneyBanknote() {
    }

    @Test
    void addMoneyCoin() {
    }

    @Test
    void saldo() {
    }

    @Test
    void withdraw() {
    }
}