package com.example.maraton5.repository;

import com.example.maraton5.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository  extends JpaRepository<Question, Long> {

    Optional<Question> findById(Long id);


}
