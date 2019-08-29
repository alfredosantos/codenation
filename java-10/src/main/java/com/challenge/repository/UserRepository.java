package com.challenge.repository;

import com.challenge.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findById(Long userId);

  @Query(value = "select us.* from users as us\n" +
      "join candidate as cd on cd.user_id = us.id\n" +
      "join acceleration as ac on cd.acceleration_id = ac.id\n" +
      "where ac.name like %:name%", nativeQuery = true)
  List<User> findByAccelerationName(@Param("name") String name);

  @Query(value = "select us.* from users as us\n" +
      "join candidate as cd on cd.user_id = us.id\n" +
      "join company as cy on cd.company_id = cy.id\n" +
      "where cy.id = :companyId", nativeQuery = true)
  List<User> findByCompanyId(@Param("companyId") Long companyId);
}