package com.example.web;

import lombok.Data;

/**
 * ユーザー情報のページクラス.
 * @author sho
 *
 */
@Data
public class UserPage {
	
	/** ユーザーID */
	private Long id;
	/** ユーザー名 */
	private String name;
	/** ユーザーメールアドレス */
	private String email;
	/** ユーザー住所 */
	private String address;
	/** ユーザー電話番号 */
	private String telephone;
	/** ページ遷移を記録 */
	private String beforePage;
}
