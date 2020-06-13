package com.example.transaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcTransactionDemo {
	
	//1. 테이블 만들기
	//   CREATE TABLE BANK_ACCOUNT
	//   (
	//         ACCOUNT_OWNER VARCHAR(50) NOT NULL
	//       , BALANCE DOUBLE NOT NULL
	//   )
	
	//2. 테스트 수행 전 필수 작업 - SQL Developer에서 수행
	//
	//   BANK_ACCOUNT 테이블의 모든 데이터 삭제
	//   - DELETE FROM BANK_ACCOUNT;
	//   BANK_ACCOUNT 테이블에 두 건의 데이터 삽입
	//   - INSERT INTO BANK_ACCOUNT VALUES ('장동건', 1000)
	//   - INSERT INTO BANK_ACCOUNT VALUES ('고소영', 1000)

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
				"jdbc:mysql://211.197.18.246:3306/demoweb?serverTimezone=UTC", "devuser", "mariadb");

			conn.setAutoCommit(false); //executeUpdate 실행 후에 자동으로 commit 하지 마세요
			
			String sql = 
				"UPDATE BANK_ACCOUNT SET BALANCE = BALANCE + ? WHERE ACCOUNT_OWNER = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, -500);
			pstmt.setString(2, "장동건");
			pstmt.executeUpdate(); //출금
			//default : 자동 commit 실행
			
			//int x = 10 / 0; //예외 발생
			
			pstmt.setLong(1, 500);
			pstmt.setString(2, "고소영");
			pstmt.executeUpdate(); //입금
			//default : 자동 commit 실행		
			
			conn.commit(); //마지막 commit 또는 rollback 실행 후에 처리된 모든 명령을 commit			
			System.out.println("계좌 이체 성공");
			
		} catch (Exception ex) {
			
			try { conn.rollback(); } catch (Exception ex2) {} //마지막 commit 또는 rollback 실행 후에 처리된 모든 명령을 rollback
			System.out.println("계좌 이체 실패");
			
		} finally {
			try { conn.setAutoCommit(true); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}		

	}
	
	

}





