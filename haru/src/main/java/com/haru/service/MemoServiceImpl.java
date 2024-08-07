package com.haru.service;

import com.haru.entity.Folderlist;
import com.haru.entity.Memo;
import com.haru.repository.FolderRepository;
import com.haru.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MemoServiceImpl implements MemoService {

    @Autowired
    private MemoRepository memoRepository;
    @Autowired
    private FolderRepository folderRepository;

    //    모든 폴더 조회
    @Override
    public List<Folderlist> getAllFolders() {
        return folderRepository.findAll();
    }

    //    폴더 생성
    @Override
    public Folderlist createFolder(Folderlist folderlist) {
        return folderRepository.save(folderlist);
    }

    //    폴더 수정
    @Override
    public Folderlist updateFolder(int folderId, Folderlist folderlist) {
        Folderlist existingFolder = folderRepository.findById((long) folderId).orElseThrow(() -> new RuntimeException("Folder not found"));
        existingFolder.setFolderName(folderlist.getFolderName());
        return folderRepository.save(existingFolder);
    }

    //    폴더 삭제
    @Override
    public String deleteFolder(Long folderId) {
        if (folderId == 1)
            return "지울 수 없는 폴더입니다.";

        Optional<Folderlist> folderOptional = folderRepository.findById(folderId);
        if (folderOptional.isEmpty())
            return "폴더가 존재하지 않습니다.";

        List<Memo> memos = memoRepository.findAllByFolderlistFolderId(folderId);
        if (!memos.isEmpty())
            memoRepository.deleteAll(memos);

        folderRepository.deleteById(folderId);
        return "폴더가 삭제되었습니다.";
    }

    //    특정 폴더 내 메모 조회
    @Override
    public List<Memo> getNotesByFolderId(Long folderId) {
        return memoRepository.findAllByFolderlistFolderId(folderId);
    }

    //    특정 폴더 내 메모 생성
    @Override
    public Memo createNoteInFolder(Long folderId, Memo memo) {
        memo.setFolderlist(folderRepository.findById(folderId).orElseThrow(() -> new RuntimeException("Folder not found")));
        return memoRepository.save(memo);
    }

    //    메모 조회
    @Override
    public Memo getNoteDetails(Long folderId, Long noteId) {
        return memoRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    //    메모 내용 수정
    @Override
    public Memo updateNoteDetails(Long folderId, Long noteId, Memo memo) {
        Memo existingMemo = memoRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found"));
        existingMemo.setTitle(memo.getTitle());
        existingMemo.setContents(memo.getContents());
        existingMemo.setWriteDate(new Date());
        return memoRepository.save(existingMemo);
    }

    @Override
    public void deleteNoteDetails(Long folderId, Long noteId) {
        memoRepository.deleteById(noteId);
    }

    @Override
    public Memo getRecentMemo() {
        Pageable pageable = PageRequest.of(0, 1);
        List<Memo> recentMemos = memoRepository.findRecentMemo(pageable);
        return recentMemos.isEmpty() ? null : recentMemos.get(0);
    }
}
