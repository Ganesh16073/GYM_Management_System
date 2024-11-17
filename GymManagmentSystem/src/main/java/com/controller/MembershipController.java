package com.controller;

import java.util.List;

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
		return ms.addMembership(membership);
	}

	@Override
	public Membership getMembershipById(int id) {
		
		return null;
	}

	@Override
	public List<Membership> getAllMember(Membership membership) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateMembership(Membership membership) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMembershipById(Membership membership) {
		// TODO Auto-generated method stub
		return null;
	}

}
