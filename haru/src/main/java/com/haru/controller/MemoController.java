package com.haru.controller;

import com.haru.entity.Folderlist;
import com.haru.entity.Memo;
import com.haru.repository.FolderRepository;
import com.haru.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemoController {

    @Autowired
    private MemoService memoService;

    @GetMapping("/folders")
    public List<Folderlist> getAllFolders() {
        // 폴더 전체 조회
//        폴더 시르트로 button? list 작성 할 예정
        return memoService.getAllFolders();
    }

    @PostMapping("/folders")
    public Folderlist createFolder(@RequestBody Folderlist folderlist) {
        // 폴더 생성
//        input 모달 생성?
        return memoService.createFolder(folderlist);
    }

    @PutMapping("/folders")
    public Folderlist updateFolder(@RequestBody Folderlist folderlist) {
//         폴더 수정
//        input 모달 똑같이 생성 예정
//        input 창에 이전 값이 들어가있을 수 있도록
//        value 변경 시, folderList가 수정 됨 foldername이 바뀔 예정
        return memoService.updateFolder(folderlist.getFolderId(), folderlist);
    }

    @DeleteMapping("/folders/{folderId}")
    public String deleteFolder(@PathVariable Long folderId) {
        // 폴더 삭제
//        cascade로 메모까지 다 삭제
        return memoService.deleteFolder(folderId);
    }

    @GetMapping("/folders/{folderId}/notes")
    public List<Memo> getNotesByFolderId(@PathVariable Long folderId) {
        // 폴더 내 메모 리스트 페이지
        // 폴더 내 메모들 조회
        return memoService.getNotesByFolderId(folderId);
    }

    @PostMapping("/folders/{folderId}/notes")
    public Memo createNoteInFolder(@PathVariable Long folderId, @RequestBody Memo memo) {
        // 폴더 내부에서 메모 생성
//        메모 작성 페이지로 넘어가기
        return memoService.createNoteInFolder(folderId, memo);
    }

    @GetMapping("/folders/{folderId}/notes/{noteId}")
    public Memo getNoteDetails(@PathVariable Long folderId, @PathVariable Long noteId) {
        // 노트 상세 페이지
        // 메모 조회
        return memoService.getNoteDetails(folderId, noteId);
    }

    @PutMapping("/folders/{folderId}/notes/{noteId}")
    public Memo updateNoteDetails(@PathVariable Long folderId, @PathVariable Long noteId, @RequestBody Memo memo) {
        // 메모 수정

        return memoService.updateNoteDetails(folderId, noteId, memo);
    }

    @DeleteMapping("/folders/{folderId}/notes/{noteId}")
    public void deleteNoteDetails(@PathVariable Long folderId, @PathVariable Long noteId) {
        // 메모 삭제
        memoService.deleteNoteDetails(folderId, noteId);
    }

    // 기본 폴더에 메모 생성
    @PostMapping("/defaultFolder/notes")
    public Memo createNoteInDefaultFolder(@RequestBody Memo memo) {
        return memoService.createNoteInFolder(1L, memo);
    }
}
