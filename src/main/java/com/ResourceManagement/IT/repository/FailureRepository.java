package com.ResourceManagement.IT.repository;

import com.ResourceManagement.IT.model.Equipment;
import com.ResourceManagement.IT.model.Failure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FailureRepository extends JpaRepository<Failure, Long> {
}
