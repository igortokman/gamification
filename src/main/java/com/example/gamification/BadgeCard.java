package com.example.gamification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BadgeCard {

	@Id
	@GeneratedValue
	private Long cardId;
	private Long userId;
	private BadgeType type;
	@EqualsAndHashCode.Exclude
	private long timestamp;

	public BadgeCard(Long userId, BadgeType type) {
		this(null, userId, type, System.currentTimeMillis());
	}
}
