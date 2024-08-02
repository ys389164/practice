package com.haru.service;

import com.haru.entity.Diary;
import java.util.List;

public interface DiaryService {
    Diary getStatusTF();
    Long getConsecutive();

    Diary getDiaryByDate(String date);
    boolean checkToday();
    Diary viewDiary(String date);
    List<Diary> navigateDiary(String date);
    String cancelDiary();
    Diary submitDiary(String date);
    String cancelModal(String date);
    Diary submitModal(String date);
    String cancelView(String date);
}
