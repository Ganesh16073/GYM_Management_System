package com.service;

import java.util.List;
import java.util.Optional;

import comm.model.Member;

public interface MemberServiceInf {
	public void addMember(Member member);
	public Optional<Member> findMemberById(int id);
	public List<Member> getAllMember();
	public void updateMember(Member member);
	public void deleteMemberById(int id);

}
