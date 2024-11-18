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
	public Membership getMembershipById(int id) {
		
		Optional<Membership> m=ms.getMembershipById(id);
		if(m.isPresent())
		{
			return m.get();
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public List<Membership> getAllMember(Membership membership) {
	
		return ms.getAllMemberships();
	}

	@Override
	public String updateMembership(Membership membership) {

		return ms.updateMembership(membership);
	}

	@Override
	public String deleteMembershipById(Membership membership) {

		return ms.deleteMembership(0);
	}

}
