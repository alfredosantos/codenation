package com.challenge.repository;

import com.challenge.entity.Acceleration;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

  Optional<Acceleration> findById(Long id);

  Optional<Acceleration> findByName(String name);

  @Query(value = "select ac.* from acceleration as ac\n" +
      "join candidate as cd on cd.acceleration_id = ac.id\n" +
      "join company as cy on cd.company_id = cy.id\n" +
      "where cy.id = :companyId", nativeQuery = true)
  List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);

}