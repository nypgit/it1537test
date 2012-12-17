package it1537.dao;

import static org.junit.Assert.assertTrue;
import it1537.entities.Member;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MemberDAOTest {

	@Test
	public void testRegister() {
		Member member = new Member();
		member.setName("user3");
		member.setTel("91123333");
		member.setUsername("user3");
		member.setPassword("password3");
		MemberDAO.register(member);
		assertTrue(member.getMemberId()!=null);
		Member member2 = MemberDAO.searchByName("user3");
		assertTrue(member2.getName().equals("user3"));
		assertTrue(member2.getTel().equals("91123333"));
		assertTrue(member2.getUsername().equals("user3"));
		assertTrue(member2.getPassword().equals("password3"));
	}


	@Test
	public void testRetrieveAll() {
		List<Member> memberList =  MemberDAO.retrieveAll();
		for (Member member:memberList) {
			System.out.println(member.getMemberId() + "," + member.getName() + "," + member.getTel());
		}
	}
	
	@Test
	public void testRetrieveByUsername() {
		String uname = "user3";
		Member member = MemberDAO.searchByUsername(uname);
		assertTrue(member.getName().equals("user3"));
		
	}

	@Test
	public void testBulkRegister() {

		Member member = new Member();

		for (int i = 4; i < 20; i++) {
			member.setName("user" + i);
			member.setTel("91123333");
			member.setUsername("user" + i);
			member.setPassword("pass" + i);
			MemberDAO.register(member);
			assertTrue(member.getMemberId() != null);
		}
	}

}
