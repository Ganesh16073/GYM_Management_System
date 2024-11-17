package com.service;

import java.util.List;
import java.util.Optional;

import comm.model.Membership;

public interface MembershipServiceInf {

	public String addMembership(Membership membership);
	public Optional<Membership> getMembershipById(int id);
	public List<Membership> getAllMemberships() ;
	public String updateMembership(Membership membership);
	public String deleteMembership(int id);
}
