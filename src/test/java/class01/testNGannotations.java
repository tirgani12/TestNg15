package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGannotations {
    @BeforeMethod
    public void beforeMethods(){
        System.out.println("i am before methode");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("i am after methode");
    }
    @Test(groups = "regression")
    public void aFirstTestCase(){
        System.out.println("i am the first test case");
    }
    @Test
    public void bSecondTestCase(){
        System.out.println("i am the second test case");
    }
    @Test
    public void cThirdTestCase(){
        System.out.println("i am the third test case");
    }
}
