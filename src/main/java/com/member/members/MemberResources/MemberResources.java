package com.member.members.MemberResources;

import com.member.members.model.Member;
import com.member.members.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/members")
public class MemberResources {
    @Autowired
    private MemberService memberService;

    @GetMapping(value = "/{memberId}")
    public Member getMember (@PathVariable("memberId") int memberId){
        Member selectedCust = memberService.getMember(memberId);
        return selectedCust;
    }

    @GetMapping(value = "/update/{memberId}")
    public Member updateMember(@PathVariable("memberId") int memberId, @RequestBody Member member){
        return memberService.updateMemberDetails(memberId, member);
    }

    @PostMapping(value="/save")
    public Member saveCustomer(@RequestBody Member member){
        memberService.addMember(member);
        return member;
    }

    @GetMapping(value="/all")
    public List<Member> getAllMembers(Model model){
        return memberService.getAllMembers();
    }


}
