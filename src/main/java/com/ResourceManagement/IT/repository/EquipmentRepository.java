package com.ResourceManagement.IT.repository;

import com.ResourceManagement.IT.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

 @Query(value = "select * from equipment where user_id=?" , nativeQuery = true)
    List<Equipment> findEquipmentByUserId(Long userId);
}
