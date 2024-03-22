package com.xh.miniui.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_employee")
public class Emp {

    @Id
    private String id;

    @Column(name = "loginname")
    private String loginname;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "dept_id")
    private String dept_id;

    @Column(name = "position")
    private String position;

    @Column(name = "gender")
    private int gender;
    @Column(name = "married")
    private int married;

    @Column(name = "salary")
    private String salary;

    @Column(name = "educational")
    private String educational;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "school")
    private String school;

    @Column(name = "createtime")
    private String createtime;

    @Column(name = "email")
    private String email;

    private String _state;

    public String get_state() {
        return _state;
    }

    public void set_state(String _state) {
        this._state = _state;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getMarried() {
        return married;
    }

    public void setMarried(int married) {
        this.married = married;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEducational() {
        return educational;
    }

    public void setEducational(String educational) {
        this.educational = educational;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
