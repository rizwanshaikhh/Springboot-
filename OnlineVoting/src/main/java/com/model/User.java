package com.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

	@NotNull(message = "Name Can Not Be Empty")
	@Size(min=3,message="person name should create atleast 3character")
	private String userName;
	
	@Column(name="VotingCardNumber",unique=true,length=30)
	@NotNull(message = "Voting Number Can Not Be Empty")
	@Size(min=10, max=10, message = "Voter Number should be exact 10 letters and it should be combination of letters and numbers")
    private String userVotingCardNumber;
	
	@NotNull(message = "Address Can Not Be Empty")
	private String userAddress;
	
	@Column(name="MobileNumber", unique=true)
	@NotNull(message = " Mobile Number Can Not Be Empty")
	@Pattern(regexp="^[6-9][0-9]{9}$")
	@Size(min=10, max=10, message ="Mobile Number Should Contains 10 Digits")
    private String userMobileNumber;
	
	@Column(name="emailid",unique=true,length=25)
	@NotEmpty
	@Email(message="Email is not valid")
	private String userEmail;
	
	@Column(name="password",length=20)
	@NotNull(message = "Password Can Not Be Empty")
	@Size(min=8,message="password length must be 8 characters and upparcase,lowercase,digit")
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
    private String userPassword;
    
	@NotNull
    private LocalDate userDateOfBirth;
    
    @NotNull
    @Size(min=4,message="person gender should have atleast 4 characters")
    private String userGender;
    	
	@NotNull
	private String userRole;
	
	private String status;
	
	private boolean isActivateAccount;

	public User(Long userId,
			@NotNull(message = "Name Can Not Be Empty") @Size(min = 3, message = "person name should create atleast 3character") String userName,
			@NotNull(message = "Voting Number Can Not Be Empty") @Size(min = 10, max = 10, message = "Voter Number should be exact 10 letters and it should be combination of letters and numbers") String userVotingCardNumber,
			@NotNull(message = "Address Can Not Be Empty") String userAddress,
			@NotNull(message = " Mobile Number Can Not Be Empty") @Pattern(regexp = "^[6-9][0-9]{9}$") @Size(min = 10, max = 10, message = "Mobile Number Should Contains 10 Digits") String userMobileNumber,
			@NotEmpty @Email(message = "Email is not valid") String userEmail,
			@NotNull(message = "Password Can Not Be Empty") @Size(min = 8, message = "password length must be 8 characters and upparcase,lowercase,digit") @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}") String userPassword,
			@NotNull LocalDate userDateOfBirth,
			@NotNull @Size(min = 4, message = "person gender should have atleast 4 characters") String userGender,
			@NotNull String userRole, String status, boolean isActivateAccount) {
		
		this.userId = userId;
		this.userName = userName;
		this.userVotingCardNumber = userVotingCardNumber;
		this.userAddress = userAddress;
		this.userMobileNumber = userMobileNumber;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userDateOfBirth = userDateOfBirth;
		this.userGender = userGender;
		this.userRole = userRole;
		this.status = status;
		this.isActivateAccount = isActivateAccount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserVotingCardNumber() {
		return userVotingCardNumber;
	}

	public void setUserVotingCardNumber(String userVotingCardNumber) {
		this.userVotingCardNumber = userVotingCardNumber;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public LocalDate getUserDateOfBirth() {
		return userDateOfBirth;
	}

	public void setUserDateOfBirth(LocalDate userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isActivateAccount() {
		return isActivateAccount;
	}

	public void setActivateAccount(boolean isActivateAccount) {
		this.isActivateAccount = isActivateAccount;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userVotingCardNumber=" + userVotingCardNumber
				+ ", userAddress=" + userAddress + ", userMobileNumber=" + userMobileNumber + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userDateOfBirth=" + userDateOfBirth + ", userGender="
				+ userGender + ", userRole=" + userRole + ", status=" + status + ", isActivateAccount="
				+ isActivateAccount + "]";
	}
	
	
	
	


}

/*
 * @Column(name = "isactivateaccount", length = 20)
private boolean isActivateAccount;
 */	