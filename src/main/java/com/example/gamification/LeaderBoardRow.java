package com.example.gamification;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Value
@AllArgsConstructor
public class LeaderBoardRow {

	private Long totalScore;
	private Long userId;
	@With
	private List<String> badges;

	public LeaderBoardRow(long score, long id) {
		totalScore = score;
		userId = id;
		badges = new ArrayList<>();
	}
}
