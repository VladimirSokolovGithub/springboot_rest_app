package com.vladimirsokolov.spring.springboot.springboot_rest_app.dao;

import com.vladimirsokolov.spring.springboot.springboot_rest_app.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager; //entityManager создаётся автоматически его бин мы нигде не описываем

    //метод для получения всех работников из БД
    @Override
    public List<Employee> getAllEmployees() {

//        Session session = entityManager.unwrap(Session.class); //получим сессию из нашей sessionFactory
//
//        //Сначала мы создаем запрос Query в котором работаем с Employee. После чего можем
//        //выполнить этот Query.
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();

        //Здесь мы уже не работаем с Hibernate, а работаем с пакетом javax.persistence на уровне JPA
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }


    @Override
    public void saveEmployee(Employee employee) {

//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);

        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());

    }


    @Override
    public Employee getEmployee(int id) {

//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        //Здесь мы уже не работаем с Hibernate, а работаем с пакетом javax.persistence на уровне JPA
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }


    @Override
    public void deleteEmployee(int id) {

//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee  " +
//                "where id =:employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

        Query query = entityManager.createQuery("delete from Employee  " +
                "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
