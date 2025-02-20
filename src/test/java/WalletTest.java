import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    Owner owner1 = new Owner("budi", 19, "Yogya");
    Owner owner2 = new Owner("andi", 10, "Jakarta");
    Owner owner3 = new Owner("edeline", 20, "Bogor");
    Owner owner4= new Owner("kenzo", 15, "Jakarta");
    Owner owner5 = new Owner("belda", 21, "Bogor");
    Owner owner6 = new Owner("farhan", 21, "Bogor");
    Owner owner7 = new Owner("naran", 29, "Bogor");
    Owner owner8 = new Owner("farhan", 21, "Bogor");
    Owner owner9 = new Owner("kevin", 22, "Bogor");
    Owner owner10 = new Owner("siti", 23, "Bogor");
    Owner owner11 = new Owner("hanif", 24, "Bogor");
    Wallet dompet1 = new Wallet(owner2);
    Wallet dompet2 = new Wallet(owner1);
    Wallet dompet3 = new Wallet(owner3);
    Wallet dompet4 = new Wallet(owner4);
    Wallet dompet5 = new Wallet(owner5);
    Wallet dompet6 = new Wallet(owner6);
    Wallet dompet7 = new Wallet(owner7);
    Wallet dompet8 = new Wallet(owner8);
    Wallet dompet9 = new Wallet(owner9);
    Wallet dompet10 = new Wallet(owner10);
    Wallet dompet11 = new Wallet(owner11);


    @Test
    void testSetOwner() {
        Assertions.assertEquals(owner1,dompet2.getOwner());
        Assertions.assertEquals(owner2,dompet1.getOwner());
    }

    @Test
    void testAddCard() {
        Card kartu1 = new Card("ATM", "10101010");
        Card kartu2 = new Card("KartuPelajar", "10101020");
        dompet1.addCard(kartu1);
        dompet1.addCard(kartu2);
        Assertions.assertEquals(kartu1.getName(), dompet1.getListkartu().get(0).getName());
        Assertions.assertEquals(kartu2.getName(), dompet1.getListkartu().get(1).getName());
    }

    @Test
    void testAddCardIfIsExisted() {
        Card kartu1 = new Card("ATM", "10101010");
        Card kartu2 = new Card("ATM2", "10101010");
        dompet2.addCard(kartu1);
        dompet2.addCard(kartu2);
        Assertions.assertEquals(1, dompet2.getListkartu().size());
        Assertions.assertFalse(dompet2.getListkartu().contains(kartu2));
    }


    @Test
    void testAmbilCard() {
        Card kartu1 = new Card("ATM", "10101010");
        Card kartu2 = new Card("ATM2", "10101020");
        dompet3.addCard(kartu1);
        dompet3.addCard(kartu2);
        dompet3.ambilCard(kartu2);
        Assertions.assertEquals(1, dompet3.getListkartu().size());
        Assertions.assertFalse(dompet3.getListkartu().contains(kartu2));
    }

    @Test
    void testAddMoneyBanknoteTrue() {
        //karena tulisannya 'menambahkan uang rupiah',maka dianggap pengguna ingin semua uang yang dimasukkan merupakan banknote bukan koin
        Banknote uang1 = new Banknote(3000);
        Banknote uang2 = new Banknote(5000);
        dompet4.addMoneyBanknote(uang2);
        dompet4.addMoneyBanknote(uang1);
        Assertions.assertEquals(2, dompet4.getListuang().size());
        Assertions.assertEquals(uang2.getNominal(), dompet4.getListuang().get(0).getNominal());
        Assertions.assertEquals(uang1.getNominal(), dompet4.getListuang().get(1).getNominal());
    }

    @Test
    void testAddMoneyBanknoteFalse() {
        Banknote uang1 = new Banknote(20020);
        dompet5.addMoneyBanknote(uang1);
        Assertions.assertEquals(0, dompet5.getListuang().size());
        Assertions.assertFalse(dompet5.getListuang().contains(uang1));
    }

    @Test
    void testAddMoneyCoinTrue() {
        Coin uang1 = new Coin(1000);
        Coin uang2 = new Coin(5000);
        dompet6.addMoneyCoin(uang1);
        dompet6.addMoneyCoin(uang2);
        Assertions.assertEquals(2, dompet6.getListuang().size());
        Assertions.assertEquals(uang1.getNominal(), dompet6.getListuang().get(0).getNominal());
        Assertions.assertEquals(uang2.getNominal(), dompet6.getListuang().get(1).getNominal());
    }

    @Test
    void testAddMoneyCoinFalse() {
        Coin uang1 = new Coin(2001);
        dompet7.addMoneyCoin(uang1);
        Assertions.assertEquals(0, dompet7.getListuang().size());
        Assertions.assertFalse(dompet7.getListuang().contains(uang1));
    }

    @Test
    void testSaldo() {
        Coin uang1 = new Coin(1000);
        Coin uang2 = new Coin(5000);
        Banknote uang3 = new Banknote(3000);
        Banknote uang4 = new Banknote(5000);
        dompet8.addMoneyBanknote(uang3);
        dompet8.addMoneyBanknote(uang4);
        dompet8.addMoneyCoin(uang1);
        dompet8.addMoneyCoin(uang2);
        Assertions.assertEquals(14000,dompet8.saldo());
    }

    @Test
    void testNoSaldo() {
        Assertions.assertEquals(0,dompet9.saldo());
    }

    @Test
    void withdrawFalse() {
        Coin uang1 = new Coin(1000);
        Coin uang2 = new Coin(5000);
        Banknote uang3 = new Banknote(3000);
        Banknote uang4 = new Banknote(5000);
        dompet9.addMoneyBanknote(uang3);
        dompet9.addMoneyBanknote(uang4);
        dompet9.addMoneyCoin(uang1);
        dompet9.addMoneyCoin(uang2);
        Assertions.assertEquals("Saldo tidak mencukupi",dompet9.withdraw(15000));
    }

    @Test
    void withdrawTrue() {
        Coin uang1 = new Coin(1000);
        Coin uang2 = new Coin(5000);
        Banknote uang3 = new Banknote(3000);
        Banknote uang4 = new Banknote(5000);
        dompet10.addMoneyBanknote(uang3);
        dompet10.addMoneyBanknote(uang4);
        dompet10.addMoneyCoin(uang1);
        dompet10.addMoneyCoin(uang2);
        Assertions.assertEquals("Saldo mencukupi",dompet10.withdraw(14000));
    }
}