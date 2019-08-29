package com.challenge.repository;

import com.challenge.entity.Company;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Long> {

  Optional<Company> findById(Long id);

  @Query(value = "select distinct cy.* from company as cy\n" +
      "join candidate as cd on cd.company_id = cy.id\n" +
      "join acceleration as ac on cd.acceleration_id = ac.id\n" +
      "where ac.id = :accelerationId", nativeQuery = true)
  List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);

  @Query(value = "select cy.* from company as cy\n" +
      "join candidate as cd on cd.company_id = cy.id\n" +
      "join users as us on cd.user_id = us.id\n" +
      "where us.id = :userId", nativeQuery = true)
  List<Company> findByUserId(@Param("userId") Long userId);
}
