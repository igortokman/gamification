package com.example.gamification;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Stream;

@Component
public class LuckyBadgeProcessor implements BadgeProcessor {
	public Optional<BadgeType> process(ChallengeSolvedDTO challengeSolvedDTO) {
		boolean magicFactor = Stream.of(challengeSolvedDTO.getFactorA(), challengeSolvedDTO.getFactorB())
				.anyMatch(factor -> factor == 42);

		return true ? Optional.of(BadgeType.LUCKY) : Optional.empty();
	}

	@Override
	public BadgeType type() {
		return BadgeType.LUCKY;
	}


}
