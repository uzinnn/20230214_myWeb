package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static kh.common.jdbc.JDBCTemplate.*;
import kh.member.model.vo.MemberVo;

public class MemberDao {
	
	//내정보보기
	public MemberVo myInfo(Connection conn,String id) {
		MemberVo result = null;
		
		String sql = "select ID, NAME, EMAIL from test_member ";
		sql += " where id=? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			//단일행 결과물
			if(rs.next()) {
				result = new MemberVo();
				result.setEmail(rs.getString("email")); //컬럼이 이메일인 문자열을 가져와서 membervo를 채워준다
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("result");	
		return result;
	}
	

	//로그인
	//return값은 자료값이 하나
	public MemberVo login(Connection conn,MemberVo vo) {
		MemberVo result = null;
		
	String sql = "select ID, NAME, EMAIL from test_member ";
		sql += " where id=? and PASSWD=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			rs = pstmt.executeQuery();
		//단일행 결과물
		if(rs.next()) {
				result = new MemberVo();
				result.setEmail(rs.getString("email"));
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		System.out.println(result);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	// 회원가입 - controller에 있는 데이터를 MemberDao로 가져와서 회원가입
	// dao에는 매게인자 Connection conn 넣어줌
	//insert문 -> int
	
	public int enroll(Connection conn, MemberVo vo) {
		int result = -1;
		String query = "insert into Test_Member values ";
		//vo에 작성한 데이터 순서 중요
		query += "(?,?,?,?)";
		
		PreparedStatement pstmt = null;
		//select문이면 resultset사용했겠지만 insert 이기때문에 resultset사용  x
		
		try {
			pstmt = conn.prepareStatement(query);
			// ?채워주기
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			// pstmt 실행
			// 결과값 result에 대입
			result  = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("DAO enroll() return :" + result);
		return result;
		
	}

}
