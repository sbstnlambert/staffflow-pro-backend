package io.github.staffflowpro.utils;

import io.github.staffflowpro.model.Employee;
import io.github.staffflowpro.service.EmployeeService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DatabaseFiller implements InitializingBean {

    private final EmployeeService employeeService;

    @Autowired
    public DatabaseFiller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void afterPropertiesSet() {
        // Ajoutez ici les données du fichier JSON
        List<Employee> employees = generateEmployees();

        // Enregistrez les employés dans la base de données
        employees.forEach(employeeService::addEmployee);

        // Affichez les données pour vérification
        System.out.println("Employee Data:");
        employeeService.findAllEmployees().forEach(System.out::println);
    }

    private List<Employee> generateEmployees() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Sophie Dubois", "sophie.dubois@email.com", "Marketing Coordinator", "+32 123456789", "https://api.dicebear.com/7.x/adventurer/svg?seed=Bailey", UUID.randomUUID().toString()));
        employees.add(new Employee("Thomas Van den Berg", "thomas.vandenberg@email.com", "Software Developer", "+32 987654321", "https://api.dicebear.com/7.x/adventurer/svg?seed=Annie", UUID.randomUUID().toString()));
        employees.add(new Employee("Yassin El-Mansour", "yassin.elmansour@email.com", "Financial Analyst", "+32 456789012", "https://api.dicebear.com/7.x/adventurer/svg?seed=Bandit", UUID.randomUUID().toString()));
        employees.add(new Employee("Emma De Smet", "emma.desmet@email.com", "Human Resources Manager", "+32 345678901", "https://api.dicebear.com/7.x/adventurer/svg?seed=Boots", UUID.randomUUID().toString()));
        employees.add(new Employee("Lucas Claes", "lucas.claes@email.com", "Graphic Designer", "+32 234567890", "https://api.dicebear.com/7.x/adventurer/svg?seed=Abby", UUID.randomUUID().toString()));
        employees.add(new Employee("Aya Abidi", "aya.abidi@email.com", "Customer Service Representative", "+32 876543210", "https://api.dicebear.com/7.x/adventurer/svg?seed=Bear", UUID.randomUUID().toString()));
        employees.add(new Employee("Maxime Lefevre", "maxime.lefevre@email.com", "Sales Manager", "+32 567890123", "https://api.dicebear.com/7.x/adventurer/svg?seed=Angel", UUID.randomUUID().toString()));
        employees.add(new Employee("Lotte Janssen", "lotte.janssen@email.com", "IT Support Specialist", "+32 109876543", "https://api.dicebear.com/7.x/adventurer/svg?seed=Bella", UUID.randomUUID().toString()));
        employees.add(new Employee("Hamza Al-Madi", "hamza.almadi@email.com", "Project Manager", "+32 876543210", "https://api.dicebear.com/7.x/adventurer/svg?seed=Baby", UUID.randomUUID().toString()));
        employees.add(new Employee("Nina Wouters", "nina.wouters@email.com", "Research Scientist", "+32 345678901", "https://api.dicebear.com/7.x/adventurer/svg?seed=Bubba", UUID.randomUUID().toString()));
        employees.add(new Employee("Rafael Mbemba", "rafael.mbemba@email.com", "Data Analyst", "+32 234567890", "https://api.dicebear.com/7.x/adventurer/svg?seed=Boo", UUID.randomUUID().toString()));
        employees.add(new Employee("Eva Hermans", "eva.hermans@email.com", "Administrative Assistant", "+32 987654321", "https://api.dicebear.com/7.x/adventurer/svg?seed=Buster", UUID.randomUUID().toString()));
        employees.add(new Employee("Ayoub El-Hassan", "ayoub.elhassan@email.com", "Quality Assurance Engineer", "+32 123456789", "https://api.dicebear.com/7.x/adventurer/svg?seed=Bob", UUID.randomUUID().toString()));
        employees.add(new Employee("Amelie Dupont", "amelie.dupont@email.com", "Public Relations Specialist", "+32 567890123", "https://api.dicebear.com/7.x/adventurer/svg?seed=Callie", UUID.randomUUID().toString()));
        employees.add(new Employee("Jasper Maes", "jasper.maes@email.com", "Legal Counsel", "+32 876543210", "https://api.dicebear.com/7.x/adventurer/svg?seed=Buddy", UUID.randomUUID().toString()));
        employees.add(new Employee("Mia De Vries", "mia.devries@email.com", "Product Manager", "+32 234567890", "https://api.dicebear.com/7.x/adventurer/svg?seed=George", UUID.randomUUID().toString()));
        employees.add(new Employee("Mohammed Ali", "mohammed.ali@email.com", "Supply Chain Analyst", "+32 109876543", "https://api.dicebear.com/7.x/adventurer/svg?seed=Cali", UUID.randomUUID().toString()));
        employees.add(new Employee("Sofie Peeters", "sofie.peeters@email.com", "Event Coordinator", "+32 345678901", "https://api.dicebear.com/7.x/adventurer/svg?seed=Casper", UUID.randomUUID().toString()));
        employees.add(new Employee("Vincent Van Damme", "vincent.vandamme@email.com", "UX/UI Designer", "+32 876543210", "https://api.dicebear.com/7.x/adventurer/svg?seed=Gizmo", UUID.randomUUID().toString()));

        return employees;
    }
}
