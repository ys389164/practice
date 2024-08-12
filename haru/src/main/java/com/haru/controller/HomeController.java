package com.haru.controller;

import com.haru.entity.Diary;
import com.haru.entity.Memo;
import com.haru.service.DiaryService;
import com.haru.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private DiaryService diaryService;

    @Autowired
    private MemoService memoService;

    @GetMapping("/recentBundle")
    @ResponseBody
    public Map<String, Object> recentBundle() {
//        가장 최근에 생성 or 수정된 메모 내용 가져오기
//        diary 금일 작성했는지 안했는지, 작성되어있으면 클릭시, view page
//        아니면 "아직 작성 안 됨" text와 클릭시, write page로
        Map<String, Object> response = new HashMap<>();
        Memo recentMemo = memoService.getRecentMemo();
        boolean recentDiary = diaryService.checkToday();

        if (recentDiary) {
            Date today = new Date();
            Diary diary = diaryService.getDiaryByDate(new SimpleDateFormat("yyyy-MM-dd").format(today));
            String contents = diary != null ? diary.getContents() : "no diary entry found";

            response.put("recentDiary", true);
            response.put("diaryContents", contents);
            response.put("diaryLink", "/viewDiary");
        } else {
            response.put("recentDiary", false);
            response.put("diaryContents", "아직 작성 안 됨");
            response.put("diaryLink", "/writeDiary");
        }

        response.put("recentMemo", recentMemo != null ? recentMemo.getContents() : "No recent memo found");
        return response;
    }



    @GetMapping("/calendarBundle")
    public List<String> calendarBundle(@RequestParam("year") int year, @RequestParam("month") int month) {
        return diaryService.getStatusTF(year, month);
//        {"2024-08-01", "2024-08-02"}
//        return Collections.singletonList("Hello");
    }
}
