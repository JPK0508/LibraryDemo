package com.library_mangmt_sys.LibraryDemo.service;

import com.library_mangmt_sys.LibraryDemo.entity.Member;
import com.library_mangmt_sys.LibraryDemo.entity.Member;
import com.library_mangmt_sys.LibraryDemo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Memberservice {
    @Autowired
    public MemberRepository memberRepository;


    public Member addMember(Member members) {

        Optional<Member> memberById = getMemberById(members.getId());
        if (memberById.isPresent()) {
            throw new RuntimeException("Member Already Exist");

            //What is optional class:-
        } else {
            Member savedMember = memberRepository.save(members);
            return savedMember;
        }
    }

    public Optional<Member> getMemberById(Long id) {
        Optional<Member> byId = memberRepository.findById(id);
        return byId;

    }

    public List<Member> getallmembers() {
        List<Member> all = memberRepository.findAll();
        return all;
    }

    public Long removeMember(Long id) {
        Long memId = 0L;
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
        } else {
            throw new RuntimeException("Member Is Not Exist");
        }
        return memId;
    }

    public String borrowbook(Long id) {
        Optional<Member> member = memberRepository.findById(id);

        if (member.isEmpty()) {
            throw new RuntimeException("Member Is Already Borrowed");
        }
        if ((member.isPresent())) {
            throw new RuntimeException("Member Is Availablee");
        }
        Member member1 = member.get();
        member1.isBorrowed();
        memberRepository.save(member1);
        ;
        return "Member is successfully borrowed by Member";
    }

    public String returnbook(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isEmpty()) {
            throw new RuntimeException("  is Not Returned By Member");
        }
        Member mem = member.get();
        mem.isReturned();
        memberRepository.save(mem);
        return "Member Returned Book Successfully.";
    }

    public Member updateMemberById(Long id, Member member) {
        Optional<Member> optional = memberRepository.findById(id);

        if (optional.isPresent()) {
            Member existingMember = optional.get();
            existingMember.setId(member.getId());
            existingMember.setName(member.getName());
            existingMember.setAdress(member.getAdress());
            existingMember.setPhoneNumber(member.getPhoneNumber());

            return memberRepository.save(existingMember);
        } else {
            throw new RuntimeException("Member with id" + id + "Not found");

        }

    }
}