package demo.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="myemp")
public class Emp {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer eid;
	
	private String ename;
	private String sex;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hire;
	
	private Float sar;
	
	@Column(insertable=false, updatable=false)
	private Integer did;
	
	@ManyToOne
	@JoinColumn(name="did")
	private Dept dept; // 员工对部门  多对一关联 
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private UserInfo user;  //  员工对帐号  一对一关联  主 对 从

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}



	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Date getHire() {
		return hire;
	}

	public void setHire(Date hire) {
		this.hire = hire;
	}

	public Float getSar() {
		return sar;
	}

	public void setSar(Float sar) {
		this.sar = sar;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", sex=" + sex + ", hire=" + hire + ", sar=" + sar + ", did="
				+ did + ", dept=" + dept + ", user=" + user + "]";
	}




	
	
	
}
