package com.techprimers.springbatchexample1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * assume this class is the class which placed on the Connect Server side.
 * We Hit Connect V4 API via Postman/JobManager Application, where the connect server sends us data after mapping it to their some XYZ class like "User.java" & it comes to us.
 * & after understanding the response we create UserDTO.java at our end in JobManager project to map that JSON response & save it in DB  
 * 
 * @author abharsa
 */
@Entity
public class User {

    @Id
    private Integer id;
    private String name;
    private String dept;
    private Integer salary;
    private Date time;

    public User(Integer id, String name, String dept, Integer salary, Date time) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.time = time;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", dept='").append(dept).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
