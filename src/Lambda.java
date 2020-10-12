import java.math.BigDecimal;
import java.util.function.*;

public class Lambda {

    public static void main(String[] args) {

        /**
         * Predicate 函数接口，抽象方法 test(T t)，判断真假，返回 boolean 类型
         */
        Predicate<Integer> predicate = x -> x > 185;
        Student student = new Student("龙之心",23,175,0);
        System.out.println("龙之心的身高高于185cm吗"+predicate.test(student.getHight()));
        // 龙之心的身高高于185cm吗false

        Predicate<String> predicates = s -> s.equals("狼");
        String str = "狼";
        System.out.println("这是一只狼吗？" + predicates.test(str)); // 这是一只狼吗？true
        String strtigle = "虎";
        System.out.println("这是一只狼吗？"+predicates.test(strtigle)); //这是一只狼吗？false

        /**
         * 函数接口 Consumer，抽象方法 accept(T t)，参数 T，返回 void
         */
        Consumer<String> consumer = System.out::println;
        consumer.accept("我命由我不由天"); // 我命由我不由天

        /**
         * 函数接口 Function，抽象方法 R apply()，将 T 映射为 R（转换功能）返回 R 类型
         * 获取 Student 对象的属性值，将 Student 类型转换成 String 类型
         */
        Function<Student, String> function = Student::getName;
        String name = function.apply(student);
        System.out.println(name); // 龙之心

        /**
         * 获取 Strdent 对象的属性值，将 Student 类型转换成 Integer 类型
         */
        Function<Student, Integer> functionInteger = Student::getAge;
        Integer age = functionInteger.apply(student);
        System.out.println(age); // 23

        /**
         * 函数接口 Supplier，抽象方法 T get()，生产消息，返回类型 T
         */
        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get()); // 10

        /**
         * 函数接口 UnaryOperator，抽象方法 T apply(T t)，一元操作，返回类型 T
         */
        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
        Boolean uglilybool = unaryOperator.apply(true);
        System.out.println(uglilybool); // false

        /**
         * 函数接口 BinaryOperator，抽象方法 apply(T t, U u)，二元操作，返回类型(T)
         * 求两个数的乘积
         */
        BinaryOperator<Integer> operator = (x, y) -> x * y;
        Integer integer = operator.apply(2,3);
        System.out.println(integer); //6

        test(() -> "我是一个演示的函数接口"); //我是一个演示的函数接口
    }

    /**
     * 自定义函数式接口
     * @param worker
     */
    public static void test(Worker worker){
        String work = worker.work();
        System.out.println(work);
    }

    public interface Worker{
        String work();
    }

}
