package com.service;

import java.util.List;
import java.util.Optional;

import comm.model.Trainer;

public interface TrainerServiceInf {

	public void addTrainer(Trainer trainer);
	public Optional<Trainer> findTrainerById(int id);
	public List<Trainer> getAllTrainer();
	public void updateTrainer(Trainer trainer);
	public void deleteTrainerById(int id);
}
