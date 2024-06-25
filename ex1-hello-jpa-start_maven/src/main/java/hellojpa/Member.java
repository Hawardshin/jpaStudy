package hellojpa;

import jakarta.persistence.*;

@Entity
@Table(name = "MEMBER")
public class Member {
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "NAME")
	private String username;
	private Integer age; //만약 대소문자를 구분하는 DB를 사용하면 @Column(name="AGE")로 해야함

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}