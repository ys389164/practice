package com.haru.controller;

import com.haru.entity.Folderlist;
import com.haru.entity.Memo;
import com.haru.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemoController {

    @Autowired
    private MemoService memoService;

    // 폴더 전체 조회
    @GetMapping("/folders")
    public List<Folderlist> getAllFolders() {
        return memoService.getAllFolders();
    }

    // 폴더 생성
    @PostMapping("/folders")
    public Folderlist createFolder(@RequestBody Folderlist folderlist) {
        return memoService.createFolder(folderlist);
    }

    // 폴더 수정
    @PutMapping("/folders")
    public Folderlist updateFolder(@RequestBody Folderlist folderlist) {
        return memoService.updateFolder(folderlist.getFolderId(), folderlist);
    }

    // 폴더 삭제
    @DeleteMapping("/folders/{folderId}")
    public void deleteFolder(@PathVariable Long folderId) {
        memoService.deleteFolder(folderId);
    }


    // 폴더 내 메모 리스트 페이지
    // 폴더 내 메모들 조회
    @GetMapping("/folders/{folderId}/notes")
    public List<Memo> getNotesByFolderId(@PathVariable Long folderId) {
        return memoService.getNotesByFolderId(folderId);
    }

    // 폴더 내부에서 메모 생성
    @PostMapping("/folders/{folderId}/notes")
    public Memo createNoteInFolder(@PathVariable Long folderId, @RequestBody Memo memo) {
        return memoService.createNoteInFolder(folderId, memo);
    }

    // 노트 상세 페이지
    // 메모 조회
    @GetMapping("/folders/{folderId}/notes/{noteId}")
    public Memo getNoteDetails(@PathVariable Long folderId, @PathVariable Long noteId) {
        return memoService.getNoteDetails(folderId, noteId);
    }

    // 메모 수정
    @PutMapping("/folders/{folderId}/notes/{noteId}")
    public Memo updateNoteDetails(@PathVariable Long folderId, @PathVariable Long noteId, @RequestBody Memo memo) {
        return memoService.updateNoteDetails(folderId, noteId, memo);
    }

    // 메모 삭제
    @DeleteMapping("/folders/{folderId}/notes/{noteId}")
    public void deleteNoteDetails(@PathVariable Long folderId, @PathVariable Long noteId) {
        memoService.deleteNoteDetails(folderId, noteId);
    }

    // 기본 폴더에 메모 생성
    @PostMapping("/defaultFolder/notes")
    public Memo createNoteInDefaultFolder(@RequestBody Memo memo) {
        return memoService.createNoteInFolder(1L, memo);
    }
}
