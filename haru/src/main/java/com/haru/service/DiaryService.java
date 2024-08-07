package com.haru.service;

import com.haru.entity.Diary;
import java.util.List;

public interface DiaryService {
    List<String> getStatusTF();
    Long getConsecutive();

    Diary getDiaryByDate(String date);
    boolean checkToday();
    List<Diary> navigateDiary(String date);

    Diary submitDiary(String date);
    Diary submitModal(String date);
}
