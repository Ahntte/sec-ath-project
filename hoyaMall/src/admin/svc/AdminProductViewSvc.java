package admin.svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminProductViewSvc {
	public PdtInfo getPdtInfo(String id) {
		PdtInfo pdtInfo = null;	// ������ ��ǰ������ ���� �ν��Ͻ� ����
		Connection conn = getConnection();
		PdtDao pdtDao = PdtDao.getInstance();
		pdtDao.setConnection(conn);

		pdtInfo = pdtDao.getPdtInfo(id);	// ������ ��ǰ���� �ޱ�

		close(conn);
		return pdtInfo;
	}
}