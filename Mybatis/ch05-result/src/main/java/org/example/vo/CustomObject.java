package org.example.vo;

public class CustomObject {
    private Integer cid;
    private String name;
    private Integer age;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    @Override
    public String toString() {
        return "CustomObject{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
