package com.scau.DataCollectionSystem.service;

import com.scau.DataCollectionSystem.entity.Email;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class EmailTest {

    @Autowired
    private ContactService contactService;

    @Test
    public void addTest()
    {
        Email newEmail = new Email();
        newEmail.setName("C");
        newEmail.setAddress("xyz");

        if(contactService.addContact(newEmail))
            System.out.println("成功");
        else
            System.out.println("失败");
    }

    @Test
    public void getTest()
    {
        List<Email> res = contactService.getContacts(3, 3);

        for (Email e:res) {
            System.out.println(e.getName() + " and " + e.getAddress());
        }
    }

    @Test
    public void deleteTest()
    {
        if(contactService.deleteContact("lee"))
        {
            System.out.println("成功");
        }
        else
            System.out.println("失败");
    }
}
