package com.revature.models;

public class Role {
	private int roleId; 
	private String role; 
	
	// Since I added this do i need to add the no args constructor ????????
	public Role(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public void printRole() {
		System.out.println("Your Role is " + role + " and your role id is " + roleId);
	}


}
