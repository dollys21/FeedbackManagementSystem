package com.techm.learning.util;

public enum UserRoleType {
	ADMIN("Admin"),
	MANAGER("Manager");
	
	private String name;

	UserRoleType(String value) {
        this.name = value;
    }

    public String toCompareString() {
        return name.toUpperCase(); 
    }
    
    public static UserRoleType getValue(String value) {
        for(UserRoleType v : values())
            if(v.toString().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }

}
