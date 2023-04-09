package class01;

import org.testng.annotations.Test;

public class priority {
    @Test(priority = 3)
    public void aTest(){
        System.out.println("i am TestA");
    }
    @Test(priority = 1)
    public void bTest(){
        System.out.println("i am TestB");
    }
    @Test(priority = 2)
    public void cTest(){
        System.out.println("i am TestC");
    }
}
