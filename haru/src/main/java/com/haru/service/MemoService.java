package com.haru.service;

import com.haru.entity.Folderlist;
import com.haru.entity.Memo;

import java.util.List;

public interface MemoService {
    List<Folderlist> getAllFolders();
    Folderlist createFolder(Folderlist folderlist);
    Folderlist updateFolder(Long folderId, Folderlist folderlist);
    void deleteFolder(Long folderId);

    List<Memo> getNotesByFolderId(Long folderId);
    Memo createNoteInFolder(Long folderId, Memo memo);

    Memo getNoteDetails(Long folderId, Long noteId);
    Memo updateNoteDetails(Long folderId, Long noteId, Memo memo);
    void deleteNoteDetails(Long folderId, Long noteId);
}
