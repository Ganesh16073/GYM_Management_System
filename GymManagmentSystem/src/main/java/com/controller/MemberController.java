package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.MemberService;

import comm.model.Member;

@Controller
public class MemberController implements MemberControllerInf{
	
	
	@Autowired
	MemberService ms;
	
	@Override
	public String addMember(Member member) {
		
		ms.addMember(member);
		return "New Member Added successfull";
	}

	@Override
	public Member getMemberById(int id) {
		
		Optional<Member> mbs=ms.findMemberById(id);
		if(mbs.isPresent())
		{
			return mbs.get();
		}
		else
		{
			System.out.println("Member Not Found");
			return null;
		}
	}

	@Override
	public List<Member> getAllMember() {
		
		List<Member> memList =  ms.getAllMember();
		
		return memList;
	}

	@Override
	public String updateMember(Member member) {
		Optional<Member> existingMember = ms.findMemberById(member.getMid());
	    if (existingMember.isPresent()) {
	        ms.updateMember(member); // Update the member if found
	        return "Member updated successfully";
	    } else {
	        return "Member not found";
	    }
	}

	
	@Override
	public String deleteMemberById(int id) {
		Optional<Member> mbs=ms.findMemberById(id);
		if(mbs.isPresent())
		{
			ms.deleteMemberById(id);
			return "Member deleted";
		}
		else
		{
			return "Member Not Found or Not Deleted";
		}
		
	}

}
