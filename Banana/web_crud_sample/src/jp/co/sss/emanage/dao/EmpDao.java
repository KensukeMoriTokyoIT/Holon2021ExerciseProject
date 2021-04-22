package jp.co.sss.emanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.emanage.bean.EmpBean;

/**
 * 社員テーブル用DAO
 *
 * @author System Shared
 *
 */
public class EmpDao {

    /** 社員IDとパスワードによるemployeeの検索SQL */
    private static final String EMP_FIND_BY_ID_PASS = "SELECT emp_id,emp_name,authority FROM employee  WHERE emp_id = ? AND emp_pass = ?";
    /** 社員IDによるemployeeの検索SQL */
    private static final String EMP_FIND_BY_ID = "SELECT emp_id,emp_pass,emp_name,gender,address,TO_CHAR(birthday, 'YYYY\"年\"MM\"月\"DD\"日\"') birthday,authority,e.dept_id,dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id WHERE e.emp_id = ?";
    /** 社員名によるemployeeの部分検索SQL */
    private static final String EMP_FIND_BY_NAME_CONTAINS = "SELECT emp_id,emp_pass,emp_name,gender,address,TO_CHAR(birthday, 'YYYY\"年\"MM\"月\"DD\"日\"') birthday,authority,e.dept_id,dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id WHERE e.emp_name LIKE ? ORDER BY e.emp_id";
    /** 部署IDによるemployeeの検索SQL */
    private static final String EMP_FIND_BY_DEPT_ID = "SELECT emp_id,emp_pass,emp_name,gender,address,TO_CHAR(birthday, 'YYYY\"年\"MM\"月\"DD\"日\"') birthday,authority,e.dept_id,dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id WHERE e.dept_id = ? ORDER BY e.emp_id";
    /** employeeの検索SQL */
    private static final String EMP_FIND_ALL = "SELECT emp_id,emp_pass,emp_name,gender,address,TO_CHAR(birthday, 'YYYY\"年\"MM\"月\"DD\"日\"') birthday,authority,dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id ORDER BY e.emp_id";

    /** 社員IDによるemployee(社員ID、社員名、部署名のみ)の検索SQL */
    private static final String EMP_FIND_BY_ID_LIMITED_EMP_IMFO = "SELECT emp_id,emp_name,dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id WHERE e.emp_id = ?";
    /** 社員名によるemployee(社員ID、社員名、部署名のみ)の部分検索SQL */
    private static final String EMP_FIND_BY_NAME_CONTAINS_LIMITED_EMP_IMFO = "SELECT emp_id,emp_name,dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id WHERE e.emp_name LIKE ? ORDER BY e.emp_id";
    /** 部署IDによるemployee(社員ID、社員名、部署名のみ)の検索SQL */
    private static final String EMP_FIND_BY_DEPT_ID_LIMITED_EMP_IMFO = "SELECT emp_id,emp_name,dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id WHERE e.dept_id = ? ORDER BY e.emp_id";
    /** employee(社員ID、社員名、部署名のみ)の検索SQL */
    private static final String EMP_FIND_LIMITED_EMP_IMFO = "SELECT emp_id,emp_name,dept_name FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id ORDER BY e.emp_id";
    /** employee(部署ID、部署名、所属人数)の検索SQL */
    private static final String EMP_FIND_BY_DEPT = "select department.dept_id,dept_name, count(employee.dept_id) affiliation from employee right outer join department on employee.dept_id = department.dept_id group by department.dept_id,dept_name order by department.dept_id asc";
    /** employee(部署関連、部署IDの検索SQL */
    private static final String EMP_FIND_BY_DEPT_DEPT_ID = "select department.dept_id,dept_name, count(employee.dept_id) affiliation from employee right outer join department on employee.dept_id = department.dept_id where department.dept_id = ? group by department.dept_id,dept_name order by department.dept_id asc";
    /** employee(部署関連、部署名の検索SQL */
    private static final String EMP_FIND_BY_DEPT_DEPT_Name = "select department.dept_id,dept_name, count(employee.dept_id) affiliation from employee right outer join department on employee.dept_id = department.dept_id where department.dept_name LIKE ? group by department.dept_id,dept_name order by department.dept_id asc";

    /** 自作したSQL文 */
    /** 社員IDによるemployeeの削除SQL */
    private static final String EMP_DELETE_BY_ID = "delete from employee where emp_id = ?";
    /** 社員新規登録のSQL*/
    private static final String EMP_INSERT_NEWBIE = "insert into employee values(seq_emp.nextval,?,?,?,?,?,?,?)";
    /** 社員のパスワード変更のSQL*/
    private static final String EMP_UPDATE_PASSWORD = "update employee set emp_Pass = ? where emp_Id = ?";
    /** 社員のプロフィール変更のSQL*/
    private static final String EMP_UPDATE_PROFILE = "update employee set emp_Pass = ?, emp_Name = ?, gender = ?, address = ?, birthday = ?, authority = ?, dept_id = ?  where emp_Id = ?";


    /**
     * 社員IDによる1件検索メソッド
     *
     * @param empId
     *            社員ID
     * @return 社員テーブルのbean
     */
    public static EmpBean findById(String empId) {

        // 接続準備
        Connection con = null;
        PreparedStatement ps = null;
        EmpBean empBean = null;

        try {
            // DBに接続
            con = DBManager.getConnection();

            // SQL文を準備
            ps = con.prepareStatement(EMP_FIND_BY_ID);

            // 社員IDを検索条件に設定
            ps.setString(1, empId);

            // SQL文を実行
            ResultSet rs = ps.executeQuery();

            // 検索結果をbeanに格納する
            if (rs.next()) {
                empBean = new EmpBean();
                empBean.setEmpId(rs.getString("emp_id"));
                empBean.setEmpPass(rs.getString("emp_pass"));
                empBean.setEmpName(rs.getString("emp_name"));
                empBean.setGender(rs.getString("gender"));
                empBean.setAddress(rs.getString("address"));
                empBean.setBirthday(rs.getString("birthday"));
                empBean.setAuthority(rs.getString("authority"));
                empBean.setDeptId(rs.getString("dept_id"));
                empBean.setDeptName(rs.getString("dept_name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // DB切断処理
            DBManager.close(ps, con);
        }
        return empBean;
    }

    /**
     * 社員名による複数件検索メソッド
     *
     * @param empName
     *            社員名
     * @return 社員テーブルのリスト
     */
    public static List<EmpBean> findByNameContains(String empName) {

        Connection con = null;
        PreparedStatement ps = null;

        // 全件を格納するリストを準備しておく
        List<EmpBean> empList = new ArrayList<EmpBean>();

        try {
            con = DBManager.getConnection();

            ps = con.prepareStatement(EMP_FIND_BY_NAME_CONTAINS);

            StringBuilder sb = new StringBuilder();
            sb.append("%");
            sb.append(empName);
            sb.append("%");
            ps.setString(1, sb.toString());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EmpBean empBean = new EmpBean();

                empBean.setEmpId(rs.getString("emp_id"));
                empBean.setEmpPass(rs.getString("emp_pass"));
                empBean.setEmpName(rs.getString("emp_name"));
                empBean.setGender(rs.getString("gender"));
                empBean.setAddress(rs.getString("address"));
                empBean.setBirthday(rs.getString("birthday"));
                empBean.setAuthority(rs.getString("authority"));
                empBean.setDeptId(rs.getString("dept_id"));
                empBean.setDeptName(rs.getString("dept_name"));

                empList.add(empBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // DB切断処理
            DBManager.close(ps, con);
        }
        return empList;
    }

    /**
     * 部署IDによる1件検索メソッド
     *
     * @param deptId
     *            社員ID
     * @return 社員テーブルのリスト
     */
    public static List<EmpBean> findByDeptId(String deptId) {

        // 接続準備
        Connection con = null;
        PreparedStatement ps = null;

        // 全件を格納するリストを準備しておく
        List<EmpBean> empList = new ArrayList<EmpBean>();

        try {
            // DBに接続
            con = DBManager.getConnection();

            // SQL文を準備
            ps = con.prepareStatement(EMP_FIND_BY_DEPT_ID);

            // 社員IDを検索条件に設定
            ps.setString(1, deptId);

            // SQL文を実行
            ResultSet rs = ps.executeQuery();

            // 検索結果をbeanに格納する
            while (rs.next()) {
                EmpBean empBean = new EmpBean();
                empBean.setEmpId(rs.getString("emp_id"));
                empBean.setEmpPass(rs.getString("emp_pass"));
                empBean.setEmpName(rs.getString("emp_name"));
                empBean.setGender(rs.getString("gender"));
                empBean.setAddress(rs.getString("address"));
                empBean.setBirthday(rs.getString("birthday"));
                empBean.setAuthority(rs.getString("authority"));
                empBean.setDeptId(rs.getString("dept_id"));
                empBean.setDeptName(rs.getString("dept_name"));

                empList.add(empBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // DB切断処理
            DBManager.close(ps, con);
        }
        return empList;
    }

    /**
     * 社員IDとパスワードによる1件検索メソッド
     *
     * @param empId
     *            社員ID
     * @param empPass
     *            パスワード
     * @return 社員テーブルのbean
     */
    public static EmpBean findByIdPass(String empId, String empPass) {
        Connection con = null;
        PreparedStatement ps = null;
        EmpBean empBean = null;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(EMP_FIND_BY_ID_PASS);

            // 社員IDを検索条件に設定
            ps.setString(1, empId);

            // パスワードを検索条件に設定
            ps.setString(2, empPass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                empBean = new EmpBean();
                empBean.setEmpId(rs.getString("emp_id"));
                empBean.setEmpName(rs.getString("emp_name"));
                empBean.setAuthority(rs.getString("authority"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return empBean;
    }

    /**
     * 社員テーブル全件検索メソッド
     *
     * @return 社員テーブル全件のリスト
     */
    public static List<EmpBean> findAll() {

        Connection con = null;
        PreparedStatement ps = null;

        // 全件を格納するリストを準備しておく
        List<EmpBean> empList = new ArrayList<EmpBean>();

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(EMP_FIND_ALL);
            ResultSet rs = ps.executeQuery();

            // 検索結果をbeanに格納し、そのbeanをリストに詰める
            while (rs.next()) {
                EmpBean empBean = new EmpBean();
                empBean.setEmpId(rs.getString("emp_id"));
                empBean.setEmpPass(rs.getString("emp_pass"));
                empBean.setEmpName(rs.getString("emp_name"));
                empBean.setGender(rs.getString("gender"));
                empBean.setAddress(rs.getString("address"));
                empBean.setBirthday(rs.getString("birthday"));
                empBean.setAuthority(rs.getString("authority"));
                empBean.setDeptName(rs.getString("dept_name"));
                empList.add(empBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return empList;
    }

    /**
     * 社員テーブル全件(※社員ID、社員名、部署名のみ)検索メソッド
     *
     * @return 社員テーブル全件(※社員ID、社員名、部署名のみ)のリスト
     */
    public static List<EmpBean> findLimitedEmpInfo() {
        Connection con = null;
        PreparedStatement ps = null;
        List<EmpBean> empList = new ArrayList<EmpBean>();
        try {
            con = DBManager.getConnection();

            // 抽出項目を社員ID、社員名、部署名のみに絞ったSQL文を準備
            ps = con.prepareStatement(EMP_FIND_LIMITED_EMP_IMFO);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EmpBean empBean = new EmpBean();
                empBean.setEmpId(rs.getString("emp_id"));
                empBean.setEmpName(rs.getString("emp_name"));
                empBean.setDeptName(rs.getString("dept_name"));
                empList.add(empBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return empList;
    }

    /**
     * 社員IDによる社員テーブル(※社員ID、社員名、部署名のみ)検索メソッド
     *
     * @return 社員テーブル1件(※社員ID、社員名、部署名のみ)のbean
     */
    public static EmpBean findLimitedEmpInfoById(String empId) {
        Connection con = null;
        PreparedStatement ps = null;
        EmpBean empBean = null;
        try {
            con = DBManager.getConnection();

            // 抽出項目を社員ID、社員名、部署名のみに絞ったSQL文を準備
            ps = con.prepareStatement(EMP_FIND_BY_ID_LIMITED_EMP_IMFO);

            // 社員IDを検索条件に設定
            ps.setString(1, empId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                empBean = new EmpBean();
                empBean.setEmpId(rs.getString("emp_id"));
                empBean.setEmpName(rs.getString("emp_name"));
                empBean.setDeptName(rs.getString("dept_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return empBean;
    }

    /**
     * 社員名による社員テーブル全件(※社員ID、社員名、部署名のみ)あいまい検索メソッド
     *
     * @return 社員テーブル全件(※社員ID、社員名、部署名のみ)のリスト
     */
    public static List<EmpBean> findLimitedEmpInfoByNameContains(String empName) {
        Connection con = null;
        PreparedStatement ps = null;
        List<EmpBean> empList = new ArrayList<EmpBean>();
        try {
            con = DBManager.getConnection();

            // 抽出項目を社員ID、社員名、部署名のみに絞ったSQL文を準備
            ps = con.prepareStatement(EMP_FIND_BY_NAME_CONTAINS_LIMITED_EMP_IMFO);

            // 社員IDを検索条件に設定
            StringBuilder sb = new StringBuilder();
            sb.append("%");
            sb.append(empName);
            sb.append("%");
            ps.setString(1, sb.toString());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EmpBean empBean = new EmpBean();
                empBean.setEmpId(rs.getString("emp_id"));
                empBean.setEmpName(rs.getString("emp_name"));
                empBean.setDeptName(rs.getString("dept_name"));
                empList.add(empBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return empList;
    }

    /**
     * 部署IDによる社員テーブル全件(※社員ID、社員名、部署名のみ)検索メソッド
     *
     * @return 社員テーブル全件(※社員ID、社員名、部署名のみ)のリスト
     */
    public static List<EmpBean> findLimitedEmpInfoByDeptId(String deptId) {
        Connection con = null;
        PreparedStatement ps = null;
        List<EmpBean> empList = new ArrayList<EmpBean>();
        try {
            con = DBManager.getConnection();

            // 抽出項目を社員ID、社員名、部署名のみに絞ったSQL文を準備
            ps = con.prepareStatement(EMP_FIND_BY_DEPT_ID_LIMITED_EMP_IMFO);

            // 社員IDを検索条件に設定
            ps.setString(1, deptId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EmpBean empBean = new EmpBean();
                empBean.setEmpId(rs.getString("emp_id"));
                empBean.setEmpName(rs.getString("emp_name"));
                empBean.setDeptName(rs.getString("dept_name"));
                empList.add(empBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return empList;
    }

    /**
     * 社員テーブル部署ID、部署名と所属人数検索メソッド
     *
     * @return 社員テーブル部署関連の全件リスト
     */
    public static List<EmpBean> findEmployeeDeptAll() {

        Connection con = null;
        PreparedStatement ps = null;

        // 全件を格納するリストを準備しておく
        List<EmpBean> empList = new ArrayList<EmpBean>();

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(EMP_FIND_BY_DEPT);
            ResultSet rs = ps.executeQuery();

            // 検索結果をbeanに格納し、そのbeanをリストに詰める
            while (rs.next()) {
                EmpBean empBean = new EmpBean();
                empBean.setDeptId(rs.getString("dept_id"));
                empBean.setDeptName(rs.getString("dept_name"));
                empBean.setAffiliation(rs.getString("affiliation"));
                empList.add(empBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return empList;
    }

    /**
     * 部署IDによる1件検索メソッド
     *
     * @param deptId
     *            社員ID
     * @return 社員テーブルのbean
     */
    public static EmpBean findByDeptDeptId(String deptId) {

        // 接続準備
        Connection con = null;
        PreparedStatement ps = null;
        EmpBean empBean = null;

        // 全件を格納するリストを準備しておく
        List<EmpBean> empList = new ArrayList<EmpBean>();

        try {
            // DBに接続
            con = DBManager.getConnection();

            // SQL文を準備
            ps = con.prepareStatement(EMP_FIND_BY_DEPT_DEPT_ID);

            // 社員IDを検索条件に設定
            ps.setString(1, deptId);

            // SQL文を実行
            ResultSet rs = ps.executeQuery();

            // 検索結果をbeanに格納する
            if (rs.next()) {
                empBean = new EmpBean();
                empBean.setDeptId(rs.getString("dept_id"));
                empBean.setDeptName(rs.getString("dept_name"));
                empBean.setAffiliation(rs.getString("affiliation"));
                empList.add(empBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // DB切断処理
            DBManager.close(ps, con);
        }
        return empBean;
    }

    /**
     * 部署名による複数件検索メソッド
     *
     * @param deptName
     *            部署名
     * @return 社員テーブルのリスト
     */
    public static List<EmpBean> findByDeptNameContains(String deptName) {

        Connection con = null;
        PreparedStatement ps = null;

        // 全件を格納するリストを準備しておく
        List<EmpBean> empList = new ArrayList<EmpBean>();

        try {
            con = DBManager.getConnection();

            ps = con.prepareStatement(EMP_FIND_BY_DEPT_DEPT_Name);

            StringBuilder sb = new StringBuilder();
            sb.append("%");
            sb.append(deptName);
            sb.append("%");
            ps.setString(1, sb.toString());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EmpBean empBean = new EmpBean();
                empBean.setDeptId(rs.getString("dept_id"));
                empBean.setDeptName(rs.getString("dept_name"));
                empBean.setAffiliation(rs.getString("affiliation"));
                empList.add(empBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // DB切断処理
            DBManager.close(ps, con);
        }
        return empList;
    }


	public static void delete(String empId) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(EMP_DELETE_BY_ID);
            ps.setString(1, empId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // DB切断処理
            DBManager.close(ps, con);
        }
		return;
	}


	public static void insert(EmpBean emp) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(EMP_INSERT_NEWBIE);
            ps.setString(1, emp.getEmpPass());
            ps.setString(2, emp.getEmpName());
            ps.setString(3, emp.getGender());
            ps.setString(4, emp.getAddress());
            ps.setString(5, emp.getBirthday());
            ps.setString(6, emp.getAuthority());
            ps.setString(7, emp.getDeptId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // DB切断処理
            DBManager.close(ps, con);
        }
		return;
	}
	public static void updatePassword(String empId,String newPass) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(EMP_UPDATE_PASSWORD);
            ps.setString(1, newPass);
            ps.setString(2, empId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // DB切断処理
            DBManager.close(ps, con);
        }
		return;
	}
	public static void update(String empId, String passWord, String empName, String gender, String address,
			String birthday, String authority, String deptId) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(EMP_UPDATE_PROFILE);
            ps.setString(1, passWord);
            ps.setString(2, empName);
            ps.setString(3, gender);
            ps.setString(4, address);
            ps.setString(5, birthday);
            ps.setString(6, authority);
            ps.setString(7, deptId);
            ps.setString(8, empId);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // DB切断処理
            DBManager.close(ps, con);
        }
		return;
	}

}
