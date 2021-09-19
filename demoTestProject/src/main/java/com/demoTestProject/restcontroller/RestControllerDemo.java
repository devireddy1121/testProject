package com.demoTestProject.restcontroller;

import com.demoTestProject.entity.User;
import com.demoTestProject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value="/demoTestProject")
public class RestControllerDemo {
    private UserService userService;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public RestControllerDemo(UserService theUserService) {
        this.userService = theUserService;
    }

    @GetMapping(value = "/homepage")
    public String viewHomePage() {
        LOGGER.debug("debug--inside controller homepage");
        LOGGER.info("info -- inside controller homepage");
        System.out.println("inside controller");
        return "This is homepage";
    }

    @GetMapping(value = "/index")
    public ModelAndView viewIndexPage(Model model) {
        LOGGER.debug("debug--inside controller indexpage");
        LOGGER.info("info -- inside controller indexpage");
        System.out.println("inside controller");
        ModelAndView mav = new ModelAndView();

        mav.setViewName("index");
        return mav;
    }

    @GetMapping("login")
    public ModelAndView login(Model model) {
        System.out.println("inside get login");
        LOGGER.debug("debug--inside controller get login page");
        LOGGER.info("info -- inside controller get login page");
        ModelAndView mav = new ModelAndView();
        User thisuser = new User();
        model.addAttribute("thisuser", thisuser);
        mav.setViewName("login");
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView afterlogin(@ModelAttribute("thisuser") User currentuser) {
        System.out.println("inside post login");
        ModelAndView mav = new ModelAndView();
        List<User> users2 = userService.findAll();
        User tempUser = userService.findByEmail(currentuser.getEmail());
        LOGGER.debug("debug--inside controller post login page");
        LOGGER.info("info -- inside controller post login page");
        System.out.println("inside post login after calling userservice +++ currenyuser email-- " + currentuser.getEmail() + " +++ currenyuser passowrd -- "+currentuser.getPassword());
        if (tempUser.getPassword() != null) {
            if (tempUser.getPassword().equals(currentuser.getPassword())) {
                System.out.println("inside post login:"+tempUser.getPassword());
                mav.setViewName("index");

            }
            else
                mav.setViewName("login");
        }
        else {
            mav.setViewName("login");

        }
        return mav;
    }
}



