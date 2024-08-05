package com.haru.repository;

import com.haru.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByFolderlistFolderId(Long folderId);

    @Query("SELECT m FROM Memo m ORDER BY m.writeDate DESC")
    List<Memo> findRecentMemo(Pageable pageable);
}
