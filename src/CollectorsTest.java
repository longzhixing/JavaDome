import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectorsTest {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("龙", 22, 175,1));
        students.add(new Student("虎", 40, 180,1));
        students.add(new Student("狼", 30, 185,0));
        OutstandingClass outstandingClass1 = new OutstandingClass("一班",students);
        //复制 students，并移除一个学生
        List<Student> students1 = new ArrayList<>(students);
        students1.remove(1);
        OutstandingClass outstandingClass2 = new OutstandingClass("二班",students1);
        //将 outstandingClass1,outstandingClass2 转换成 Stream
        Stream<OutstandingClass> classStream = Stream.of(outstandingClass1,outstandingClass2);
        //获取人数最多的班级
        OutstandingClass outstandingClass = biggestGroup(classStream);
        System.out.println("人数最多的班级是："+outstandingClass.getClassName());
        // 人数最多的班级是：一班
        System.out.println("一班平均年龄是："+averageNumberOfStudent(students));
        // 一班平均年龄是：30.666666666666668
    }

    /**
     * 获取人数最多的班级
     * @param outstandingClassStream
     * @return
     */
    private static OutstandingClass biggestGroup(Stream<OutstandingClass> outstandingClassStream){
        // maxBy 求最大值
        return outstandingClassStream.collect(
                maxBy(Comparator.comparing(s -> s.getStudents().size())))
                .orElseGet(OutstandingClass::new);
    }

    /**
     * 计算平均年龄
     * @param students
     * @return
     */
    private static double averageNumberOfStudent(List<Student> students){
        return students.stream().collect(averagingInt(Student::getAge));
    }
}
