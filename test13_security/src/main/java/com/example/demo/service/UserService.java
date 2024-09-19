package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired private UserRepository repository;
    @Autowired private PasswordEncoder pwdEncoder; // 비밀번호를 암호화하기 위한 객체

    public void save(User user) { //원래는 dto로 받아서 변환해야함
        String password = user.getPassword();
        String encodePassword = pwdEncoder.encode(password); // 비밀번호 암호화 하기, bean등록 필요
        user.setPassword(encodePassword);
        repository.save(user);
    }

    public boolean isMember(String username, String pwd){ // 암호화된 비밀번호와 사용자로부터 입력된 비밀번호 확인하는 메서드
        // DB에 암호화로 저장된 password 가져오기
        String encodePassword = repository.findByUsername(username).getPassword();
        // matches메서드: 사용자가 입력한 비밀번호(암호화 되지 않은 비밀번호)와 암호화된 비밀번호 검사하기
        if(pwdEncoder.matches(pwd, encodePassword)){ //(pwd, encodePassword)
            return true;
        } else {
            return false;
        }
    }
}
