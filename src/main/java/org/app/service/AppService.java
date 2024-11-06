package org.app.service;

import org.app.entity.PortalUser;
import org.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    private UserRepository userRepository;

    public PortalUser getUserInfo(String userName) {
        //TODO @Repository removed for Jenkins CICD example
        //return userRepository.findByUserName(userName).orElse(null);
        return PortalUser.builder()
                .userId(1)
                .userName("Test User")
                .userMail("test@gmail.com")
                .password("password")
                .roles("admin").build();
    }
}
