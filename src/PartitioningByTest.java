import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningByTest {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("龙", 23, 187, 1));
        students.add(new Student("虎", 30, 185, 1));
        students.add(new Student("狼", 27, 175, 1));
        students.add(new Student("豹", 25, 170, 0));
        students.add(new Student("狐狸", 20, 165, 0));
        //Collectors.partitioningBy 根据条件分解成两个集合，接收一个 Predicate 函数式接口
        // 根据学生姓名将学生分成叫龙的和不叫龙的两个集合
        Map<Boolean, List<Student>> listMap = students.stream().collect(
                Collectors.partitioningBy(s -> s.getName().contains("龙"))
        );
        //名字叫龙的
        System.out.println("名字叫龙的");
        List<Student> listTrue = listMap.get(true);
        for (Student student : listTrue) {
            System.out.println("name：" + student.getName() + "，age：" + student.getAge() + "，" +
                    "hight：" + student.getHight() + ",gender：" + student.getGender() + "");
        }
        //名字不叫龙的
        System.out.println("名字不叫龙的");
        List<Student> listFalse = listMap.get(false);
        for (Student student: listFalse){
            System.out.println("name：" + student.getName() + "，age：" + student.getAge() + "，" +
                    "hight：" + student.getHight() + ",gender：" + student.getGender() + "");
        }
    }
}
//    名字叫龙的
//    name：龙，age：23，hight：187,gender：1
//    名字不叫龙的
//    name：虎，age：30，hight：185,gender：1
//    name：狼，age：27，hight：175,gender：1
//    name：豹，age：25，hight：170,gender：0
//    name：狐狸，age：20，hight：165,gender：0
