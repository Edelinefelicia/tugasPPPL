import java.util.regex.Pattern;

public class Card {
    private String name;
    private String cardNumber;

    // Constructor
    public Card(String name, String cardNumber) {
        if (!isValidCardNumber(cardNumber)) {
            System.out.println("Nomor kartu tidak valid!");
        }
        this.name = name;
        this.cardNumber = cardNumber;
    }

    // Getter untuk nama kartu
    public String getName() {
        return name;
    }

    // Getter untuk nomor kartu
    public String getCardNumber() {
        return cardNumber;
    }

    // Validasi nomor kartu (harus berupa angka dan panjang minimal 8 digit)
    public boolean isValidCardNumber(String cardNumber) {

        return Pattern.matches("\\d{8,}", cardNumber);
    }
}
