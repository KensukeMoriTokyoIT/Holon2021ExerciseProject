package jp.co.sss.emanage.action;

import jp.co.sss.emanage.bean.EmpBean;

/**
 * 各ページでログインチェック、権限チェックを行うためのクラス
 */
public class UserCheck {

	/**
	 * ユーザーがログインしているか確認するメソッド
	 * @param セッションにいれたuser
	 * @return userがログインしているか真偽を返す
	 */
	public static boolean loginCheck(EmpBean user) {
		boolean isLogin = false;
		if (user.getEmpId() != null) {
			isLogin = true;
		}
		return isLogin;
	}

/**
 *
 * @param セッションにいれたuser
 * @return userが管理者か真偽を返す
 */
	public static boolean authorityCheck(EmpBean user) {
		boolean isAdmin = false;
		if(user.getAuthority()=="2") {
			isAdmin = true;
		}
		return isAdmin;
	}
}
