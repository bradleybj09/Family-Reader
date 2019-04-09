package com.techelevator.model;

import java.time.LocalDate;

public class Goal {
	
	private long goalId;
	private String nameOfGoal;
	private LocalDate startDate;
	private int numberOfDays;
	private String description;
	private int minutesToReachGoal;
	
	
	public long getGoalId() {
		return goalId;
	}
	public void setGoalId(long goalId) {
		this.goalId = goalId;
	}
	public String getNameOfGoal() {
		return nameOfGoal;
	}
	public void setNameOfGoal(String nameOfGoal) {
		this.nameOfGoal = nameOfGoal;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMinutesToReachGoal() {
		return minutesToReachGoal;
	}
	public void setMinutesToReachGoal(int minutesToReachGoal) {
		this.minutesToReachGoal = minutesToReachGoal;
	}
	
	

}