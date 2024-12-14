package com.library_mangmt_sys.LibraryDemo.controller;

import com.library_mangmt_sys.LibraryDemo.entity.Member;
import com.library_mangmt_sys.LibraryDemo.service.Memberservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/library")

public class MemberController {
    @Autowired
    public Memberservice memberservice;


    @PostMapping(path = "/addMember")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        Member addedMember = memberservice.addMember(member);
        return ResponseEntity.status(200).body(addedMember);
    }

    @GetMapping(path = "/getallmembers")
    public List<Member> getallmembers() {
        List<Member> allmembers = memberservice.getallmembers();
        return allmembers;
    }

    @DeleteMapping(path = "/deletemember/{memberid}")
    public String deletememberbyid(@PathVariable Long memberid) {
        Long l = memberservice.removeMember(memberid);
        System.out.println(l);
        return "Member Removed Succesfully" + memberid;
    }

    @PostMapping(path = "/borrowbook")
    public String borrowbook(@RequestParam Long memberid) {
        return memberservice.borrowbook(memberid);
    }

    @PostMapping(path = "/returnbook")
    public String returnbook(@RequestParam Long memberid) {
        return memberservice.returnbook(memberid);
    }

    @PutMapping(path = "/updateMember")
    public Member updateMember(@RequestBody Member member, @RequestParam Long id) {
        Member m = memberservice.updateMemberById(id, member);
        return m;
    }

}
