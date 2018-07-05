package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="managers")
public class Manager extends Employee {

    private int budget;
    private Department department;
    List<Admin> admins;

    public Manager() {
    }

    public Manager(String name, String NI, int salary, int budget, Department department) {
        super(name, NI, salary);
        this.budget = budget;
        this.department = department;
        this.admins = new ArrayList<Admin>();
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToMany(mappedBy="manager", fetch = FetchType.LAZY)
    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }
}
