package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理者のデータ.
 * @author sho
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUser {
	/** 管理者のID */
	private Long id;
	/** 管理者の名前 */
	private String name;
	/** 管理者のメールアドレス */
	private String email;
	/** 管理者のパスワード */
	private String password;
	/** IDの入力値が数字以外の場合に使う */
	private String idRegisterCheck;
}
