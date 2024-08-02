package com.haru.service.impl;

import com.haru.entity.Diary;
import com.haru.repository.DiaryRepository;
import com.haru.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    @Override
    public Diary getStatusTF() {
        // TF status 로직 구현
        return null;
    }

    @Override
    public Long getConsecutive() {
        // 연속된 일자 count 로직 구현
        return null;
    }

    @Override
    public Diary getDiaryByDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        Optional<Diary> diary = diaryRepository.findByToday(localDate);
        return diary.orElse(null);
    }

    @Override
    public boolean checkToday() {
        LocalDate today = LocalDate.now();
        Optional<Diary> diary = diaryRepository.findByToday(today);
        return diary.isPresent();
    }

    @Override
    public Diary viewDiary(String date) {
        LocalDate localDate = LocalDate.parse(date);
        Optional<Diary> diary = diaryRepository.findByToday(localDate);
        return diary.orElse(null);
    }

    @Override
    public List<Diary> navigateDiary(String date) {
        // 슬라이드로 이전 / 다음 날짜 넘기기 로직 구현
        return null;
    }

    @Override
    public String cancelDiary() {
        // 작성 페이지에서 취소 로직 구현
        return "취소되었습니다.";
    }

    @Override
    public Diary submitDiary(String date) {
        LocalDate localDate = LocalDate.parse(date);
        Diary diary = new Diary();
        diary.setToday(localDate);
        // 추가적인 데이터 설정
        return diaryRepository.save(diary);
    }

    @Override
    public String cancelModal(String date) {
        // 모달에서 취소 로직 구현
        return "모달 취소되었습니다.";
    }

    @Override
    public Diary submitModal(String date) {
        LocalDate localDate = LocalDate.parse(date);
        Diary diary = new Diary();
        diary.setToday(localDate);
        // 추가적인 데이터 설정
        return diaryRepository.save(diary);
    }

    @Override
    public String cancelView(String date) {
        // 목록으로 돌아가기 로직 구현
        return "목록으로 돌아갑니다.";
    }
}
