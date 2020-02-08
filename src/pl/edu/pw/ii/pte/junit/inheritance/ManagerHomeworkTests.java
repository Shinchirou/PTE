package pl.edu.pw.ii.pte.junit.inheritance;

import org.junit.jupiter.api.*;


import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;


public class ManagerHomeworkTests {

    private Manager manager;

    @BeforeEach
    public void setUp() throws Exception {
        manager = new Manager("Piotr Kowalski", 9000, 1990, 06, 30);
    }


    @Test
    public void twoDifferentBossesAreNotEqual() {
        Manager manager1 = new Manager("Bogdan Kowalski", 7000, 1996, 12, 15);
        assertFalse(manager.equals(manager1));
    }

    @Test
    public void checkManagerName() {
        assertEquals("Piotr Kowalski", manager.getName());
    }

    @Test
    public void checkManagerHireDay() {
        GregorianCalendar calendar = new GregorianCalendar(1990, 06-1, 30);
        Date hireDay = calendar.getTime();
        assertEquals(true, hireDay.equals(manager.getHireDay()));
    }

    @Test
    public void checkManagerSalary() {
        assertEquals(9000, manager.getSalary());
    }

    @Test
    public void checkSalaryAfterRaisingSalaryByZeroPercent() {
        manager.raiseSalary(0);
        assertEquals(9000, manager.getSalary());
    }

    @Test
    public void checkSalaryAfterRaisingSalaryBy20Percent() {
        manager.raiseSalary(20);
        assertEquals(10800, manager.getSalary());
    }

    @Test
    public void checkManagerBonusAfterSetingBonus() {
        manager.setBonus(2000);
        assertEquals(11000, manager.getSalary());
    }

    @Test
    public void checkIfManagerIsAlsoEmployee() {
        assertTrue(manager instanceof Employee);
        assertTrue(manager instanceof Manager);
    }

    @Test
    public void checkIfEmployeeIsNOTManager() {
        Employee employee = new Employee("Bogdan Kowalski", 7000, 1996, 12, 15);

        assertTrue(employee instanceof Employee);
        assertFalse(employee instanceof Manager);
    }
}

