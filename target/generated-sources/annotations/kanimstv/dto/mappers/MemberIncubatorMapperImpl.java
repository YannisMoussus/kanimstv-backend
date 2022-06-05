package kanimstv.dto.mappers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import kanimstv.dao.entities.MemberIncubatorEntity;
import kanimstv.dao.entities.RolePermissionEntity;
import kanimstv.dto.MemberIncubatorDto;
import kanimstv.dto.RolePermissionDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-05T14:22:26+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 16.0.1 (AdoptOpenJDK)"
)
@Component
public class MemberIncubatorMapperImpl implements MemberIncubatorMapper {

    @Override
    public MemberIncubatorDto mapEntityToDto(MemberIncubatorEntity memberIncubatorEntity) {
        if ( memberIncubatorEntity == null ) {
            return null;
        }

        MemberIncubatorDto memberIncubatorDto = new MemberIncubatorDto();

        memberIncubatorDto.setId( memberIncubatorEntity.getId() );
        memberIncubatorDto.setPseudonyme( memberIncubatorEntity.getPseudonyme() );
        memberIncubatorDto.setEmail( memberIncubatorEntity.getEmail() );
        memberIncubatorDto.setPhoneNumber( memberIncubatorEntity.getPhoneNumber() );
        memberIncubatorDto.setIsOldMember( memberIncubatorEntity.getIsOldMember() );
        memberIncubatorDto.setPassword( memberIncubatorEntity.getPassword() );
        memberIncubatorDto.setRolesPermission( rolePermissionEntitySetToRolePermissionDtoSet( memberIncubatorEntity.getRolesPermission() ) );

        return memberIncubatorDto;
    }

    @Override
    public MemberIncubatorEntity mapDtoToEntity(MemberIncubatorDto memberIncubatorDto) {
        if ( memberIncubatorDto == null ) {
            return null;
        }

        MemberIncubatorEntity memberIncubatorEntity = new MemberIncubatorEntity();

        memberIncubatorEntity.id( memberIncubatorDto.getId() );
        memberIncubatorEntity.pseudonyme( memberIncubatorDto.getPseudonyme() );
        memberIncubatorEntity.email( memberIncubatorDto.getEmail() );
        memberIncubatorEntity.phoneNumber( memberIncubatorDto.getPhoneNumber() );
        memberIncubatorEntity.isOldMember( memberIncubatorDto.getIsOldMember() );
        memberIncubatorEntity.setPassword( memberIncubatorDto.getPassword() );
        memberIncubatorEntity.setRolesPermission( rolePermissionDtoSetToRolePermissionEntitySet( memberIncubatorDto.getRolesPermission() ) );

        return memberIncubatorEntity;
    }

    @Override
    public List<MemberIncubatorDto> mapEntityListToDtoList(List<MemberIncubatorEntity> memberIncubatorEntity) {
        if ( memberIncubatorEntity == null ) {
            return null;
        }

        List<MemberIncubatorDto> list = new ArrayList<MemberIncubatorDto>( memberIncubatorEntity.size() );
        for ( MemberIncubatorEntity memberIncubatorEntity1 : memberIncubatorEntity ) {
            list.add( mapEntityToDto( memberIncubatorEntity1 ) );
        }

        return list;
    }

    @Override
    public void mapDtoToEntity(MemberIncubatorEntity memberIncubatorEntity, MemberIncubatorDto memberIncubatorDto) {
        if ( memberIncubatorDto == null ) {
            return;
        }

        memberIncubatorEntity.id( memberIncubatorDto.getId() );
        memberIncubatorEntity.pseudonyme( memberIncubatorDto.getPseudonyme() );
        memberIncubatorEntity.email( memberIncubatorDto.getEmail() );
        memberIncubatorEntity.phoneNumber( memberIncubatorDto.getPhoneNumber() );
        memberIncubatorEntity.isOldMember( memberIncubatorDto.getIsOldMember() );
        memberIncubatorEntity.setPassword( memberIncubatorDto.getPassword() );
        if ( memberIncubatorEntity.getRolesPermission() != null ) {
            Set<RolePermissionEntity> set = rolePermissionDtoSetToRolePermissionEntitySet( memberIncubatorDto.getRolesPermission() );
            if ( set != null ) {
                memberIncubatorEntity.getRolesPermission().clear();
                memberIncubatorEntity.getRolesPermission().addAll( set );
            }
            else {
                memberIncubatorEntity.setRolesPermission( null );
            }
        }
        else {
            Set<RolePermissionEntity> set = rolePermissionDtoSetToRolePermissionEntitySet( memberIncubatorDto.getRolesPermission() );
            if ( set != null ) {
                memberIncubatorEntity.setRolesPermission( set );
            }
        }
    }

    protected RolePermissionDto rolePermissionEntityToRolePermissionDto(RolePermissionEntity rolePermissionEntity) {
        if ( rolePermissionEntity == null ) {
            return null;
        }

        RolePermissionDto rolePermissionDto = new RolePermissionDto();

        rolePermissionDto.setId( rolePermissionEntity.getId() );
        rolePermissionDto.setName( rolePermissionEntity.getName() );

        return rolePermissionDto;
    }

    protected Set<RolePermissionDto> rolePermissionEntitySetToRolePermissionDtoSet(Set<RolePermissionEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<RolePermissionDto> set1 = new HashSet<RolePermissionDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RolePermissionEntity rolePermissionEntity : set ) {
            set1.add( rolePermissionEntityToRolePermissionDto( rolePermissionEntity ) );
        }

        return set1;
    }

    protected RolePermissionEntity rolePermissionDtoToRolePermissionEntity(RolePermissionDto rolePermissionDto) {
        if ( rolePermissionDto == null ) {
            return null;
        }

        RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();

        rolePermissionEntity.setId( rolePermissionDto.getId() );
        rolePermissionEntity.setName( rolePermissionDto.getName() );

        return rolePermissionEntity;
    }

    protected Set<RolePermissionEntity> rolePermissionDtoSetToRolePermissionEntitySet(Set<RolePermissionDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<RolePermissionEntity> set1 = new HashSet<RolePermissionEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RolePermissionDto rolePermissionDto : set ) {
            set1.add( rolePermissionDtoToRolePermissionEntity( rolePermissionDto ) );
        }

        return set1;
    }
}
