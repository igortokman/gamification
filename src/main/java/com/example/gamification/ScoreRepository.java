package com.example.gamification;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends CrudRepository<ScoreCard, Long> {
	List<ScoreCard> findByUserId(long userId);

//	@Query("select new com.example.gamification.LeaderBoardRow(sum(s.score), s.userId) " +
//			"from ScoreCard s " +
//			"group by s.userId")
	@Query("SELECT NEW  com.example.gamification.LeaderBoardRow(SUM(s.score), s.userId) " +
			"FROM ScoreCard s " +
			"GROUP BY s.userId ORDER BY SUM(s.score) DESC")
	List<LeaderBoardRow> findTop10();

	@Query("select sum(s.score) from ScoreCard s " +
			"where s.userId = :userId " +
			"group by s.userId")
	Optional<Integer> findTotalScoreByUserId(@Param("userId") long userId);

}
