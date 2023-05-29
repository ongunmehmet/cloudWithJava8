package com.example.repository;


import com.example.entity.BookSells;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellsRepository extends JpaRepository<BookSells,Long> {
}
