package com.example.gamification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameServiceImpl implements GameService {
	private final BadgeRepository badgeRepository;
	private final ScoreRepository scoreRepository;
	private final List<BadgeProcessor> badgeProcessors;

	public GameResult newAttemptForUser(ChallengeSolvedDTO challengeSolvedDTO) {
		log.info("gamification service - solved challenge processing: {} ", challengeSolvedDTO);

		if (challengeSolvedDTO.isCorrect()) {
			ScoreCard scoreCard = new ScoreCard(challengeSolvedDTO.getUserId(), challengeSolvedDTO.getAttemptId());
			scoreRepository.save(scoreCard);

			List<BadgeCard> badgeCards = badgeRepository.findByUserId(challengeSolvedDTO.getUserId());
			List<BadgeCard> newBadges = badgeProcessors.stream()
					.filter(badgeProcessor -> !badgeCards.contains(badgeProcessor.type()))
					.map(processor -> processor.process(challengeSolvedDTO))
					.filter(Optional::isPresent)
					.map(badgeType -> new BadgeCard(challengeSolvedDTO.getUserId(), badgeType.get()))
					.collect(Collectors.toList());

			badgeRepository.saveAll(newBadges);

			List<BadgeType> badgeTypes = newBadges.stream().map(BadgeCard::getType).collect(Collectors.toList());
			return new GameResult(scoreCard.getScore(), badgeTypes);
		} else {
			return new GameResult(0, new ArrayList<>());
		}
	}
}
