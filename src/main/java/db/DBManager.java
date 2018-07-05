package db;

import models.Department;
import models.Employee;
import models.Manager;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBManager {

    private static Session session;

    public static Department findDepartment(Manager manager) {
        session = HibernateUtil.getSessionFactory().openSession();
        Department department = null;
        try {
            Criteria criteria = session.createCriteria(Department.class);
            criteria.add(Restrictions.eq("id", manager.getDepartment().getId()));
            department = (Department)criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return department;
    }

    public static List<Employee> getAllEmployees(Manager manager) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> results = null;
        try {
            Criteria cr = session.createCriteria(Employee.class);
            cr.add(Restrictions.eq("manager", manager));
            results =  cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
