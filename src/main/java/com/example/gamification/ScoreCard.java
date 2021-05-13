package com.example.gamification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ScoreCard {
	private static final int DEFAULT_SCORE = 10;

	@Id
	@GeneratedValue
	private Long cardId;
	private Long userId;
	private Long attemptId;
	private int score;
	@EqualsAndHashCode.Exclude
	private long timestamp;

	public ScoreCard(Long userId, Long attemptId) {
		this(null, userId, attemptId, DEFAULT_SCORE, System.currentTimeMillis());
	}
}
