import java.util.*;

public class ImpossibleMoney {
    public static List<Integer> getImpossibleMoney() {
        int[] denominasi = {100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000, 100000};
        Set<Integer> bisaDibentuk = new HashSet<>();
        bisaDibentuk.add(0);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int uang : denominasi) {
                int next = current + uang;
                if (!bisaDibentuk.contains(next)) {
                    bisaDibentuk.add(next);
                    queue.add(next);
                }
            }
        }

        List<Integer> tidakMungkinDimiliki = new ArrayList<>();
        for (int i = 1; i < Collections.max(bisaDibentuk) + 1000; i++) {
            if (!bisaDibentuk.contains(i)) {
                tidakMungkinDimiliki.add(i);
            }
        }

        return tidakMungkinDimiliki;
    }

    public static void main(String[] args) {
        List<Integer> hasil = getImpossibleMoney();
        System.out.println("Nilai uang yang tidak mungkin dimiliki:");
        System.out.println(hasil);
    }
}
