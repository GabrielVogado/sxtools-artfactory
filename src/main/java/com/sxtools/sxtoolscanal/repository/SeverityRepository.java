package com.sxtools.sxtoolscanal.repository;

import com.sxtools.sxtoolscanal.entity.Severity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeverityRepository extends JpaRepository<Severity, Integer> {
}
