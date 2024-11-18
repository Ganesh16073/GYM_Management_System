package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import comm.model.Trainer;

@Service
public class TrainerService implements TrainerServiceInf{

	private List<Trainer> tra=new ArrayList<>();
	
	@Override
    public void addTrainer(Trainer trainer) {
        try {
            tra.add(trainer);
            System.out.println("New Trainer Added => " + trainer);
        } catch (Exception e) {
            System.err.println("Error while adding trainer: " + e.getMessage());
        }
    }

	@Override
    public Optional<Trainer> findTrainerById(int id) {
        try {
            return tra.stream()
                    .filter(trainer -> trainer.getTid() == id)
                    .findFirst();

                    
        } catch (Exception e) {
            System.err.println("Error while finding trainer by ID: " + e.getMessage());
            return Optional.empty();
        } 
    }

	@Override
    public List<Trainer> getAllTrainer() {
        try {
            return new ArrayList<>(tra);
        } catch (Exception e) {
            System.err.println("Error while fetching all trainers: " + e.getMessage());
            return new ArrayList<>();
        }
    }

	@Override
	public void updateTrainer(Trainer trainer) {
		try
		{
			findTrainerById(trainer.getTid()).ifPresent(existingTrainer->
			{
				existingTrainer.setAge(trainer.getAge());
				existingTrainer.setAddress(trainer.getAddress());
				existingTrainer.setExperienceYear(trainer.getExperienceYear());
				existingTrainer.setGender(trainer.getGender());
				existingTrainer.setMobileNo(trainer.getMobileNo());
				existingTrainer.setName(trainer.getName());
				existingTrainer.setSalary(trainer.getSalary());
				System.out.println("Trainer Data Updated => "+existingTrainer);
	
			});
			
		}
		catch(Exception e)
		{
			System.err.println("Trainer with ID " + trainer.getTid() + " not found.");
			System.err.println("Error while updating trainer: " + e.getMessage());
		}
		
	}

    @Override
    public void deleteTrainerById(int id) {
        try {
            boolean removed = tra.removeIf(trainer -> trainer.getTid() == id);
            if (removed) {
                System.out.println("Trainer Deleted id => " + id);
            } else {
                System.err.println("Trainer with ID " + id + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Error while deleting trainer: " + e.getMessage());
        }
    }
}
