package svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.*;
import vo.*;

public class SearchListSvc {
		public int getPdtCount(String where) {
		// �˻��� ��ǰ�� ��ü ������ �����ϴ� �޼ҵ�
			int rcnt = 0;	// ��ü ���ڵ� ������ ������ ����
			Connection conn = getConnection();
			PdtDao pdtDao = PdtDao.getInstance();
			pdtDao.setConnection(conn);
			rcnt = pdtDao.getPdtCount(where);
			close(conn);

			return rcnt;
		}
		public ArrayList<PdtInfo> getPdtSearchList(String where, int cpage, int psize) {
			ArrayList<PdtInfo> pdtSearchList = new ArrayList<PdtInfo>();
			// ��ǰ ����� ������ ArrayList��ü�� PdtInfo�� �ν��Ͻ��� ������
			Connection conn = getConnection();
			PdtDao pdtDao = PdtDao.getInstance();
			pdtDao.setConnection(conn);
			pdtSearchList = pdtDao.getPdtSearchList(where, cpage, psize);
			close(conn);

			return pdtSearchList;
		}
}
