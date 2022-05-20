package kanimstv.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kanimstv.business_logic.RolePermissionLogic;
import kanimstv.dto.RolePermissionDto;

@RestController
@RequestMapping("/permission-roles")
public class RolePermissionRestController {

    @Autowired
    private RolePermissionLogic rolePermissionLogic;

    @PostMapping
    public RolePermissionDto createRolePermission(@RequestBody RolePermissionDto rolePermissionDto){
        return rolePermissionLogic.createRolePermission(rolePermissionDto);
    }

    @GetMapping
    public List<RolePermissionDto> getRolesPermission(@RequestParam(required = false) String role){
        return rolePermissionLogic.getRolesPermission();
    }

    @GetMapping("/{id}")
    public RolePermissionDto getRolePermissionById(@PathVariable int id){
        return rolePermissionLogic.getRolePermissionById(id);
    }

    @PutMapping
    public RolePermissionDto updateRolePermission(@RequestBody RolePermissionDto rolePermissionDto){
        return rolePermissionLogic.updateRolePermission(rolePermissionDto);
    }

    @DeleteMapping("/{id}")
    public String deleteRolePermission(@PathVariable int id){
        return rolePermissionLogic.deleteRolePermission(id);
    }
}
