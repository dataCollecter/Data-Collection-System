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
    private EmailService emailService;

    @Test
    public void addTest()
    {
        Email newEmail = new Email();

        newEmail.setName("chita");
        newEmail.setAddress("email@345.com");

        if(emailService.addContact(newEmail))
            System.out.println("成功");
        else
            System.out.println("失败");
    }

    @Test
    public void getTest()
    {
        List<Email> res = emailService.getContacts();

        for (Email e:res) {
            System.out.println(e.getName() + " and " + e.getAddress());
        }
    }

    @Test
    public void deleteTest()
    {
        if(emailService.deleteContact("lee"))
        {
            System.out.println("成功");
            getTest();
        }
        else
            System.out.println("失败");
    }
}
