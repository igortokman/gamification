package com.example.gamification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaderBoardServiceImpl implements LeaderBoardService {
	private final ScoreRepository scoreRepository;

	@Override
	public List<LeaderBoardRow> getCurrentLeaderBoard() {
		return scoreRepository.findTop10();
	}
}
