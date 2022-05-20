package kanimstv.dto.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import kanimstv.dao.entities.MemberIncubatorEntity;
import kanimstv.dto.MemberIncubatorDto;


@Mapper(
    componentModel = "spring"
)
public interface MemberIncubatorMapper {
   
    
    default Page<MemberIncubatorDto> mapEntityPageToDtoPage(Page<MemberIncubatorEntity> memberIncubatorEntity){
        return memberIncubatorEntity.map(this::mapEntityToDto);
    };
    
    MemberIncubatorDto mapEntityToDto(MemberIncubatorEntity memberIncubatorEntity);
    MemberIncubatorEntity mapDtoToEntity(MemberIncubatorDto memberIncubatorDto);
    List<MemberIncubatorDto> mapEntityListToDtoList(List<MemberIncubatorEntity> memberIncubatorEntity);
    void mapDtoToEntity(@MappingTarget MemberIncubatorEntity memberIncubatorEntity, MemberIncubatorDto memberIncubatorDto);
}