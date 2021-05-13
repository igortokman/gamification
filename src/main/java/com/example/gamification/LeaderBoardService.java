package com.example.gamification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.With;

import java.util.List;


public interface LeaderBoardService {
	List<LeaderBoardRow> getCurrentLeaderBoard();
}
