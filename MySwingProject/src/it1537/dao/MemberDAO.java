package it1537.dao;

import it1537.entities.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs1 = null;
	static PreparedStatement pstmt1 = null;

	
	// added in another comment to test conflict2
	public static Member register(Member member) {
		
		Statement stmt = null;
		
		// get the last member ID 
		try {
			
			currentCon = DBConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			String getMax = "select Max(member_id) from memberids";
			rs1 = stmt.executeQuery(getMax);
			rs1.next();
			int maxId = rs1.getInt(1);
			System.out.println(maxId);
			int nextId = maxId + 1;

			String query1 = "insert into memberids values(?)";
			pstmt1 = currentCon.prepareStatement(query1);
			pstmt1.setInt(1, nextId);
			pstmt1.executeUpdate();
			
			String memberId = "S" + Integer.toString(nextId);
			member.setMemberId(memberId);
            System.out.println("New Member ID = " + memberId);
            // query for inserting into the table
            String query = "insert into Member(member_id,name, tel,username,password) values(?,?,?,?,?)";
            pstmt = currentCon.prepareStatement(query);
            // inserting values
            pstmt.setString(1,member.getMemberId());
            pstmt.setString(2,member.getName());
            pstmt.setString(3, member.getTel());  
            pstmt.setString(4,member.getUsername());
            pstmt.setString(5, member.getPassword());
            pstmt.executeUpdate();
            
		} catch (Exception ex) {

			System.out.println("Registration failed: An Exception has occurred! "
					+ ex);
		}

		// exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
		return member;

	}
	
	public static Member searchByName(String name) {
		Member member = null;
		Statement stmt = null;
        String searchQuery = "select * from member where name ='"
                + name + "' ";

        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("member with the name = " + name + " does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more) {
                String memberId = rs.getString("member_id");
                String memberName = rs.getString("name");
                String memberTel = rs.getString("tel");
                String username = rs.getString("username");
                String password = rs.getString("password");
                member = new Member();
                member.setMemberId(memberId);
                member.setName(memberName);
                member.setTel(memberTel);
                member.setUsername(username);
                member.setPassword(password);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return  member;
	}
	
	public static Member searchByUsername(String uname) {
		Member member = null;
		Statement stmt = null;
        String searchQuery = "select * from member where username ='"
                + uname + "' ";

        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
              System.out.println("member with the username = " + uname + " does not exst");
            }

            // if user exists set the isValid variable to true
            else if (more) {
                String memberId = rs.getString("member_id");
                String memberName = rs.getString("name");
                String memberTel = rs.getString("tel");
                String username = rs.getString("username");
                String password = rs.getString("password");
                member = new Member();
                member.setMemberId(memberId);
                member.setName(memberName);
                member.setTel(memberTel);
                member.setUsername(username);
                member.setPassword(password);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return  member;
	}
	
	public static ArrayList<Member> retrieveAll() {
		Member member = null;
		Statement stmt = null;
        String searchQuery = "select * from member";
        ArrayList<Member> memberList = new ArrayList<Member>();
        try {
            // connect to DB
            currentCon = DBConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            while (rs.next()) {
            
                String memberId = rs.getString("member_id");
                String memberName = rs.getString("name");
                String memberTel = rs.getString("tel");
                String username = rs.getString("username");
                String password = rs.getString("password");
                member = new Member();
                member.setMemberId(memberId);
                member.setName(memberName);
                member.setTel(memberTel);
                member.setUsername(username);
                member.setPassword(password);
                memberList.add(member);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

		return  memberList;
	}
	
}


