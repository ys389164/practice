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
        /*LocalDate localDate = LocalDate.parse(date);
        Optional<Diary> diary = diaryRepository.findByToday(localDate);
        return diary.orElse(null);*/
    }

    @Override
    public boolean checkToday() {
        return diaryRepository.findByToday(LocalDate.now()).isPresent();
        /*LocalDate today = LocalDate.now();
        Optional<Diary> diary = diaryRepository.findByToday(today);
        return diary.isPresent();*/
    }

    @Override
    public Diary viewDiary(String date) {
        return diaryRepository.findByToday(LocalDate.parse(date)).orElse(null);
        /*LocalDate localDate = LocalDate.parse(date);
        Optional<Diary> diary = diaryRepository.findByToday(localDate);
        return diary.orElse(null);*/
    }

    @Override
    public List<Diary> navigateDiary(String date) {
        LocalDate targetDate = LocalDate.parse(date);
        List<Diary> diaries = diaryRepository.findAll();
        return null;
    }

    @Override
    public String cancelDiary() {
        return "redirect:/api/diary";
    }

    @Override
    public Diary submitDiary(String date) {
        Diary diary = new Diary();
        diary.setToday(LocalDate.parse(date));
        diaryRepository.save(diary);
        return diary;
    }

    @Override
    public String cancelModal(String date) {
        return "stay";
    }

    @Override
    public Diary submitModal(String date) {
        Diary diary = new Diary();
        diary.setToday(LocalDate.parse(date));
        diaryRepository.save(diary);
        return diary;
    }

    @Override
    public String cancelView(String date) {
        return "redirect:/api/diary";
    }
}
