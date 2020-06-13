package com.demoweb.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tbl_member")
@Data
public class MemberEntity {
	
	@Id
	private String memberId;
	@Column
	private String passwd;
	@Column
	private String email;
	@Column
	private String userType = "user";
	@Column
	private Date regDate = new Date();
	@Column
	private boolean active;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "memberId")
	private Collection<MemberRoleEntity> memberRoles;
	
}
