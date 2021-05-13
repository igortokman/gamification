package com.example.gamification;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/leaders")
public class LeaderBoardController {
	private final LeaderBoardService boardService;

	@GetMapping
    List<LeaderBoardRow> postResults(@RequestBody ChallengeSolvedDTO solvedDTO) {
        return boardService.getCurrentLeaderBoard();
    }
}
