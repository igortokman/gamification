package com.example.gamification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
public enum  BadgeType {
	FIRST_WON("first won"),
	BRONZE("bronze"),
	LUCKY("lucky");

	private final String desc;
}
