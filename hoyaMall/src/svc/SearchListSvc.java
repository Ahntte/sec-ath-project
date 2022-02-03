package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class SearchListSvc {
		public int getPdtCount(String where) {
		// 검색된 상품의 전체 개수를 리턴하는 메소드
			int rcnt = 0;	// 전체 레코드 개수를 저장할 변수
			Connection conn = getConnection();
			PdtDao pdtDao = PdtDao.getInstance();
			pdtDao.setConnection(conn);
			rcnt = pdtDao.getPdtCount(where);
			close(conn);

			return rcnt;
		}
		public ArrayList<PdtInfo> getPdtSearchList(String where, int cpage, int psize) {
			ArrayList<PdtInfo> pdtSearchList = new ArrayList<PdtInfo>();
			// 상품 목록을 저장할 ArrayList객체로 PdtInfo형 인스턴스만 저장함
			Connection conn = getConnection();
			PdtDao pdtDao = PdtDao.getInstance();
			pdtDao.setConnection(conn);
			pdtSearchList = pdtDao.getPdtSearchList(where, cpage, psize);
			close(conn);

			return pdtSearchList;
		}
}
