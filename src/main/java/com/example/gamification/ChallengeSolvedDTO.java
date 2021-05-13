package com.example.gamification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ChallengeSolvedDTO {
	private Long userId;
	private Long attemptId;

	private int factorA;
	private int factorB;
	private boolean correct;
}
