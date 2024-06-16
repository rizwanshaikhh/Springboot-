package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Party;

public interface PartyRepository extends JpaRepository<Party, Long> {
	
	public List<Party> findByPartyName(String partyName);
	public List<Party> findByPartyLogo(String partyLogo);
    public void deleteByPartyId(Long partyId);

}