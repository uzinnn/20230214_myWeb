package kh.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kh.board.model.vo.BoardVo;
import static kh.common.jdbc.JDBCTemplate.*;

public class BoardDao {

	public List<BoardVo> getBoardList(Connection conn){
		List<BoardVo> result = null; 
		String sql = "select BOARD_NUM ,BOARD_TITLE ,BOARD_WRITER ,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAME_FILENAME          \r\n"
				+ ",BOARD_DATE  ,BOARD_LEVEL  ,BOARD_REF  ,BOARD_REPLY_SEQ ,BOARD_READCOUNT \r\n"
				+ "from board"
				+ "order by board_ref desc, board_reply_seq asc";
				//""안에는 ; 없애고 \r\n도 없애기
				
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//다중행
			result = new ArrayList<BoardVo>();
			while(rs.next()) {
				System.out.println("read");
				BoardVo vo = new BoardVo();
				vo.setBoardContent(rs.getString("board_Content"));
				vo.setBoardDate(rs.getDate("board_Date"));
				vo.setBoardLevel(rs.getInt("board_Level"));
				vo.setBoardNum(rs.getInt("board_Num"));
				vo.setBoardOriginalFilename(rs.getString("board_Original_Filename"));
				vo.setBoardReadcount(rs.getInt("board_Readcount"));
				vo.setBoardRef(rs.getInt("board_Ref"));
				vo.setBoardTitle(rs.getString("board_Title"));
				vo.setBoardWriter(rs.getString("board_Writer"));
				vo.setBoardRenameFilename(rs.getString("board_Rename_Filename"));
				
				result.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}
}
