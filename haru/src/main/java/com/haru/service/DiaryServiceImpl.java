package com.haru.service;

import com.haru.entity.Diary;
import com.haru.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    @Override
    public List<String> getStatusTF(int year, int month) {
        List<String> statusList = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());

        // 현재 연도와 월인 경우 오늘 날짜 이전까지만 출력
        if (year == today.getYear() && month == today.getMonthValue()) {
            lastDayOfMonth = today;
        }

        for (LocalDate date = firstDayOfMonth; !date.isAfter(lastDayOfMonth); date = date.plusDays(1)) {
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
        List<Diary> diaryList = diaryRepository.findAll(Sort.by(Sort.Order.desc("today")));
        long count = 0;
        LocalDate previousDay = LocalDate.now().minusDays(1);

        for (Diary diary : diaryList) {
            LocalDate diaryDate = diary.getToday(); // 날짜가 LocalDate 형식인지 확인
            if (diaryDate.equals(previousDay)) {
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
