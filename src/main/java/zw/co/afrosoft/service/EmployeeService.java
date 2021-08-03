package zw.co.afrosoft.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private static List<Employee> list = new ArrayList<Employee>();

    static{
        list.add(new Employee(1,"Employee1",28,"Zimbabwe"));
        list.add(new Employee(2,"Employee2",23,"Zimbabwe"));
        list.add(new Employee(3,"Employee3",24,"Zimbabwe"));
        list.add(new Employee(4,"Employee4",27,"Zimbabwe"));
        list.add(new Employee(5,"Employee5",29,"Zimbabwe"));
    }

    public List<Employee> getList(){
        return list;
    }

    public Employee getEmployee(long id){
        Optional<Employee> theEmployee = list.stream().filter(e-> e.getId() == id).findFirst();
        return theEmployee.get();
    }
}
