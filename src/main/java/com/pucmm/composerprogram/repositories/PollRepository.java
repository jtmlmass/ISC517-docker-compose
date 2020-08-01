package com.pucmm.composerprogram.repositories;

import com.pucmm.composerprogram.entities.Poll;
import com.pucmm.composerprogram.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Repository
@Transactional
public interface PollRepository extends JpaRepository<Poll, String> {
    public List<Poll> findByUser(User user);

    @Query(value="SELECT COUNT(answer1) FROM poll WHERE answer1 = ?1 GROUP BY answer1", nativeQuery = true)
    public Integer findValuesToAnswer1(int value);

    @Query(value="SELECT COUNT(answer2) FROM poll WHERE answer2 = ?1 GROUP BY answer2", nativeQuery = true)
    public Integer findValuesToAnswer2(int value);

    @Query(value="SELECT COUNT(answer3) FROM poll WHERE answer3 = ?1 GROUP BY answer3", nativeQuery = true)
    public Integer findValuesToAnswer3(int value);

    @Query(value="SELECT COUNT(answer4) FROM poll WHERE answer4 = ?1 GROUP BY answer4", nativeQuery = true)
    public Integer findValuesToAnswer4(int value);
}
