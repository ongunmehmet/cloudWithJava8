package com.example.service;

import com.example.config.DmsProducer;
import com.example.dto.PurchaseDto;
import com.example.entity.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final static String BOOK_TOPIC = "book_buy_topic";

   private final DmsProducer<String , PurchaseDto> producer;

    private final UserRepository userRepository;
    @Autowired
    private ApplicationContext context;
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }
    public List<User> findAll() {
        List<User> users=userRepository.findAll();
        return  users;
    }

    public void buyBook(PurchaseDto purchaseDto) {
        producer.produce(BOOK_TOPIC,1, UUID.randomUUID().toString(),purchaseDto);

    }
}
