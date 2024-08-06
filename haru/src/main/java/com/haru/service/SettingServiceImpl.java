package com.haru.service;

import com.haru.entity.Faq;
import com.haru.entity.Notice;
import com.haru.entity.User;
import com.haru.repository.FaqRepository;
import com.haru.repository.NoticeRepository;
import com.haru.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SettingServiceImpl implements SettingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private FaqRepository faqRepository;

    @GetMapping("/settings")
    public String getSetting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof OAuth2User user) {
            String nick = user.getAttribute("name");
            String email = user.getAttribute("email");
            return nick + " - " + email;
        }
        return "Guest - Random Code : " + Math.random();
    }

    @Override
    public boolean setNickname(String nickname) {
        Optional<User> user = userRepository.findById(1);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setNick(nickname);
            userRepository.save(existingUser);
            return true;
        }
        return false;
    }

    @Override
    public boolean setEmail(String email) {
        Optional<User> user = userRepository.findById(1);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setEmail(email);
            userRepository.save(existingUser);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteData() {
        return true;
    }

    @Override
    public boolean logout() {
        //        로그인 시, 뜨는 버튼 '계정관리'
//        계정관리 창 내부 버튼 '로그아웃' 클릭
//        로그아웃, 데이터 삭제 X
        return false;
    }

    @Override
    public boolean withdrawal() {
        Optional<User> user = userRepository.findById(1);
        return false;
    }

    @Override
    public boolean backup() {
        //        로그인을 해야한 사용할 수 있는 기능
//        백업 google Drive 사용
        return false;
    }

    @Override
    public boolean restore() {
        //        로그인을 해야만 사용할 수 있는 기능
//        복구 google Drive 사용, 이전의 데이터는 다 삭제시키기
//          모달 띄우기
        return false;
    }

    @Override
    public List<Object> export(String type) {
        /*byte[] data = settingService.export(type);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("export.txt").build());
        headers.setContentType(MediaType.TEXT_PLAIN);
//        위의 3가지를 묶어서 해도 되는거고?
        return new ResponseEntity<>(data, headers, HttpStatus.OK);*/
        return List.of();
    }

    @Override
    public List<Faq> faq(String category) {
        return switch (category) {
            case "계정" -> faqRepository.findByCategory(1);
            case "메모" -> faqRepository.findByCategory(2);
            case "일기" -> faqRepository.findByCategory(3);
            case "기타" -> faqRepository.findByCategory(4);
            default -> faqRepository.findAll();
        };
    }

    @Override
    public List<Notice> notice() {
        return noticeRepository.findAll();
    }
}
