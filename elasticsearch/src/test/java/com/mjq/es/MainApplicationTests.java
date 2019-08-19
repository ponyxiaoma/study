package com.mjq.es;

import com.mjq.es.document.User;
import com.mjq.es.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testESSave() {
        User user = new User();
        user.setId("100");
        user.setName("mjq");
        user.setBirthday(new Date());
        userRepository.save(user);
        System.out.println("success");
    }


}
