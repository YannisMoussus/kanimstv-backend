package kanimstv.business_logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kanimstv.dao.entities.RolePermissionEntity;
import kanimstv.dao.repositories.RolePermissionRepository;
import kanimstv.dto.RolePermissionDto;
import kanimstv.dto.mappers.RolePermissionMapper;


@Service
public class RolePermissionLogic {
    
    @Autowired
    private RolePermissionRepository repository;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    
    public RolePermissionDto createRolePermission(RolePermissionDto rolePermissionDto){
        RolePermissionEntity rolePermissionEntity = rolePermissionMapper.mapDtoToEntity(rolePermissionDto);
        return rolePermissionMapper.mapEntityToDto(repository.save(rolePermissionEntity));
    }

    public List<RolePermissionDto> getRolesPermission(){
        return rolePermissionMapper.mapEntityListToDtoList(repository.findAll());
    }

    public RolePermissionDto getRolePermissionById(int id){
        return rolePermissionMapper.mapEntityToDto(repository.findById(id).orElse(null));   
    }

    public String deleteRolePermission(int id){
        repository.deleteById(id);
        return "Role Permission removed" + id;
    }

    public RolePermissionDto updateRolePermission(RolePermissionDto rolePermissionDto){
        RolePermissionEntity existingRolePermission = repository.findById(rolePermissionDto.getId()).orElse(null);
	    existingRolePermission.setName(rolePermissionDto.getName());
        return rolePermissionMapper.mapEntityToDto(repository.save(existingRolePermission));
    }
    
}
