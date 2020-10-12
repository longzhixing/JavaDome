import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningTest {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("龙", 23, 187, 1));
        students.add(new Student("虎", 30, 185, 1));
        students.add(new Student("狼", 27, 175, 1));
        students.add(new Student("豹", 25, 170, 0));
        students.add(new Student("狐狸", 20, 165, 0));
        // Collectors.joining(分界符, 前缀符, 结束符) 拼接字符串，
        // 也可不不传参数Collectors.joining()，这样是直接拼接
        // 将学生姓名拼接成一个数组
        String name = students.stream().map(Student::getName)
                .collect(Collectors.joining(",","[","]"));
        System.out.println(name); // [龙,虎,狼,豹,狐狸]
    }
}
