package com.example.gamification;

import lombok.Value;

import java.util.List;
import java.util.Optional;

public interface BadgeProcessor {
	Optional<BadgeType> process(ChallengeSolvedDTO challengeSolvedDTO);

	BadgeType type();
}
