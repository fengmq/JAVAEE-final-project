package model;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String pwd;
    private String sex;
    private Date birth;
    private  String phone;
    private  String native_place;
    private  String politics_status;
    private  String qq;
    private String email;

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getPolitics_status() {
        return politics_status;
    }

    public void setPolitics_status(String politics_status) {
        this.politics_status = politics_status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String  getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void show(){
        System.out.println("id: "+id+"\nname: "+name+"\npwd: "+pwd+"\nsex: "+sex+"\nbirth:"+birth);
    }

    public void set(int id, String pwd,String name, String sex, Date birth, String phone, String native_place, String politics_status, String qq, String email) {
        this.id = id;
        this.name = name;
        this.pwd=pwd;
        this.sex = sex;
        this.birth = birth;
        this.phone = phone;
        this.native_place = native_place;
        this.politics_status = politics_status;
        this.qq = qq;
        this.email = email;
    }
}
