package com.exadel.frs.commonservice.repository;

import com.exadel.frs.commonservice.entity.Subject;
import com.exadel.frs.commonservice.entity.SubjectDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/* SITA MCoE - SubjectDetailsRepository */
public interface SubjectDetailsRepository extends PagingAndSortingRepository<SubjectDetails, UUID> {

    Optional<SubjectDetails> findByUpk(String upk);

}
