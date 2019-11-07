package model;

public class relative {
    private int id;
    private String name;
    private String relation;
    private int age;
    private int student_id;
    private String work_unit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getWork_unit() {
        return work_unit;
    }

    public void setWork_unit(String work_unit) {
        this.work_unit = work_unit;
    }

    public void setInfo(String name, String relation, int age, int student_id, String work_unit)
    {
        System.out.println("aaaa-------------aaaaaaa");
        this.name = name;
        this.relation = relation;
        this.age = age;
        this.student_id = student_id;
        this.work_unit = work_unit;
    }
    public void show()
    {
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        System.out.println("relation:"+relation);
        System.out.println("work:"+work_unit);

    }
}
