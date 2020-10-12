
public class Student {
    private String name;
    private Integer age;
    private Integer hight;
    private Integer gender;

    public Student(String name, Integer age, Integer hight,Integer gender){
        this.name = name;
        this.age = age;
        this.hight = hight;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHight() {
        return hight;
    }

    public void setHight(Integer hight) {
        this.hight = hight;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
