package kanimstv.dao.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import kanimstv.dao.entities.MemberIncubatorEntity;
import kanimstv.dao.repositories.MemberIncubatorRepository;
import kanimstv.dto.SearchMemberCriteriaDto;

@Repository
public class MemberIncubatorDataAccessManager {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MemberIncubatorRepository repository;

    public Page<MemberIncubatorEntity> searchMembers(int page, int size, SearchMemberCriteriaDto searchMemberCriteria) {

	//Sort member list by name in ascending order 
	Pageable pageable = PageRequest.of(page, size);

	CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	CriteriaQuery<MemberIncubatorEntity> criteriaQuery = criteriaBuilder.createQuery(MemberIncubatorEntity.class);
	Root<MemberIncubatorEntity> memberIncubator = criteriaQuery.from(MemberIncubatorEntity.class);

	List<Predicate> predicates = new ArrayList<Predicate>();

	if(StringUtils.isNotEmpty(searchMemberCriteria.getPseudonyme())) {
	    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(memberIncubator.get("pseudonyme")), "%" + searchMemberCriteria.getPseudonyme().toLowerCase()));            
	}

	if (searchMemberCriteria.getIsOldMember() != null && !searchMemberCriteria.getIsOldMember().booleanValue()) {
	    predicates.add(criteriaBuilder.equal(memberIncubator.get("isOldMember").as(Boolean.class), searchMemberCriteria.getIsOldMember()));
	}
	
	if(searchMemberCriteria.getRoleMemberId() != null) {
	    predicates.add(criteriaBuilder.equal(memberIncubator.get("role").get("id"), searchMemberCriteria.getRoleMemberId()));
	}

	criteriaQuery.where(criteriaBuilder.and(predicates.toArray( new Predicate[predicates.size()]))).orderBy(criteriaBuilder.asc(memberIncubator.get("pseudonyme")));

	List<MemberIncubatorEntity> membersFindedPageable = entityManager.createQuery(criteriaQuery).setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();

	CriteriaQuery<Long> totalMembersFindedQuery = criteriaBuilder.createQuery(Long.class);
	Root<MemberIncubatorEntity> totalMembersFindedQueryRootQuery = totalMembersFindedQuery.from(MemberIncubatorEntity.class);
	totalMembersFindedQuery.select(criteriaBuilder.count(totalMembersFindedQueryRootQuery)).where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
	Long totalMembersFinded = entityManager.createQuery(totalMembersFindedQuery).getSingleResult();

	Page<MemberIncubatorEntity> membersFindedPage = new PageImpl<>(membersFindedPageable, pageable, totalMembersFinded);

	return membersFindedPage;
    }

    public Page<MemberIncubatorEntity> findAll(int page, int size) {

	//Sort member list by name in ascending order 
	Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "pseudonyme"));

	return repository.findAll(pageable);
    }

    public MemberIncubatorEntity save(MemberIncubatorEntity memberIncubatorEntity) {
	return repository.save(memberIncubatorEntity);
    }

    public Optional<MemberIncubatorEntity> findById(int id) {
	return repository.findById(id);
    }

    public void deleteById(int id) {
	repository.deleteById(id);
    }
}
