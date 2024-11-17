package com.controller;

import java.util.List;

import comm.model.Member;

public interface MemberControllerInf {
	public String addMember(Member member);
	public Member getMemberById(int id);
	public List<Member> getAllMember();
	public String updateMember(Member member);
	public String deleteMemberById(int id);
	

}
