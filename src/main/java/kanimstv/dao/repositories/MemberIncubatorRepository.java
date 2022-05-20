package kanimstv.dao.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import kanimstv.dao.entities.MemberIncubatorEntity;

public interface MemberIncubatorRepository extends PagingAndSortingRepository<MemberIncubatorEntity, Integer> {

    List<MemberIncubatorEntity> findByOrderByPseudonymeAsc();
    Optional<MemberIncubatorEntity> findByEmail(String email);
    Boolean existsByPseudonyme(String pseudonyme);
    Boolean existsByEmail(String email);
}
