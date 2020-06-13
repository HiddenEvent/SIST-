package com.demoweb.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tbl_member_roles")
@Data
public class MemberRoleEntity implements Serializable{
	@Id
	private String memberId;
	
	@Id
	private String roleName;
	
}
