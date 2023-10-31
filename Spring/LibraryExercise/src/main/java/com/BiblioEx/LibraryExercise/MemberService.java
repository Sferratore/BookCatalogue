package com.BiblioEx.LibraryExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

// MemberService is a Spring service class responsible for managing member-related operations.
@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    // Method to add a new member.
    public void addMember(Member member) {
        memberRepository.addMember(member);
    }

    // Method to retrieve a collection of all members.
    public Collection<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }

    // Method to find a member by their ID.
    public Member findMemberById(Long id) {
        return memberRepository.findMemberById(id);
    }

    // Method to update member details.
    public void updateMember(Member member) {
        memberRepository.updateMember(member);
    }

    // Method to remove a member by their ID.
    public void removeMember(Long id) {
        memberRepository.removeMember(id);
    }

    // Method to list active reservations for a member.
    public List<Reservation> listActiveReservationsForMember(Long memberId) {
        Member member = memberRepository.findMemberById(memberId);
        if (member != null) {
            return member.getReservations();
        }
        return null;
    }
}