package kanimstv.dto.mappers;
import java.util.List;

import org.mapstruct.Mapper;

import kanimstv.dao.entities.RolePermissionEntity;
import kanimstv.dto.RolePermissionDto;

@Mapper(
    componentModel = "spring"
)
public interface RolePermissionMapper {

    RolePermissionDto mapEntityToDto(RolePermissionEntity rolePermissionEntity);
    RolePermissionEntity mapDtoToEntity(RolePermissionDto rolePermissionDto);
    List<RolePermissionDto> mapEntityListToDtoList(List<RolePermissionEntity> rolePermissionEntity);
    List<RolePermissionEntity> mapDtoListToEntityList(List<RolePermissionDto> rolePermissionDto);
    
}
