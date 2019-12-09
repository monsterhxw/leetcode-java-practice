package algorithm;

public class Main {

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        // 输出: 3
        System.out.println(mapSum.sum("app"));

        mapSum.insert("app", 2);
        // 输出: 5
        System.out.println(mapSum.sum("ap"));
    }
}
