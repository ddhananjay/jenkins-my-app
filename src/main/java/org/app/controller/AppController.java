package org.app.controller;

import org.app.entity.PortalUser;
import org.app.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AppService appService;

    @RequestMapping(method = RequestMethod.GET, path = "/data/{username}")
    public String getData(@PathVariable String username) {
        PortalUser user = appService.getUserInfo(username);
        if(user != null) {
            return "found user :"+user.getUserName()+" "+user.getUserMail();
        }
        return "No user found";
    }
}
