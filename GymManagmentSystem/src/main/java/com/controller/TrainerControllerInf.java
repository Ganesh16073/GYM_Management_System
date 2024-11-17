package com.controller;

import java.util.List;

import comm.model.Trainer;

public interface TrainerControllerInf {

	public String addTraniner(Trainer trainer);
	public Trainer getTraninerById(int tid);
	public List<Trainer> getAllTrainer();
	public String updateTrainer(Trainer trainer);
	public String deleteTrainerById(int tid);

}