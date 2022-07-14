package com.example.galaxyproyecto.repository;

import com.example.galaxyproyecto.model.Programming;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProgrammingRepository extends JpaRepository<Programming, Integer> {

        @Query("select p from Programming p where p.state=1")	//JPQL
        List<Programming> findAllCustom();

     /*   @Query("select p from Programming p where Upper(p.name) like upper(:name) and p.state=1")	//JPQL
        List<Programming> findByLikeName(@Param("name") String name);

        @Query("select p from Programming p where Upper(p.name) like upper(:name) and p.state=1")
        Page<Programming> findByLikeNamePaging(Pageable pageable, @Param("name") String name);*/
}
