package com.haru.service;

import com.haru.entity.Diary;
import com.haru.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    @Override
    public List<String> getStatusTF() {
        List<String> statusList = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);

        for (LocalDate date = firstDayOfMonth; !date.isAfter(today); date = date.plusDays(1)) {
            if (diaryRepository.findByToday(date).isPresent()) {
                statusList.add("T");
            } else {
                statusList.add("F");
            }
        }
        return statusList;
    }

    @Override
    public Long getConsecutive() {
        List<Diary> diaryList = diaryRepository.findAll();
        long count = 0;
        LocalDate previousDay = LocalDate.now().minusDays(1);
        for(Diary diary : diaryList){
            if(diary.getToday().isEqual(previousDay)){
                count++;
                previousDay = previousDay.minusDays(1);
            } else {
                break;
            }
        }
        return count;
    }

    @Override
    public Diary getDiaryByDate(String date) {
        return diaryRepository.findByToday(LocalDate.parse(date)).orElse(null);
    }

    @Override
    public boolean checkToday() {
        return diaryRepository.findByToday(LocalDate.now()).isPresent();
    }


    //    조회 페이지

    @Override
    public List<Diary> navigateDiary(String date) {
        LocalDate currentDate = LocalDate.parse(date);
        List<Diary> diaries = new ArrayList<>();

        diaryRepository.findPreviousDiary(currentDate).ifPresent(diaries::add);
        diaryRepository.findNextDiary(currentDate).ifPresent(diaries::add);

        return diaries;
    }

    @Override
    public Diary submitDiary(String date) {
        Diary diary = new Diary();
        diary.setToday(LocalDate.parse(date));
        diaryRepository.save(diary);
        return diary;
    }

    @Override
    public Diary submitModal(String date) {
        Diary diary = new Diary();
        diary.setToday(LocalDate.parse(date));
        diaryRepository.save(diary);
        return diary;
    }

}
