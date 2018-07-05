import db.DBHelper;
import db.DBManager;
import models.Admin;
import models.Department;
import models.Employee;
import models.Manager;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Department department = new Department("HR");
        Manager manager = new Manager("Adri", "QQ123456A", 3000, 15000, department );
        Admin admin1 = new Admin("Derek", "ZZ123456B", 100,  manager);
        Admin admin2 = new Admin("Pete", "AA654321C", 1900,  manager);

        DBHelper.save(department);
        DBHelper.save(manager);
        DBHelper.save(admin1);
        DBHelper.save(admin2);

        List<Employee> allEmployees = DBManager.getAllEmployees(manager);

        List<Employee> allAdmins = DBHelper.getAll(Admin.class);
        List<Employee> allManagers = DBHelper.getAll(Manager.class);

        Department findDepartment = DBManager.findDepartment(manager);
    }
}
