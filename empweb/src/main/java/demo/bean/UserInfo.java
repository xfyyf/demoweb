package demo.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="userinfo")
public class UserInfo {
	@Id
	@GenericGenerator(strategy="foreign", name="empFK"
	   ,parameters=@Parameter(name="property", value="emp"))
	@GeneratedValue(generator="empFK")
	private Integer userid;
	
	private String username;
	private String pwd;
	
	@OneToOne(optional=false,mappedBy="user")
	private Emp emp;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="myrole_userinfo"
	    ,joinColumns=@JoinColumn(name="uid")
	   ,inverseJoinColumns=@JoinColumn(name="rid"))
	public Set<Role>  roles = new HashSet<Role>();

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", username=" + username + ", pwd=" + pwd + "]";
	}
	
	
}
