package com.ymwoo.stream.distinct;

import com.ymwoo.stream.model.SendMail;
import com.ymwoo.stream.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class StreamDistinctTest {

    @Test
    @DisplayName("유저목록에서 취미목록을 추출 후 중복제거")
    void case1() {
        List<User> examUserList = User.getExamUserList();

        // 유저들의 취미를 뽑는다. (중복제거 X)
        List<String> nonDistinctHobbies = examUserList
                .stream()
                .map(User::getHobbies)
                .flatMap(Collection::stream)
                .toList();
        nonDistinctHobbies.forEach(s -> log.info("[nonDistinctHobbies] Hobbies info : {}", s));

        // 유저들의 취미를 뽑고 중복제거 한다.
        List<String> distinctHobbies = examUserList
                .stream()
                .map(User::getHobbies)
                .flatMap(Collection::stream)
                .distinct()
                .sorted()
                .toList();
        distinctHobbies.forEach(s -> log.info("[distinctHobbies] Hobbies info : {}", s));
    }

    @Test
    @DisplayName("객체 기준으로 중복제거")
    void case2() {
        SendMail example = SendMail.valueOf("sender@ymwoo.com", "to@ymwoo.com");
        List<SendMail> sendMailList = List.of(
                example,
                example,
                SendMail.valueOf("sender@ymwoo.com", "to111@ymwoo.com"),
                SendMail.valueOf("sender@ymwoo.com", "to222@ymwoo.com"),
                SendMail.valueOf("sender@ymwoo.com", "to222@ymwoo.com")
        );

        List<SendMail> distinctSendMail = sendMailList
                .stream()
                .distinct()
                .toList();

        // 결과
        distinctSendMail.forEach(sendMail -> {
            log.info("sendMail : {}", sendMail);
        });
    }

    @Test
    @DisplayName("객체 특정조건 기준으로 중복제거")
    void case3() {
        List<User> examUserList = User.getExamUserList()
                .stream()
                .sorted(Comparator.comparing(User::getAge))
                .toList();

        List<User> distinctUserList = examUserList
                .stream()
                .distinct()
                .toList();

        // 결과
        distinctUserList.forEach(user -> {
            log.info("user : {}", user);
        });
    }
}
