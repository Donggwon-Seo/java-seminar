package chapter1;

public class FromIntToFloat {
    public static void main(String[] args) {
        int num1 = 123456780;
        int num2 = 123456780;

        float num3 = num2; // 자동
        System.out.println(num3);
        num2 = (int) num3;
        System.out.println(num2);

        int result = num1 - num2;
        System.out.println(result);

        long longValue1 = 9223372036854775806L;

        double doubleValue = longValue1;
        System.out.println(doubleValue);

        long longValue2 = (long) doubleValue;
        System.out.println(longValue2);

        long longValue3 = longValue1 - longValue2;
        System.out.println(longValue3); // 0이 아닌 다른 수가 나오면 손실로 차이 발생
    }
}
