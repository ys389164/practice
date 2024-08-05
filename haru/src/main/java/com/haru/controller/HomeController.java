package com.haru.controller;

import com.haru.entity.Diary;
import com.haru.entity.Memo;
import com.haru.service.DiaryService;
import com.haru.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private DiaryService diaryService;

    @Autowired
    private MemoService memoService;

    @GetMapping("/recentBundle")
    public String recentBundle(Model model) {

//        memo, diary
//        가장 최근에 생성 or 수정된 메모 내용 가져오기
//        diary 금일 작성했는지 안했는지, 작성되어있으면 클릭시, view page
//        아니면 "아직 작성 안 됨" text와 클릭시, write page로
        Memo recentMemo = memoService.getRecentMemo();
        boolean recentDiary = diaryService.checkToday();

        if (recentDiary) {
            // 작성되어 있으면 true
            model.addAttribute("recentDiary", true);
            Date today = new Date();
            Diary diary = diaryService.getDiaryByDate(new SimpleDateFormat("yyyy-mm-dd").format(today));
            String contents = diary != null? diary.getContent() : "no diary entry found";

            model.addAttribute("diaryContents", contents);
            model.addAttribute("diaryLink", "/viewDiary");
        } else {
            model.addAttribute("recentDiary", false);
            model.addAttribute("diaryContents", "아직 작성 안 됨");
            model.addAttribute("diaryLink", "/writeDiary");
        }

        model.addAttribute("recentMemo", recentMemo != null ? recentMemo.getContent() : "No recent memo found");
        return "HelloWorld";
    }


    @GetMapping("/calendarBundle")
    public List<String> calendarBundle() {
        return diaryService.getStatusTF();
    }
}
