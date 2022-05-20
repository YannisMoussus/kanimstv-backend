package kanimstv.business_logic;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import kanimstv.dao.entities.MemberIncubatorEntity;
import kanimstv.dao.managers.MemberIncubatorDataAccessManager;
import kanimstv.dto.MemberIncubatorDto;
import kanimstv.dto.SearchMemberCriteriaDto;
import kanimstv.dto.mappers.MemberIncubatorMapper;
import kanimstv.enums.ExceptionMessageEnum;
import kanimstv.exceptions.ResourceNotFoundException;


@Service
public class MemberIncubatorLogic {

    @Autowired
    private MemberIncubatorMapper memberIncubatorMapper;

    @Autowired
    private MemberIncubatorDataAccessManager memberIncubatorDataAccessManager;

    public MemberIncubatorDto createMember(MemberIncubatorDto memberIncubatorDto){
	MemberIncubatorEntity memberIncubatorEntity = memberIncubatorMapper.mapDtoToEntity(memberIncubatorDto);
	return memberIncubatorMapper.mapEntityToDto(memberIncubatorDataAccessManager.save(memberIncubatorEntity));
    }

    public Page<MemberIncubatorDto> searchMembers(int page, int size, SearchMemberCriteriaDto searchMemberCriteria) {
	return memberIncubatorMapper.mapEntityPageToDtoPage(memberIncubatorDataAccessManager.searchMembers(page, size, searchMemberCriteria));
    }

    public MemberIncubatorDto getMemberById(int id){
	Optional<MemberIncubatorEntity> memberIncubatorEntityOptional = memberIncubatorDataAccessManager.findById(id);
	if(memberIncubatorEntityOptional.isPresent()) {
	    return memberIncubatorMapper.mapEntityToDto(memberIncubatorEntityOptional.get());
	} else {
	    throw new ResourceNotFoundException(ExceptionMessageEnum.MEMBER_INCUBATOR_NOT_FOUND.getMessage());
	}
    }

    public void deleteMember(int id){
	memberIncubatorDataAccessManager.deleteById(id);
    }

    public MemberIncubatorDto updateMember(MemberIncubatorDto memberIncubatorDto){
	Optional<MemberIncubatorEntity> memberIncubatorEntityOptional = memberIncubatorDataAccessManager.findById(memberIncubatorDto.getId());

	if(memberIncubatorEntityOptional.isPresent()) {
	    MemberIncubatorEntity memberIncubatorEntity = memberIncubatorEntityOptional.get();
	    memberIncubatorMapper.mapDtoToEntity(memberIncubatorEntity, memberIncubatorDto);
	    return memberIncubatorMapper.mapEntityToDto(memberIncubatorDataAccessManager.save(memberIncubatorEntity));
	} else {
	    throw new ResourceNotFoundException(ExceptionMessageEnum.MEMBER_INCUBATOR_NOT_FOUND.getMessage()); 
	}
    }

    public Page<MemberIncubatorDto> getMembers(int page, int size) {
	return memberIncubatorMapper.mapEntityPageToDtoPage(memberIncubatorDataAccessManager.findAll(page, size));
    }

    public MemberIncubatorDto modifyIsOldMemberField(MemberIncubatorDto memberIncubatorDto) {
	Optional<MemberIncubatorEntity> memberIncubatorEntityOptional = memberIncubatorDataAccessManager.findById(memberIncubatorDto.getId());
	if (memberIncubatorEntityOptional.isPresent()) {
	    MemberIncubatorEntity memberIncubatorEntity = memberIncubatorEntityOptional.get();
	    memberIncubatorEntity.setIsOldMember(memberIncubatorDto.getIsOldMember());	    
	    return memberIncubatorMapper.mapEntityToDto(memberIncubatorDataAccessManager.save(memberIncubatorEntity));
	} else {
	    throw new ResourceNotFoundException(ExceptionMessageEnum.MEMBER_INCUBATOR_NOT_FOUND.getMessage()); 
	}
    }
}