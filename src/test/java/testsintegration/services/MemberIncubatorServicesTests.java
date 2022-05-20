package testsintegration.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;

import kanimstv.dto.MemberIncubatorDto;
import kanimstv.dto.SearchMemberCriteriaDto;
import kanimstv.rest_controllers.MemberIncubatorRestController;

@SpringBootTest
@ContextConfiguration
public class MemberIncubatorServicesTests {

    @Autowired
    private MemberIncubatorRestController memberIncubatorRestController;

    @Configuration
    @ComponentScan({"kanimstv"})
    public static class SpringConfig {

    }
    
    @Test
    void getMembers() throws Exception {

	Page<MemberIncubatorDto> memberIncubatorPage = memberIncubatorRestController.getMembers(0, 10);
	
	assertThat(memberIncubatorPage.getContent().size()).isGreaterThan(0);
    }

    @Test
    void searchMembersByPseudonyme() throws Exception {

	SearchMemberCriteriaDto searchMemberCriteriaDto = new SearchMemberCriteriaDto();
	searchMemberCriteriaDto.setPseudonyme("LANCELEUR");

	Page<MemberIncubatorDto> memberIncubatorPage = memberIncubatorRestController.searchMembers(0, 10, searchMemberCriteriaDto);
	assertThat(memberIncubatorPage.getContent().size()).isGreaterThan(0);
    }

    @Test
    void searchMembersByPseudonymeAndIsOldMember() throws Exception {

	SearchMemberCriteriaDto searchMemberCriteriaDto = new SearchMemberCriteriaDto();
	searchMemberCriteriaDto.setPseudonyme("LANCELEUR");
	searchMemberCriteriaDto.setIsOldMember(false);

	Page<MemberIncubatorDto> memberIncubatorPage = memberIncubatorRestController.searchMembers(0, 10, searchMemberCriteriaDto);

	assertThat(memberIncubatorPage.getContent().size()).isGreaterThan(0);
    }

    @Test
    void searchMembersByRole() throws Exception {

	SearchMemberCriteriaDto searchMemberCriteriaDto = new SearchMemberCriteriaDto();
	searchMemberCriteriaDto.setRoleMemberId(1);

	Page<MemberIncubatorDto> memberIncubatorPage = memberIncubatorRestController.searchMembers(0, 10, searchMemberCriteriaDto);

	assertThat(memberIncubatorPage.getContent().size()).isGreaterThan(0);
    }
    
    @Test
    void modifyIsOldMemberField() {
	MemberIncubatorDto memberIncubatorDto = new MemberIncubatorDto();
	memberIncubatorDto.setId(1);
	memberIncubatorDto.setIsOldMember(false);
	
	memberIncubatorRestController.modifyIsOldMemberField(memberIncubatorDto);
    }
}
