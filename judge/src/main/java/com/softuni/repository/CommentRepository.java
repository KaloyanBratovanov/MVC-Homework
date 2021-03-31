package com.softuni.repository;

import com.softuni.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


    @Query("SELECT c.author.username FROM Comment c " +
            "group by c.author.id " +
            "order by AVG(c.score) DESC ")
    List<String> findTopScore();


    @Query("SELECT AVG(c.score) FROM Comment c ")
    Double findAvgScore();
}
