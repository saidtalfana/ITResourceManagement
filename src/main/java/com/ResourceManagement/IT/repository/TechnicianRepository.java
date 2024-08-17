package com.ResourceManagement.IT.repository;

import com.ResourceManagement.IT.model.Equipment;
import com.ResourceManagement.IT.model.Technician;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician,Long> {


}
