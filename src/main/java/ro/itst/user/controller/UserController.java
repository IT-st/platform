package ro.itst.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.itst.user.model.User;
import ro.itst.user.service.UserService;

import javax.annotation.Resource;

/**
 * Created by spacvalentin on 20.06.2016.
 */
@RestController
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User test(@RequestParam(name = "tt")String tt) {
        return userService.getUser();
    }

}
