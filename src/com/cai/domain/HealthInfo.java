package com.cai.domain;

public class HealthInfo {
		private Long info_id;
		private String spressure;
	    private  String dpressure;
	    private String temperature;
	    private  String bsugar;
	    private String boxygen;
	    private String hearterate;
	    private String preresult;
	    private String loginname;
	    private java.sql.Timestamp regDate;
		public String getSpressure() {
			return spressure;
		}
		public void setSpressure(String spressure) {
			this.spressure = spressure;
		}
		public String getDpressure() {
			return dpressure;
		}
		public void setDpressure(String dpressure) {
			this.dpressure = dpressure;
		}
		public String getTemperature() {
			return temperature;
		}
		public void setTemperature(String temperature) {
			this.temperature = temperature;
		}
		public String getBsugar() {
			return bsugar;
		}
		public void setBsugar(String bsugar) {
			this.bsugar = bsugar;
		}
		public String getBoxygen() {
			return boxygen;
		}
		public void setBoxygen(String boxygen) {
			this.boxygen = boxygen;
		}
		public String getHearterate() {
			return hearterate;
		}
		public void setHearterate(String hearterate) {
			this.hearterate = hearterate;
		}
		public String getPreresult() {
			return preresult;
		}
		public void setPreresult(String preresult) {
			this.preresult = preresult;
		}
		public String getLoginname() {
			return loginname;
		}
		public void setLoginname(String loginname) {
			this.loginname = loginname;
		}
		public java.sql.Timestamp getRegDate() {
			return regDate;
		}
		public void setRegDate(java.sql.Timestamp regDate) {
			this.regDate = regDate;
		}
		public Long getInfo_id() {
			return info_id;
		}
		public void setInfo_id(Long info_id) {
			this.info_id = info_id;
		}
		
	

}
