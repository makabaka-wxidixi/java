package junit;

import domain.Employee;
import org.junit.Test;
import service.NameListService;
import service.TeamException;

/**
 * @Author mkbk
 * @Description 对ListServiceTest类的测试
 * @Create 2021-08-20 15:12
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees() {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee() {
        NameListService service = new NameListService();
        int id = 233;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        }catch (TeamException e){
            //捕捉到之前抛出来的错误
            System.out.println(e.getMessage());
        }
    }
}
