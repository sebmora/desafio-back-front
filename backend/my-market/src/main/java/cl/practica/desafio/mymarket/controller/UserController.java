package cl.practica.desafio.mymarket.controller;

import cl.practica.desafio.mymarket.domain.UserDTO;
import cl.practica.desafio.mymarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // READ
    @RequestMapping(method = RequestMethod.GET)
    public List<UserDTO> getUser() {
        return userService.getUser();
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST)
    public String createUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }

    // UPDATE
    @RequestMapping(method = RequestMethod.PUT)
    public String updateUser(@RequestBody UserDTO user) {
        return userService.updateUser(user);
    }

    // DELETE
    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteUser(@RequestParam String dni) {
        return userService.deleteUser(dni);
    }

}