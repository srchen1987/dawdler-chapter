package com.anywide.yyg.user.validator.operators;

import com.anywide.dawdler.clientplug.web.validator.operators.StringRuleOperator;

/**
 * 
 * 密码验证规则
 */
public class RegPasswordRuleOperator extends StringRuleOperator {
	public static final String RULE_KEY = "regPassword";
	public static final String REGEX = "^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z_!@#$%^&*`~()\\-+=.,;:{}?<>'\"|/\\\\\\[\\]\\s]+$)(?![a-z0-9]+$)(?![a-z_!@#$%^&*`~()\\-+=.,;:{}?<>'\"|/\\\\\\[\\]\\s]+$)(?![0-9_!@#$%^&*`~()\\-+=.,;:{}?<>'\"|/\\\\\\[\\]\\s]+$)[a-zA-Z0-9_!@#$%^&*`~()\\-+=.,;:{}?<>'\"|/\\\\\\[\\]\\s]{8,16}$";
	public static final String EXPLAIN = "密码验证：至少包含大写字母、小写字母、数字、特殊字符中的3种，长度为8-16位！";

	public RegPasswordRuleOperator() {
		super(RULE_KEY, REGEX, EXPLAIN);
	}

	@Override
	public String validate(Object value) {
		return super.validate(value, "至少包含大写字母、小写字母、数字、特殊字符中的3种，长度为8-16位！");
	}

	@Override
	public String toString() {
		return EXPLAIN;
	}
}
