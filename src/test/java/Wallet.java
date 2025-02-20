import java.util.*;

public class Wallet {
    int total = 0;
    private Owner owner;
    private ArrayList<Card> listkartu;
    private ArrayList<Money> listuang;
    List<Integer> nilaiTidakMungkin = ImpossibleMoney.getImpossibleMoney();
//    List<Integer> nilaiTidakMungkin = ImpossibleMoney.getImpossibleMoney();

    public Wallet(Owner owner) {
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
        if(!listkartu.contains(kartu)){
            for(Card itemkartu : listkartu){
                if(itemkartu.getCardNumber()==kartu.getCardNumber()){
                    listkartu.add(kartu);
                }
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
        if(!nilaiTidakMungkin.contains(banknote)){
            listuang.add(banknote);
        }
    }
    public void addMoneyCoin(Coin coin){
        if(!nilaiTidakMungkin.contains(coin)) {
            listuang.add(coin);
        }
    }
    public double saldo(){
        for (Money money : listuang) {
            total += money.getNominal();
        }
        return total;
    }
    public void withdraw(double money){
        if(saldo()>money && !nilaiTidakMungkin.contains(money)){
            total-=money;
        }
    }


}
