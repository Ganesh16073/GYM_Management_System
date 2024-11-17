package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.TrainerService;

import comm.model.Trainer;
@Controller
public class TrainerController implements TrainerControllerInf{

	@Autowired
	TrainerService ts;
	
	@Override
	public String addTraniner(Trainer trainer) {
		ts.addTrainer(trainer);
		return "New Trainer Added";
	}

	@Override
	public Trainer getTraninerById(int tid) {
		Optional<Trainer> ot=ts.findTrainerById(tid);
		if(ot.isPresent())
		{
			return ot.get();
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public List<Trainer> getAllTrainer() {
		
		return ts.getAllTrainer();
	}

	@Override
	public String updateTrainer(Trainer trainer) {
		Optional<Trainer> ot=ts.findTrainerById(trainer.getTid());
		if(ot.isPresent())
		{
			ts.updateTrainer(trainer);
			return "Trainer Updated Succesfull "+ot.get();
		}
		else
		{
			return "Trainer Not Found";
		}
		
	}

	@Override
	public String deleteTrainerById(int tid) {
		Optional<Trainer> ot=ts.findTrainerById(tid);
		if(ot.isPresent())
		{
			ts.deleteTrainerById(tid);
			return "Triner Deleted SuccessFull by id "+tid;
		}
		else
		{
			return "Trainer Not Found";
		}
			
	
	}

}
