package com.library_mangmt_sys.LibraryDemo.repository;

import com.library_mangmt_sys.LibraryDemo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

}

