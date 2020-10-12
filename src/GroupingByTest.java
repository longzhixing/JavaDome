import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByTest {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("龙", 23, 187, 1));
        students.add(new Student("虎", 30, 185, 1));
        students.add(new Student("狼", 27, 175, 1));
        students.add(new Student("豹", 25, 170, 0));
        students.add(new Student("狐狸", 20, 165, 0));
        // Collectors.groupingBy 数据分组
        // 根据学生性别进行分组
        Map<Integer,List<Student>> listMap = students.stream().collect(
                Collectors.groupingBy(s -> s.getGender()));
        List<Student> listMan = listMap.get(1);
        System.out.println("男生");
        for (Student student: listMan){
            System.out.println("name：" + student.getName() + "，age：" + student.getAge() + "，" +
                    "hight：" + student.getHight() + ",gender：" + student.getGender() + "");
        }
        List<Student> listWoman = listMap.get(0);
        System.out.println("女生");
        for (Student student: listWoman){
            System.out.println("name：" + student.getName() + "，age：" + student.getAge() + "，" +
                    "hight：" + student.getHight() + ",gender：" + student.getGender() + "");
        }
    }
}
//男生
//        name：龙，age：23，hight：187,gender：1
//        name：虎，age：30，hight：185,gender：1
//        name：狼，age：27，hight：175,gender：1
//        女生
//        name：豹，age：25，hight：170,gender：0
//        name：狐狸，age：20，hight：165,gender：0
