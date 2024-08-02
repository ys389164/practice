package com.haru.repository;

import com.haru.entity.Folderlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folderlist, Long> {
}
