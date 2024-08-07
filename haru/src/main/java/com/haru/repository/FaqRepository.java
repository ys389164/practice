package com.haru.repository;

import com.haru.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FaqRepository extends JpaRepository<Faq, Integer> {

    @Query("SELECT f FROM Faq f WHERE f.group.groupId = :idx")
    List<Faq> findByGroupId(@Param("idx") int idx);
}
