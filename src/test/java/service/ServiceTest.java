package service;

import com.scau.DataCollectionSystem.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void loginTest()
    {
        String pw = "123456";

        if(userService.login(pw))
            System.out.println("good");
        else
            System.out.println("bad");

    }

}
