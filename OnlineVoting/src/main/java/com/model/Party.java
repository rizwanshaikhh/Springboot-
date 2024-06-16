package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partyId;

    @NotNull(message = "Please Give Unique Party Name")
    @Column(name="PartyName", unique=true)
    private String partyName;
    
    @NotNull(message = "Please Insert Party Logo")
    @Column(name="PartyLogo", unique=true)
    private String partyLogo;
    
    private String partyLeaderName;
    
    private int votes;

	public Party(Long partyId, @NotNull(message = "Please Give Unique Party Name") String partyName,
			@NotNull(message = "Please Insert Party Logo") String partyLogo, String partyLeaderName, int votes) {
		
		this.partyId = partyId;
		this.partyName = partyName;
		this.partyLogo = partyLogo;
		this.partyLeaderName = partyLeaderName;
		this.votes = votes;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyLogo() {
		return partyLogo;
	}

	public void setPartyLogo(String partyLogo) {
		this.partyLogo = partyLogo;
	}

	public String getPartyLeaderName() {
		return partyLeaderName;
	}

	public void setPartyLeaderName(String partyLeaderName) {
		this.partyLeaderName = partyLeaderName;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Party [partyId=" + partyId + ", partyName=" + partyName + ", partyLogo=" + partyLogo
				+ ", partyLeaderName=" + partyLeaderName + ", votes=" + votes + "]";
	}
	
	
    
    

  
}
