package kanimstv.dao.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kanimstv.dao.entities.RolePermissionEntity;

public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity, Integer> {
    Optional<RolePermissionEntity> findByName(String name);
}
