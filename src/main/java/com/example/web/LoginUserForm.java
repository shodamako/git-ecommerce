package com.example.web;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザーログイン用のフォーム.
 * @author sho
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserForm {
	
	/** ユーザーのメールアドレス */
	@NotEmpty(message="メールアドレスを入力してください")
	@Email(message="emailはメールアドレスとして不正です")
	private String email;
	/** ユーザーのパスワード */
	@NotBlank(message="パスワードを入力してください")
	private String password;
}
