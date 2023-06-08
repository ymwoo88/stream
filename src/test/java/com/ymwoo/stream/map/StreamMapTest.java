package com.ymwoo.stream.map;

import com.ymwoo.stream.model.SendMail;
import com.ymwoo.stream.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class StreamMapTest {

    @Test
    @DisplayName("email List<String> 목록으로 추출")
    void case1() {
        List<User> examUserList = User.getExamUserList();

        List<String> emailList = examUserList
                .stream()
                .map(User::getEmail) // getter user.getEmail()
                .toList();

        // 결과 출력
        emailList
                .forEach(user -> log.info(">>> emailList Info = {}", user));
    }

    @Test
    @DisplayName("다른 모델형태로 List<SendMail> 목록으로 추출")
    void case2() {
        List<User> examUserList = User.getExamUserList();

        List<SendMail> sendEmailList = examUserList.stream()
                .map(user -> {
                    log.info("email to address info : {}", user.getEmail());
                    return SendMail.valueOf("sender@ymwoo.com", user.getEmail());
                })
                .toList();

        // 결과 출력
        sendEmailList
                .forEach(user -> log.info(">>> sendEmailList Info = {}", user));
    }
}
