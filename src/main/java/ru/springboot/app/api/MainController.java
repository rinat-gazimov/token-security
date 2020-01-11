package ru.springboot.app.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.springboot.app.dao.UserDao;
import ru.springboot.app.service.user.UserService;

//@Controller
//@RequestMapping("/app")
public class MainController {

//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ResponseEntity login(@RequestBody UserDao userDao) {
//
//        UserDetails user = userService.loadUserByUsername(userDao.getUsername());
//        return new ResponseEntity(user, HttpStatus.OK);
//    }

}
