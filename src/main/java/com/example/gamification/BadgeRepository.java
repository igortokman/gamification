package com.example.gamification;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BadgeRepository extends CrudRepository<BadgeCard, Long> {
	List<BadgeCard> findByUserId(long userId);
}
