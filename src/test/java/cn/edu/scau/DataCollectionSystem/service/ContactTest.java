package cn.edu.scau.DataCollectionSystem.service;

import cn.edu.scau.DataCollectionSystem.controller.ContactController;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ContactTest {

    private ContactController contactController;

    @Test
    public void addTest()
    {
        JSONObject json = new JSONObject();
        json.put("name", "a");
        json.put("mail", "com");
        JSONObject res = contactController.addContact(json);

            System.out.println(res.getInt("code"));
    }

}
