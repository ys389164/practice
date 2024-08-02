package com.haru.repository;

import com.haru.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByFolderlistFolderId(Long folderId);
}
