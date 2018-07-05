package models;

import javax.persistence.*;

@Entity
@Table(name="admins")
public class Admin extends Employee {

    private Manager manager;

    public Admin() {
    }

    public Admin(String name, String NI, int salary, Manager manager) {
        super(name, NI, salary);
        this.manager = manager;
    }


    @ManyToOne
    @JoinColumn(name="manager_id", nullable=false)
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
