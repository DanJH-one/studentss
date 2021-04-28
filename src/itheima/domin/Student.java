package itheima.domin;

public class Student {
    private String sid;
    private String name;
    private Integer age;
    private Integer source;

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", source=" + source +
                '}';
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Student() {
    }

    public Student(String sid, String name, Integer age, Integer source) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.source = source;
    }
}
