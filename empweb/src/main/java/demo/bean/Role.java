package demo.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="myrole")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer  roleid;
	
	private String rolename;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="myrole_userinfo"   // 中间表名
	    ,joinColumns=@JoinColumn(name="rid")  //中间表中指向自己的外键字段名
	    ,inverseJoinColumns=@JoinColumn(name="uid")) //中间表中指向对方的外键字段名
	private Set<UserInfo> users = new HashSet<UserInfo>();

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(Set<UserInfo> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + "]";
	}
	
	
	
}
