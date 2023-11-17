package com.ms.user.services;

import com.ms.user.models.UserModel;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserProducer producer;

    @Transactional
    public UserModel save(UserModel userModel) {
        var dbUser = repository.save(userModel);
        producer.publishMessageEmail(userModel);
        return dbUser;
    }
}
