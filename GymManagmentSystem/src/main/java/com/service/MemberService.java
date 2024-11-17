package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import comm.model.Member;

@Service
public class MemberService implements MemberServiceInf {

	List<Member> mem=new ArrayList<Member>();
	
	@Override
	public void addMember(Member member) {
		mem.add(member);
		System.out.println(mem);
		System.out.println("New Member Added => "+member);
	}

	@Override
	public Optional<Member> findMemberById(int id) {
		
		return mem.stream().filter(member -> member.getMid()==id).findFirst();
	}

	@Override
	public List<Member> getAllMember() {
		
//		return new ArrayList<Member>(mem);
		
		return  mem;
	}

	@Override
	public void updateMember(Member member) {
		findMemberById(member.getMid()).ifPresent(existingMember -> {
            existingMember.setName(member.getName());
            existingMember.setMobileNo(member.getMobileNo());
            existingMember.setAge(member.getAge());
            existingMember.setMembershipType(member.getMembershipType());
            System.out.println("Updated member: " + existingMember);
        });
		
	}

	@Override
	public void deleteMemberById(int id) {
		mem.removeIf(member -> member.getMid()==id);
		System.out.println("Member Deleted with id "+id);
		
	}

}
