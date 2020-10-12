import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamLambda {

    public static void main(String[] args) {
        //collect(Collectors.toList()) 将流转换成 list
//        List<Student> studentList = Stream.of(new Student("龙",22,175),
//                new Student("虎",33,180),
//                new Student("狼", 23,170)).collect(Collectors.toList());
//        for(Student student: studentList){
//            System.out.println(student.getName());
//        }

        //collect(Collectors.toMap()) 将流转换成 map
//      Map<String, Object> map = studentList.stream().collect(Collectors.toMap(Student::getName,Student::getAge));
//        System.out.println(map); // {龙=22, 狼=23, 虎=33}

        // filter 起过滤筛选的作用。内部就是Predicate接口。惰性求值
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("龙",22,175));
//        students.add(new Student("虎",40,180));
//        students.add(new Student("狼",30,185));
//        // 查询身高小于180cm的同学
//        List<Student> studentList = students.stream()
//                .filter(s -> s.getHight() < 180).collect(Collectors.toList());
//        for(Student student: studentList){
//            System.out.println("name："+student.getName()+"，age："+student.getAge()+"，" +
//                    "hight："+student.getHight()+""); // name：龙，age：22，hight：175
//        }

        // 将 Student 对象转换为 Strig 对象，获取 student 的名字
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("龙",22,175));
//        students.add(new Student("虎",40,180));
//        students.add(new Student("狼",30,185));
//       List<String> names = students.stream()
//               .map(s -> s.getName()).collect(Collectors.toList());
//       System.out.println(names); // [龙, 虎, 狼]

        // flatMap 将多个Stream合并为一个Stream。惰性求值
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("龙",22,175));
//        students.add(new Student("虎",40,180));
//        students.add(new Student("狼",30,185));
//        //合并两个学生集合
//        //调用Stream.of的静态方法将两个list转换为Stream，再通过flatMap将两个流合并为一个。
//        List<Student> studentList = Stream.of(students,
//                asList(new Student("豹",25,183),
//                        new Student("狮",48,176)))
//                .flatMap(s -> s.stream()).collect(Collectors.toList());
//        for (Student student: studentList){
//            System.out.println("name："+student.getName()+"，age："+student.getAge()+"，" +
//                    "hight："+student.getHight()+""); // name：龙，age：22，hight：175
//        }
//        name：龙，age：22，hight：175
//        name：虎，age：40，hight：180
//        name：狼，age：30，hight：185
//        name：豹，age：25，hight：183
//        name：狮，age：48，hight：176


        List<Student> students = new ArrayList<>();
        students.add(new Student("龙", 22, 175,0));
        students.add(new Student("虎", 40, 180,0));
        students.add(new Student("狼", 30, 185,0));
        //查询年龄最大的学生
        Optional<Student> max = students.stream()
                .max(Comparator.comparing(s -> s.getAge()));
        //查询年龄最小的学生
        Optional<Student> min = students.stream()
                .min(Comparator.comparing(s -> s.getAge()));
        // 判断是否有值
        if(max.isPresent()){
            Student student = max.get();
            System.out.println("name："+student.getName()+"，age："+student.getAge()+"，" +
                    "hight："+student.getHight()+""); // name：虎，age：40，hight：180
        }
        if(min.isPresent()){
            Student student = min.get();
            System.out.println("name："+student.getName()+"，age："+student.getAge()+"，" +
                    "hight："+student.getHight()+""); // name：龙，age：22，hight：175
        }

        List<Student> studentsf = new ArrayList<>();
        students.add(new Student("龙", 22, 175,0));
        students.add(new Student("虎", 40, 180,0));
        students.add(new Student("狼", 30, 185,0));
        //统计年龄小于35岁的学生
        long count = studentsf.stream().filter(s -> s.getAge() < 35).count();
        System.out.println("年齿小于35岁的人数是：" + count); // 年齿小于45岁的人数是：2

        //从0开始依次累加集合中的值
        Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, (acc, x) -> acc + x);
        System.out.println(reduce); // 10



    }


}
