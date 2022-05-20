package kanimstv.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kanimstv.business_logic.MemberIncubatorLogic;
import kanimstv.dto.MemberIncubatorDto;
import kanimstv.dto.SearchMemberCriteriaDto;
import kanimstv.enums.ExceptionMessageEnum;
import kanimstv.exceptions.BadRequestException;

@RestController
@RequestMapping("/members")
public class MemberIncubatorRestController {

    @Autowired
    private MemberIncubatorLogic memberIncubatorLogic;

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable int id){
	memberIncubatorLogic.deleteMember(id);
    }

    @GetMapping("/{id}")
    public MemberIncubatorDto getMemberById(@PathVariable int id){
	return memberIncubatorLogic.getMemberById(id);
    }

    @GetMapping
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public Page<MemberIncubatorDto> getMembers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "150") int size){
	return memberIncubatorLogic.getMembers(page, size);
    }
    
    @PatchMapping("/is-old-member")
    public MemberIncubatorDto modifyIsOldMemberField(@RequestBody MemberIncubatorDto memberIncubatorDto) {
	return memberIncubatorLogic.modifyIsOldMemberField(memberIncubatorDto);
    }

    @PostMapping    
    public MemberIncubatorDto createMember(@RequestBody MemberIncubatorDto memberDto){
	return memberIncubatorLogic.createMember(memberDto);
    }

    @PostMapping("/searches")
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public Page<MemberIncubatorDto> searchMembers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size, @RequestBody SearchMemberCriteriaDto searchMemberCriteria){
	if(searchMemberCriteria != null) {
	    return memberIncubatorLogic.searchMembers(page, size, searchMemberCriteria);
	} else {
	    throw new BadRequestException(String.format(ExceptionMessageEnum.FIELD_OBLIGATORY.getMessage(), "searchMemberCriteria"));
	}
    }

    @PutMapping
    public MemberIncubatorDto updateMember(@RequestBody MemberIncubatorDto memberDto){
	return memberIncubatorLogic.updateMember(memberDto);
    }
}
