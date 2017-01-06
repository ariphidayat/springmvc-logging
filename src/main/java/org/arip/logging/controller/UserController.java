package org.arip.logging.controller;

import org.arip.logging.model.User;
import org.arip.logging.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Arip Hidayat on 12/8/2015.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAll() {
        List<User> users = userService.getAll();

        ModelAndView model = new ModelAndView();
        model.addObject("users", users);
        model.setViewName("home");

        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newUser() {
        User user = new User();

        ModelAndView model = new ModelAndView();
        model.addObject("user", user);
        model.setViewName("userForm");

        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request) {
        String id = request.getParameter("id");
        User user = userService.getUser(id);

        ModelAndView model = new ModelAndView();
        model.addObject("user", user);
        model.setViewName("userForm");

        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user) {
        if (userService.getUser(user.getId()) == null) {
            userService.save(user);
        } else {
            userService.update(user);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        String id = request.getParameter("id");
        userService.delete(id);
        return new ModelAndView("redirect:/");
    }
}
