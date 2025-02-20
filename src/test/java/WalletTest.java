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
    Wallet dompet1 = new Wallet(owner2);
    Wallet dompet2 = new Wallet(owner1);
    Wallet dompet3 = new Wallet(owner3);
    Wallet dompet4 = new Wallet(owner4);
    Wallet dompet5 = new Wallet(owner5);
    Wallet dompet6 = new Wallet(owner6);
    Wallet dompet7 = new Wallet(owner7);
    Wallet dompet9 = new Wallet(owner8);


    @Test
    void testSetOwner() {
//        owner1  = new Owner("budi", 19, "Yogya");
//        dompet2 = new Wallet(owner1);
//        dompet2.getOwner();
//        dompet1.getOwner();
        Assertions.assertEquals(owner1,dompet2.getOwner());
        Assertions.assertEquals(owner2,dompet1.getOwner());
//        Assertions.assertEquals(owner2,dompet1);
    }

    @Test
    void testAddCard() {
        Card kartu1 = new Card("ATM", "10101010");
        Card kartu2 = new Card("KartuPelajar", "10101020");
        dompet1.addCard(kartu1);
        dompet1.addCard(kartu2);
//        System.out.println("kartu1"+dompet2.getListkartu());
        Assertions.assertEquals(kartu1.getName(), dompet1.getListkartu().get(0).getName());
        Assertions.assertEquals(kartu2.getName(), dompet1.getListkartu().get(1).getName());
    }

    @Test
    void testAddCardIsExisted() {
//        Card kartu1 = new Card("ATM", "101010aa");
        Card kartu1 = new Card("ATM", "10101010");
        Card kartu2 = new Card("ATM2", "10101010");
        dompet2.addCard(kartu1);
        dompet2.addCard(kartu2);
        Assertions.assertEquals(1, dompet2.getListkartu().size());
//        System.out.println(kartu3);
//        System.out.println(dompet2.getListkartu());
        Assertions.assertFalse(dompet2.getListkartu().contains(kartu2));
    }


    @Test
    void testAmbilCard() {
        Card kartu1 = new Card("ATM", "10101010");
        Card kartu2 = new Card("ATM2", "10101010");
        dompet3.addCard(kartu1);
        dompet3.addCard(kartu2);
        dompet3.ambilCard(kartu2);
        System.out.println(dompet3.getListkartu().getFirst().getName());
        Assertions.assertEquals(1, dompet3.getListkartu().size());
        Assertions.assertFalse(dompet3.getListkartu().contains(kartu2));
    }

    @Test
    void addMoneyBanknoteTrue() {
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
    void addMoneyBanknoteFalse() {
        Banknote uang1 = new Banknote(20020);
        dompet5.addMoneyBanknote(uang1);
        Assertions.assertEquals(0, dompet5.getListuang().size());
        Assertions.assertFalse(dompet5.getListuang().contains(uang1));
    }

    @Test
    void addMoneyCoinTrue() {
        Coin uang1 = new Coin(1000);
        Coin uang2 = new Coin(5000);
        dompet2.addMoneyCoin(uang1);
        dompet2.addMoneyCoin(uang2);
        Assertions.assertEquals(2, dompet2.getListuang().size());
        Assertions.assertEquals(uang1.getNominal(), dompet2.getListuang().get(0).getNominal());
        Assertions.assertEquals(uang2.getNominal(), dompet2.getListuang().get(1).getNominal());
    }

    @Test
    void addMoneyCoinFalse() {
        Coin uang1 = new Coin(2001);
        dompet2.addMoneyCoin(uang1);
        Assertions.assertEquals(0, dompet2.getListuang().size());
        Assertions.assertFalse(dompet2.getListuang().contains(uang1));
        System.out.println(dompet2);
    }

    @Test
    void saldo() {
w
        System.out.println(dompet2.saldo());
        Assertions.assertEquals(14000,dompet2.saldo());
    }

    @Test
    void withdrawFalse() {
        Assertions.assertEquals("Saldo tidak mencukupi",dompet2.withdraw(14000));
    }

    @Test
    void withdrawTrue() {
        Assertions.assertEquals("Saldo tidak mencukupi",dompet2.withdraw(12000));
    }
}