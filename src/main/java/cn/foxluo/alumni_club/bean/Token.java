package cn.foxluo.alumni_club.bean;

import cn.foxluo.alumni_club.model.User;

public class Token{
		private String tokenString;
		private User user;
		private long endTime;
		
		public Token(String tokenString, User user, long endTime) {
			super();
			this.tokenString = tokenString;
			this.user = user;
			this.endTime = endTime;
		}

		public Token(String ub, String username, long endTime2) {
			// TODO Auto-generated constructor stub
		}

		/**
		 * @return the tokenString
		 */
		public String getTokenString() {
			return tokenString;
		}
		/**
		 * @param tokenString2 the tokenString to set
		 */
		public void setTokenString(String tokenString2) {
			this.tokenString = tokenString2;
		}
		

		/**
		 * @return the user
		 */
		public User getUser() {
			return user;
		}

		/**
		 * @param user the user to set
		 */
		public void setUser(User user) {
			this.user = user;
		}

		/**
		 * @return the endTime
		 */
		public long getEndTime() {
			return endTime;
		}

		/**
		 * @param endTime the endTime to set
		 */
		public void setEndTime(long endTime) {
			this.endTime = endTime;
		}
		
	}