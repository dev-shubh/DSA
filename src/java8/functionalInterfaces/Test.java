package java8.functionalInterfaces;

public class Test {
    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted + 1);
    }
}
