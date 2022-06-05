package kanimstv.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kanimstv.dao.entities.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer>{

}
