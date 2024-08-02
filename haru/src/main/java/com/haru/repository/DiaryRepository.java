package com.haru.repository;

import com.haru.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, LocalDate> {
    Optional<Diary> findByToday(LocalDate today);
}
