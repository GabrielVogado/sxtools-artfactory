package com.sxtools.sxtoolscanal.repository;

import com.sxtools.sxtoolscanal.entity.ContactMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMethodRepository extends JpaRepository<ContactMethod, Integer> {
}
