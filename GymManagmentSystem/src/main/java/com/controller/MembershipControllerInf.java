package com.controller;

import java.util.List;

import comm.model.Membership;

public interface MembershipControllerInf {
	
	public String addMembership(Membership membership);
	public String getMembershipById(int id);
	public List<Membership> getAllMember();
	public String updateMembership(Membership membership);
	public String deleteMembershipById(int id);
	

}
