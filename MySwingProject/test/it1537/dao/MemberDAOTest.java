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
		member.setName("Lim Ah Kok");
		member.setTel("91123333");
		MemberDAO.register(member);
		assertTrue(member.getMemberId()!=null);
		Member member2 = MemberDAO.searchByName("Lim Ah Kok");
		assertTrue(member2.getName().equals("Lim Ah Kok"));
		assertTrue(member2.getTel().equals("91123333"));
	}


	@Test
	public void testRetrieveAll() {
		List<Member> memberList =  MemberDAO.retrieveAll();
		for (Member member:memberList) {
			System.out.println(member.getMemberId() + "," + member.getName() + "," + member.getTel());
		}
	}
}
