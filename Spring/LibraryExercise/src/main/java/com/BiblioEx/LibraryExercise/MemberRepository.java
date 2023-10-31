package com.BiblioEx.LibraryExercise;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

// MemberRepository is a Spring repository class responsible for managing member data.
@Repository
public class MemberRepository {
    private final Map<Long, Member> members = new HashMap<>();
    private Long currentId = 1L;

    // Method to add a new member to the repository.
    public void addMember(Member member) {
        member.setId(currentId++);
        members.put(member.getId(), member);
    }

    // Method to retrieve a collection of all members from the repository.
    public Collection<Member> getAllMembers() {
        return members.values();
    }

    // Method to retrieve a specific member by their ID from the repository.
    public Member findMemberById(Long id) {
        return members.get(id);
    }

    // Method to update an existing member in the repository.
    public void updateMember(Member member) {
        if (members.containsKey(member.getId())) {
            members.put(member.getId(), member);
        }
    }

    // Method to remove a member by their ID from the repository.
    public void removeMember(Long id) {
        members.remove(id);
    }
}