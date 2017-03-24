package com.dili.ping.server.domain;

/**
 *	状态枚举
 */
public class StateEnum {

	public enum Yn{
		YES(1,"是"),
		NO(0,"否");
		private Integer code ;
		private String desc;
		
		private Yn(int code, String desc) {
			this.code = code;
			this.desc = desc;
		}
		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public static Yn getYn(Integer code) {
			for (Yn yn : Yn.values()) {
				if (yn.getCode()==code) {
					return yn;
				}
			}
			return null;
		}
	}

	
	
}
