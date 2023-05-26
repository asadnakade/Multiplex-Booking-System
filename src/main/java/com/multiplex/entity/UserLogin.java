package com.multiplex.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="User_Login")
public class UserLogin {
@Id
@Column(name="No")
private int val;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumns({
@JoinColumn(name="USERID", referencedColumnName="userId"),
@JoinColumn(name="PASSWORD", referencedColumnName="password")
})
private User user;

public UserLogin(User user, int val) {
super();
this.user = user;
this.val = val;
}
public UserLogin() {
super();
}
public User getUser() {
return user;
}
public void setUser(User user) {
this.user = user;
}
public int getVal() {
return val;
}
public void setVal(int val) {
this.val = val;
}
}