package com.haru.repository;

import com.haru.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, LocalDate> {
    Optional<Diary> findByToday(LocalDate today);


    @Query("SELECT d FROM Diary d WHERE d.today < :date ORDER BY d.today DESC")
    Optional<Diary> findPreviousDiary(@Param("date") LocalDate date);

    @Query("SELECT d FROM Diary d WHERE d.today > :date ORDER BY d.today ASC")
    Optional<Diary> findNextDiary(@Param("date") LocalDate date);
}
