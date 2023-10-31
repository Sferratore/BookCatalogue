package com.BiblioEx.LibraryExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

// MemberController is a Spring controller class responsible for handling HTTP requests related to members.
@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    // Handle HTTP GET requests to retrieve a list of members.
    @GetMapping
    public Collection<Member> listMembers() {
        return memberService.getAllMembers();
    }

    // Handle HTTP GET requests to retrieve member details by ID.
    @GetMapping("/{id}")
    public Member getMemberDetails(@PathVariable Long id) {
        return memberService.findMemberById(id);
    }

    // Handle HTTP POST requests to add a new member.
    @PostMapping
    public void addMember(@RequestBody Member member) {
        memberService.addMember(member);
    }

    // Handle HTTP PUT requests to update member details.
    @PutMapping("/{id}")
    public void updateMember(@RequestBody Member member) {
        memberService.updateMember(member);
    }

    // Handle HTTP DELETE requests to remove a member by ID.
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.removeMember(id);
    }

    // Handle HTTP GET requests to retrieve a list of active reservations for a member.
    @GetMapping("/{id}/active-reservations")
    public List<Reservation> listActiveReservationsForMember(@PathVariable Long id) {
        return memberService.listActiveReservationsForMember(id);
    }
}