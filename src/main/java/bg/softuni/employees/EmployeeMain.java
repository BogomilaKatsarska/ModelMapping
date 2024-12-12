package bg.softuni.employees;

import bg.softuni.employees.dtos.ManagerDTO;
import bg.softuni.employees.entities.Employee;
import org.modelmapper.ModelMapper;

import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee first = new Employee("First", "Last", 12000);
        Employee second = new Employee("Second", "Last", 15440);
        Employee third = new Employee("Third", "Last", 12050);
        Employee fourth = new Employee("Fourth", "Last", 32000);

        Employee managerOne = new Employee("ManagerOne", "Last", 55000, List.of(first, second, third));
        Employee managerTwo = new Employee("ManagerTwo", "Last", 45000, List.of(fourth));

        ModelMapper modelMapper = new ModelMapper();

        ManagerDTO oneDTO = modelMapper.map(managerOne, ManagerDTO.class);
        System.out.println(oneDTO);
    }
}
