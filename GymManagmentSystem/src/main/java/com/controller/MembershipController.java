package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.MembershipService;

import comm.model.Membership;

@Controller
public class MembershipController implements MembershipControllerInf{
	@Autowired
	MembershipService ms;

	@Override
	public String addMembership(Membership membership) {
		ms.addMembership(membership);
		return "New Membership added" ;
	}

	@Override
	public String getMembershipById(int id) {
		
		Optional<Membership> m=ms.getMembershipById(id);
		if(m.isPresent())
		{
			return "Membership found is =>> "+m.get();
		}
		else
		{
			return "Membership Not Found";
		}
		
	}

	@Override
	public List<Membership> getAllMember() {
	
		return ms.getAllMemberships();
	}

	@Override
	public String updateMembership(Membership membership) {

		return ms.updateMembership(membership);
	}

	@Override
	public String deleteMembershipById(int id) {

		return ms.deleteMembership(id);
	}

}
