import java.util.*;

public class Wallet {
    int total = 0;
    private Owner owner;
    private ArrayList<Card> listkartu;
    private ArrayList<Money> listuang;
    private  boolean isDuplicate = false;

//    List<Integer> nilaiTidakMungkin = ImpossibleMoney.getImpossibleMoney();
//    List<Integer> nilaiTidakMungkin = ImpossibleMoney.getImpossibleMoney();

    public Wallet(Owner owner) {
        this.owner = owner;
        this.listkartu = new ArrayList<Card>();
        this.listuang = new ArrayList<Money>();
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    // Fungsi untuk menambahkan kartu ke dalam dompet
    public void addCard(Card kartu) {
        System.out.println("hiiiiii");
        if(listkartu==null){
            listkartu.add(kartu);
        }
        if(!listkartu.contains(kartu)){
            System.out.println("hii");
            for (Card itemkartu : listkartu) {
                if (itemkartu.getCardNumber().equals(kartu.getCardNumber())) {
                    isDuplicate = true;
                    break; // Jika sudah ditemukan, keluar dari loop
                }
            }

            if (!isDuplicate) {
                listkartu.add(kartu); // Tambahkan kartu hanya jika tidak duplikat
            }
        }
    }

    public ArrayList<Card> getListkartu() {
        return listkartu;
    }

    public void setListkartu(ArrayList<Card> listkartu) {
        this.listkartu = listkartu;
    }

    public ArrayList<Money> getListuang() {
        return listuang;
    }

    public void setListuang(ArrayList<Money> listuang) {
        this.listuang = listuang;
    }

    public void ambilCard(Card kartu){
        if(listkartu.contains(kartu)){
            listkartu.remove(kartu);
        }
    }

    public void addMoneyBanknote(Banknote banknote){
        if(!ImpossibleMoney.getImpossibleMoney(banknote.getNominal())){
            listuang.add(banknote);
        }
    }
    public void addMoneyCoin(Coin coin){
        if(!ImpossibleMoney.getImpossibleMoney(coin.getNominal())) {
            listuang.add(coin);
        }
    }
    public double saldo(){
        for (Money money : listuang) {
            total += money.getNominal();

            System.out.println(money.getNominal());
        }
        return total;
    }
    public String withdraw(double money){
        if(saldo()>money && ImpossibleMoney.getImpossibleMoney((int) money)){
            total-=money;
        }
        return "Saldo tidak mencukupi";
    }


}
