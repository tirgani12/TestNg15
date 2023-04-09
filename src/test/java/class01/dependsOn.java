package class01;

import org.testng.annotations.Test;

public class dependsOn {
    @Test
    public void Login(){
        //System.out.println("i am here");
        System.out.println(6/0);
    }
    @Test(dependsOnMethods = {"Login"})
    public void DashBoardVerification(){
        System.out.println("after login i am verifiying dashboard");
    }
}
