package cl.practica.desafio.mymarket.controller;

import cl.practica.desafio.mymarket.domain.RoleDTO;
import cl.practica.desafio.mymarket.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // READ
    @RequestMapping(method = RequestMethod.GET)
    public List<RoleDTO> getRole() { return roleService.getRole(); }

    // CREATE
    @RequestMapping(method = RequestMethod.POST)
    public String createRole(@RequestBody RoleDTO role) { return roleService.createRole(role); }

    // UPDATE
    @RequestMapping(method = RequestMethod.PUT)
    public String updateRole(@RequestBody RoleDTO role) { return roleService.updateRole(role); }

    // DELETE
    @RequestMapping(method = RequestMethod.DELETE,value = "/{idRole}")
    public String deleteRole(@PathVariable("idRole") Integer role) { return roleService.deleteRole(role); }
}
