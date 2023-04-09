package class01;

import org.testng.annotations.Test;

public class enableDisable {
    @Test(enabled = false)
    public void aTest(){
        System.out.println("i am first test case");
    }
    @Test
    public void bTest(){
        System.out.println("i am second test case");
    }
    @Test(enabled = false)
    public void cTest(){
        System.out.println("i am third test case");
    }
}
