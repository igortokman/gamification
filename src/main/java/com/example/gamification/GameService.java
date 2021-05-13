package com.example.gamification;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

public interface GameService {
	GameResult newAttemptForUser(ChallengeSolvedDTO challengeSolvedDTO);

	@Value
	class GameResult {
		int scores;
		List<BadgeType> badges;
	}
}
