package com.example.service;


import com.example.config.DmsConsumer;
import com.example.dto.PurchaseDto;
import com.example.entity.BookSells;
import com.example.repository.SellsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
@RequiredArgsConstructor
public class SellService {
    @Autowired
    private SellsRepository sellsRepository;
    @Autowired
    private BookService bookService;

    private final static String BOOK_TOPIC = "book_buy_topic";


    private final DmsConsumer dmsConsumer;


    public void  createSellRequest(){

        dmsConsumer.consume(Arrays.asList(BOOK_TOPIC));
        try {
            for (int i = 0; i < 10; i++){
                ConsumerRecords<Object, Object> records = dmsConsumer.poll(10000);
                System.out.println("the numbers of topic:" + records.count());

                for (ConsumerRecord<Object, Object> record : records)
                {
                    PurchaseDto newPurshase= (PurchaseDto)record.value();
                    SellBook(newPurshase.getBookId(), newPurshase.getUserId(), 1);

                    System.out.println(record.toString());
                }
            }
        }catch (Exception e)
        {
            // TODO: Exception handling
            e.printStackTrace();
        }
    }

    public void SellBook(long bookId, long userId, int amount){
        BookSells bookSells =new BookSells();
        bookSells.setUserId(userId);
        bookSells.setAmount(amount);
        bookSells.setBookId(bookId);
        bookService.updateStock(bookId,amount);
        sellsRepository.save(bookSells);
        log.info("Kitap Satıldı");
    }

}
