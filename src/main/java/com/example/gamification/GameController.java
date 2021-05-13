package com.example.gamification;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attempts")
public class GameController {
	private final GameService gameService;

	@PostMapping
    @ResponseStatus(HttpStatus.OK)
    void postResults(@RequestBody ChallengeSolvedDTO solvedDTO) {
        gameService.newAttemptForUser(solvedDTO);
    }
}
