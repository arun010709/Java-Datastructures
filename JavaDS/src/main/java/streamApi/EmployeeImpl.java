package streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeImpl {


    public static void main(String args[]) {
        List<Employee> employeeList = populateEmployeeDetails();
        //find number of males and females
        Map<String, Long> genderCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,
                Collectors.counting()));
        //System.out.print(genderCount);

        //Name of all departments
        //employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        //Average age of male and female
        Map<String, Double> genderWiseAverageAgeMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        //System.out.print(genderWiseAverageAgeMap);

        //Highest paid employee
        //Optional<Employee> highestPaidEmployee = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        //highestPaidEmployee.ifPresent(System.out::print);


        //Employees joined after 2015
        //employeeList.stream().filter(emp->emp.getYearOfJoining()>2015).map(Employee::getName).forEach(System.out::println);

        //number of employees in each department
        Map<String, Long> departmentWiseEmployeeCountMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        //System.out.print(departmentWiseEmployeeCountMap);

        //Average salary of each department
        Map<String, Double> departmentWiseAverageSalaryEmployeesMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        //System.out.print(departmentWiseAverageSalaryEmployeesMap);

        //Get the details of youngest male employee in the product development department
        Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper =
                employeeList.stream()
                        .filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
                        .min(Comparator.comparingInt(Employee::getAge));
        //System.out.print(youngestMaleEmployeeInProductDevelopmentWrapper.get());

        //Employee with most work experience
        Optional<Employee> mostExperiencedEmp=employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining));
        //System.out.print(mostExperiencedEmp.get());

        //Number of males and females in sales and marketing
        Map<String,Long> genderCountInSalesAndMarketing=employeeList.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        //System.out.print(genderCountInSalesAndMarketing);

        //Average salary of male and female employees
        Map<String,Double> averageSalaryGenderWise=employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
        //System.out.print(averageSalaryGenderWise);

        //name of all employees in each department
        Set<Map.Entry<String, List<Employee>>> entrySet = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment)).entrySet();
        /*for (Map.Entry<String, List<Employee>> entry : entrySet) {
            System.out.println("--------------------------------------");

            System.out.println("Employees In " + entry.getKey() + " : ");

            System.out.println("--------------------------------------");

            List<Employee> list = entry.getValue();

            for (Employee e : list) {
                System.out.println(e.getName());
            }
        }*/

        //Highest salary in each department
        Map<String,Optional<Employee>> highestSalariedEmployee=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        //highestSalariedEmployee.entrySet().stream().forEach(entry -> System.out.println(entry.getValue().get().getName()+" "+entry.getValue().get().getDepartment()+" "+entry.getValue().get().getSalary()));

        //average salary and total salary of the whole organization
        DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average salary "+doubleSummaryStatistics.getAverage());
        System.out.print("Total salary "+doubleSummaryStatistics.getSum());

        //employees who are younger or equal to 25 years from those employees who are older than 25 years
        Map<Boolean,List<Employee>> partitionByAge=employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 25));
        for (Map.Entry<Boolean, List<Employee>> entry : partitionByAge.entrySet())
        {
            System.out.println("----------------------------");

            if (entry.getKey())
            {
                System.out.println("Employees older than 25 years :");
            }
            else
            {
                System.out.println("Employees younger than or equal to 25 years :");
            }

            System.out.println("----------------------------");

            List<Employee> list = entry.getValue();

            for (Employee e : list)
            {
                System.out.println(e.getName());
            }
        }

        //Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Employee employee=employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).get();
        System.out.print("Oldest employee is "+employee.getName()+" of age "+employee.getAge()+" belongs to department "+employee.getDepartment());
    }



    private static List<Employee> populateEmployeeDetails() {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
        return employeeList;
    }
}
