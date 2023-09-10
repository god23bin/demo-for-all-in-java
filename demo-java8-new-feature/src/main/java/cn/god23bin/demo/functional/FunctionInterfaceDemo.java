package cn.god23bin.demo.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author god23bin
 * @created 2023/3/26 22:52
 */
public class FunctionInterfaceDemo {

    public static void main(String[] args) {
        System.out.println(args);
        // Function 接口的泛型，第一个泛型参数是入参类型，第二个泛型参数是出参类型
        // Function 接口只有一个抽象方法，就是 apply()
        Function<Integer, String> function = num -> "GTA" + num;
        String result = function.apply(5);
        System.out.println(result);

        // Consumer 接口，泛型参数是入参类型，接受一个参数，并不返回结果，相当于消费了这个参数
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("我输入什么就打印什么");

        // Supplier 接口，泛型参数是出参类型，不接受参数，但是会提供结果，相当于生产了某个东西
        Supplier<String> supplier = () -> "提供一个我随便打的字符串给调用方";
        String text = supplier.get();
        System.out.println(text);

        // Predicate 接口，泛型参数是入参类型，返回布尔值
        Predicate<String> predicate = s -> s.contains("god23bin");
        boolean flag = predicate.test("god23bin能给你带来收获吗？");
        System.out.println("god23bin能给你带来收获吗？" + flag);

        Function<String, String> upperCase = s -> s.toUpperCase();
        Function<String, String> addPostfix = s -> s + "5";
        // 链式调用
        String str = upperCase.andThen(addPostfix).apply("gta");
        System.out.println(str);

        Consumer<String> first = s -> System.out.println(s + 5);
        Consumer<String> second = s -> System.out.println(s + 6);
        Consumer<String> combination = first.andThen(second);
        combination.accept("GTA");

    }

}
