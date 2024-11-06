package org.app.controller;

import org.app.entity.PortalUser;
import org.app.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AppService appService;

    @RequestMapping("/data/{username}")
    public String getData(@PathVariable String username) {
        PortalUser user = appService.getUserInfo(username);
        if(user != null) {
            return "found user :"+user.getUserName()+" "+user.getUserMail();
        }
        return "No user found";
    }
}
