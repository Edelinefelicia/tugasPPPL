import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    Owner owner1 = new Owner("budi", 19, "Yogya");
    //        Owner owner2 = new Owner("andi", 10, "Jakarta");
//        Wallet dompet1 = new Wallet(owner2);
    Wallet dompet2 = new Wallet(owner1);
    private Card kartu1, kartu3, kartu2;

    @Test
    void testSetOwner() {
        dompet2.getOwner();
//        dompet1.getOwner();
        Assertions.assertEquals(owner1,dompet2);
//        Assertions.assertEquals(owner2,dompet1);
    }

    @Test
    void testAddCard() {
        kartu1 = new Card("ATM", "101010aa");
        kartu2 = new Card("KartuPelajar", "10101010");
        dompet2.addCard(kartu2);
        dompet2.addCard(kartu1);
        Assertions.assertEquals(kartu1.getName(), dompet2.getListkartu().get(0).getName());
        Assertions.assertEquals(kartu2.getName(), dompet2.getListkartu().get(1).getName());
    }

    @Test
    void testAddCardIsExisted() {
//        Card kartu1 = new Card("ATM", "101010aa");
        kartu3 = new Card("ATM2", "101010aa");
//        dompet2.addCard(kartu1);
        dompet2.addCard(kartu3);
        Assertions.assertEquals(2, dompet2.getListkartu().size());
        Assertions.assertFalse(dompet2.getListkartu().contains(kartu3));
    }


    @Test
    void testAmbilCard() {
        dompet2.ambilCard(kartu2);
        Assertions.assertEquals(1, dompet2.getListkartu().size());
        Assertions.assertFalse(dompet2.getListkartu().contains(kartu2));
    }

    @Test
    void addMoneyBanknoteTrue() {
        //karena tulisannya 'menambahkan uang rupiah',maka dianggap pengguna ingin semua uang yang dimasukkan merupakan banknote bukan koin
        Banknote uang1 = new Banknote(3000);
        Banknote uang2 = new Banknote(5000);
        dompet2.addMoneyBanknote(uang2);
        dompet2.addMoneyBanknote(uang1);
        Assertions.assertEquals(2, dompet2.getListuang().size());
        Assertions.assertEquals(uang2.getNominal(), dompet2.getListuang().get(0));
        Assertions.assertEquals(uang1.getNominal(), dompet2.getListuang().get(1));
    }

    @Test
    void addMoneyBanknoteFalse() {
        Banknote uang3 = new Banknote(20020);
        dompet2.addMoneyBanknote(uang3);
        Assertions.assertEquals(2, dompet2.getListuang().size());
        Assertions.assertFalse(dompet2.getListuang().contains(uang3));
    }

    @Test
    void addMoneyCoinTrue() {
        Coin uang4 = new Coin(1000);
        Coin uang5 = new Coin(5000);
        dompet2.addMoneyCoin(uang4);
        dompet2.addMoneyCoin(uang5);
        Assertions.assertEquals(2, dompet2.getListuang().size());
        Assertions.assertEquals(uang4.getNominal(), dompet2.getListuang().get(0));
        Assertions.assertEquals(uang5.getNominal(), dompet2.getListuang().get(1));
    }

    @Test
    void addMoneyCoinFalse() {
        Coin uang6 = new Coin(2001);
        dompet2.addMoneyCoin(uang6);
        Assertions.assertEquals(2, dompet2.getListuang().size());
        Assertions.assertEquals(uang6.getNominal(), dompet2.getListuang().get(0));
    }

    @Test
    void saldo() {
    }

    @Test
    void withdraw() {
    }
}