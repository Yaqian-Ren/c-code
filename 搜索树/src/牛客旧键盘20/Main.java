package 牛客旧键盘20;

import java.util.*;

/*
牛客网上的常见问题：
1. 很可能是多组用例的形式提供
2. 英文字母只输出大写
3. 如果实在搞不定输入输出，可以看看别人完成的代码
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Ctrl + D 在 IDEA 上终止输入
        while (scanner.hasNextLine()) {
            // 完成一组用例的测试

            String expected = scanner.nextLine().toUpperCase();
            String real = scanner.nextLine().toUpperCase();

            Set<Character> realSet = new TreeSet<>();
            for (char ch : real.toCharArray()) {
                realSet.add(ch);
            }

            Set<Character> outputtedSet = new TreeSet<>();
            for (char ch : expected.toCharArray()) {
                if (!realSet.contains(ch) && !outputtedSet.contains(ch)) {
                    System.out.print(ch);
                    outputtedSet.add(ch);
                }
            }
            System.out.println();
        }
    }
}
