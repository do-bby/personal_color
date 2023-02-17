package com.example.demo.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Member;


public interface MemberRepository extends JpaRepository<Member, Integer> {
	Optional<Member> findByEmail(String email);
	public Member findByMnum(int mnum);
	public Member findByName(String name);
}
