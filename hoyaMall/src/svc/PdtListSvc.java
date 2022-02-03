package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class PdtListSvc {
	public ArrayList<CataBigInfo> getCataBigList() {
		// 대분류 목록을 ArrayList 형 인스턴스로 리턴하는 메소드
			ArrayList<CataBigInfo> cataBigList = null;
			Connection conn = getConnection();
			PdtDao pdtDao = PdtDao.getInstance();
			pdtDao.setConnection(conn);
			cataBigList = pdtDao.getCataBigList();
			close(conn);
			return cataBigList;
		}

		public ArrayList<CataSmallInfo> getCataSmallList() {
		// 소분류 목록을 ArrayList 형 인스턴스로 리턴하는 메소드
			ArrayList<CataSmallInfo> cataSmallList = null;
			Connection conn = getConnection();
			PdtDao pdtDao = PdtDao.getInstance();
			pdtDao.setConnection(conn);
			cataSmallList = pdtDao.getCataSmallList();
			close(conn);
			return cataSmallList;
		}

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

		public ArrayList<PdtInfo> getPdtList(String where, String orderby, int cpage, int psize) {
			ArrayList<PdtInfo> pdtList = new ArrayList<PdtInfo>();
			// 상품 목록을 저장할 ArrayList객체로 PdtInfo형 인스턴스만 저장함(식물만)
			Connection conn = getConnection();
			PdtDao pdtDao = PdtDao.getInstance();
			pdtDao.setConnection(conn);
			pdtList = pdtDao.getPdtList(where, orderby, cpage, psize);
			close(conn);

			return pdtList;
		}
		
		public ArrayList<PdtInfo> getPdtPotList(String where, String orderby, int cpage, int psize) {
			ArrayList<PdtInfo> getPdtPotList = new ArrayList<PdtInfo>();
			// 상품 목록을 저장할 ArrayList객체로 PdtInfo형 인스턴스만 저장함 (화분만)
			Connection conn = getConnection();
			PdtDao pdtDao = PdtDao.getInstance();
			pdtDao.setConnection(conn);
			getPdtPotList = pdtDao.getPdtPotList(where, orderby, cpage, psize);
			close(conn);

			return getPdtPotList;
			
		}
		
		public ArrayList<PdtInfo> getPdtRankList(){
			ArrayList<PdtInfo> pdtRankedList = new ArrayList<PdtInfo>();
			// 상품 목록을 저장할 ArrayList객체로 PdtInfo형 인스턴스만 저장함
			Connection conn = getConnection();
			PdtDao pdtDao = PdtDao.getInstance();
			pdtDao.setConnection(conn);
			pdtRankedList = pdtDao.getPdtRankList();
			close(conn);
			System.out.println("랭킹svc");
			return pdtRankedList;
		}
		
		public ArrayList<PdtInfo> getMainBpdtList() {
			ArrayList<PdtInfo> pdtMainBpList = new ArrayList<PdtInfo>();
			// 상품 목록을 저장할 ArrayList객체로 PdtInfo형 인스턴스만 저장함
			Connection conn = getConnection();
			PdtDao pdtDao = PdtDao.getInstance();
			pdtDao.setConnection(conn);
			pdtMainBpList = pdtDao.getMainBpdtList();
			close(conn);
			System.out.println("메인랭킹svc");
			return pdtMainBpList;
		}
}
