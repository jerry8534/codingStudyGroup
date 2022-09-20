import java.util.Scanner;
import java.util.HashMap;


public class main {
    public static void main(String[] args) {
        while () {
            if (machine.wantBuy()) break;
            int coin = person.insertCoin();
            machine.showItems();
            int selected = person.choice();
            int payResult = machine.giveItem();
            machine.backCoin(payResult);
        }
    }
}

class machine {
    static Scanner scanner = new Scanner(System.in);
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(1,1000);
    map.put(2,800);
    map.put(3,1200);
    map.put(4,1500);
    map.put(5,1900);

    static HashMap<Integer, Integer> map2 = new HashMap<>();
    map2.put(1,23);
    map2.put(2,12);
    map2.put(3,32);
    map2.put(4,15);
    map2.put(5,27);

    public static boolean wantBuy() {
        System.out.println("물건을 구매하시겠습니까?");
        String answer = scanner.next();
        if (answer == "n") {
            return true
        } ;
    }

    public static void showItems() {
        System.out.println("원하시는 물건을 선택하세요.");
        System.out.println("1. cola 2. water 3. beer 4. coffee 5. isodrink");
    }

    public static Integer giveItem(int selected){
    private Integer coin;
        if (map2.key(selected) <= 0) {
            System.out.println("선택하신 물건의 수량이 부족합니다.");
            return coin;
        }
        if (map.key(selected) > coin) {
            System.out.println("투입하신 요금이 부족합니다.");
            return coin;
        }
        map2.values[selected] -= 1;
        coin -= map.values[selected];
        return coin;
    }

    public static Integer backCoin(Integer payResult) {
        System.out.printf("잔액 %d원을 반환합니다.%n감사합니다.%n", payResult);
        return 0;
    }
}
class person {
    static Scanner scanner = new Scanner(System.in);

    public static Integer insertCoin() {
        System.out.println("동전을 투입하세요.");
        String coin = String.valueOf(scanner.nextInt());
        return Integer.parseInt(coin);
    }

    public static Integer choice() {
        Integer num;
        num = scanner.nextInt();
        int i = Integer.parseInt(String.valueOf(num)) - 1;
        return i;
    }
}