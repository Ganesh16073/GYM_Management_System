package com.controller;

import java.util.List;

import comm.model.Membership;

public interface MembershipControllerInf {
	
	public String addMembership(Membership membership);
	public Membership getMembershipById(int id);
	public List<Membership> getAllMember(Membership membership);
	public String updateMembership(Membership membership);
	public String deleteMembershipById(Membership membership);
	

}
