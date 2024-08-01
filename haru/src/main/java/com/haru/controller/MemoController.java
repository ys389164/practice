package com.haru.controller;

import com.haru.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/api")
public class MemoController {

    @Autowired
    MemoService memoService;

//    메인(폴더) 페이지

    @GetMapping("/folders")
    public String folders() {
//        폴더 조회
        return "folders";
    }

    @PostMapping("/folders")
    public String foldersPost() {
//        폴더 추가
        return "folders";
    }
    
    @PutMapping("/folders")
    public String foldersPut() {
//        폴더 수정
        return "folders";
    }
    
    @DeleteMapping("/folders")
    public String foldersDelete() {
//        폴더 삭제 & 하위도 같이
        return "folders";
    }

    @PostMapping("/notes")
    public String notes() {
//        기본 폴더에 메모 작성
        return "notes";
    }


//    -----------------
//    폴더 내 메모 리스트 페이지

    @GetMapping("/folders/{folderId}/notes")
    public String notes(@PathVariable("folderId") Long folderId) {
//        특정 폴더 내 메모 목록 조회
        return "notes";
    }

    @PostMapping("/folders/{folderId}/notes")
    public String createNotes(@PathVariable("folderId") Long folderId){
//        폴더 내부에서 메모 추가
        return "notes";
    }

    @DeleteMapping("/folders/folderId/notes/{noteId}")
    public String deleteNotes(@PathVariable("noteId") Long noteId) {
//        폴더 내부에서 메모 제거
        return "notes";
    }


//----------------------
//    상세 페이지, 조회
    @GetMapping("/notes/{folderId}/notes/{noteId}")
    public String notes(@PathVariable("folderId") Long folderId,@PathVariable("noteId") Long noteId){
        return "notes";
    }

//    수정 페이지
    @PutMapping("/notes/{folderId}/notes/{noteId}")
    public String updateNotes(@PathVariable("folderId") Long folderId, @PathVariable("noteId") Long noteId) {
        return "notes";
    }

    @DeleteMapping("/notes/{folderId}/notes/{noteId}")
    public String deleteNotes(@PathVariable("folderId") Long folderId, @PathVariable("noteId") Long noteId) {
//        상세 페이지 내부에서 메모 삭제
        return "notes";
    }

}
