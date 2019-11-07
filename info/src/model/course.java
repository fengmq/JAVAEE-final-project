package model;

public class course {
    int id;
    private String course_name;
    private int score;
    private  int user;//外键

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
    public float getGPA()
    {
        if(score>=90)
            return 4;
        else if(score >=87)
            return (float)3.7;
        else if(score >=84)
            return (float)3.3;
        else if(score >=80)
            return (float)3.0;
        else if(score >=77)
            return (float)2.7;
        else if(score >=74)
            return (float)2.3;
        else if(score >=70)
            return (float)2.0;
        else if(score >=67)
            return (float)1.7;
        else if(score >=64)
            return (float)1.3;
        else if(score >=60)
            return (float)1;
        else
            return 0;
    }
}
