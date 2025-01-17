package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.CandidatesDAO;
import com.hms.entities.Candidates;

/*
 * 
 */
@Service
@Transactional(readOnly = true)
public class CandidatesServiceImpl implements CandidatesService {

	@Autowired
	private CandidatesDAO dao;

	@Override
	public Candidates findCandidateById(int id) {
		Candidates candidates = dao.findCandidateById(id);
		return candidates;
	}

	@Override
	public List<Candidates> findAllCandidates() {
		return dao.findAllCandidates();
	}

	@Override
	@Transactional
	public void addCandidates(Candidates candidates) {
		dao.addCandidates(candidates);
	}

	@Override
	@Transactional
	public Candidates updateCandidatesQuestionnaires(Candidates candidates) {
		Candidates c = findCandidateById(candidates.getCandidates_id());
		System.out.println(candidates.getCandidates_id());
		if (c == null) {
			throw new IllegalArgumentException("Id not Found " + candidates.getCandidates_id());
		}
		c.setNotice_period(candidates.getNotice_period());
		c.setExpected_ctc(candidates.getExpected_ctc());
		c.setShifts(candidates.getShifts());
		c.setRelocation(candidates.getRelocation());
		return dao.updateCandidatesQuestionnaires(c);
	}
	
	@Override
	@Transactional
	public void deleteCandidates(int id) {
		Candidates u = findCandidateById(id);
		if (u == null) {
			throw new IllegalArgumentException("ID not found " + id);
		}
		dao.deleteCandidates(u);
	}

	@Override
	public List<Candidates> findByDomainId(int id) {
		return dao.findByDomainId(id);
	}
}
