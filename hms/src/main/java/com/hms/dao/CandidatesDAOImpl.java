package com.hms.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.hms.entities.Candidates;
/*
 * 
 */
@Repository
public class CandidatesDAOImpl implements CandidatesDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void fetchCandidates() {
		
		String file = "D:\\CSVDemo.csv";
		Path pathToFile = Paths.get(file);
		List<Candidates> candList = new ArrayList<>();
		try(BufferedReader br = Files.newBufferedReader(pathToFile)) {
			
			String row = br.readLine();
			while(row!=null) {
				String [] attributes = row.split(",");
				Candidates cand = getOneCandidate(attributes);
				candList.add(cand);
				row=br.readLine();
			}
			
			System.out.println(candList);
//			addingCandidateList(candList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Candidates getOneCandidate(String[] attr) {
		
		Candidates can = new Candidates();
		can.setName(attr[0]);
		int exp = Integer.parseInt(attr[1]);
		can.setExp(exp);
		can.setCandidate_skills(attr[2]);
		can.setEmail(attr[3]);
		can.setContact_no(attr[4]);
		can.setCompany_name(attr[5]);
		can.setCandidates_location(attr[6]);
//		dom.setDomain_id(Integer.parseInt(candidate[1]));
//		can.setDomain(dom);
		
		return can;
	}
	
	public void addingCandidateList(List<Candidates> cand) {
		for(Candidates c : cand) {
			addCandidates(c);
		}
	}
	
	
	/*
	 * Get the candidates By Id.
	 */
	@Override
	public Candidates findCandidateById(int id) {
		Candidates candidates = em.find(Candidates.class, id);
		return candidates;
	}

	/*
	 * Get all the candidates present in the table.
	 */
	@Override
	public List<Candidates> findAllCandidates() {
		return em.createQuery("SELECT c FROM Candidates c", Candidates.class).getResultList();
	}

	/*
	 * Add Candidates Details into database.
	 */
	@Override
	public void addCandidates(Candidates candidates) {
		em.persist(candidates);
	}

	@Override
	public Candidates updateCandidatesQuestionnaires(Candidates candidates) {
		return em.merge(candidates);
	}
	
	@Override
	public void deleteCandidates(Candidates candidates) {
		em.remove(candidates);
	}

	
	@Override
	public List<Candidates> findByDomainId(int id) {
		List<Candidates> candidates = em.createNamedQuery("byDomainId",Candidates.class).setParameter(1,id).getResultList();
		return candidates;
	}

}
