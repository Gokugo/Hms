package com.hms.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;

/*
 * 
 */
@Entity

@NamedNativeQueries({
	@NamedNativeQuery(name="byDomainId",query = "select * from candidates where job_id = ?",resultClass = Candidates.class)
})
public class Candidates implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int candidates_id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int exp;
	
	@Column(nullable = false)
	private String candidate_skills;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String contact_no;
	
	@Column(nullable = false)
	private String company_name;
	
	@Column(nullable = false)
	private String candidates_location;
	
	private int notice_period;
	private int expected_ctc;
	private String shifts;
	private String relocation;
	private String feedback;
	private LocalDateTime interview_sceduled_date;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	private Domain domain;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Interviewer interviewer;

	public Candidates() {
		super();
	}

	public Candidates(int candidates_id, String name, int exp, String candidate_skills, String email, String contact_no,
			String company_name, String candidates_location, int notice_period, int expected_ctc, String shifts,
			String relocation, String feedback, LocalDateTime interview_sceduled_date, String status, Domain domain) {
		super();
		this.candidates_id = candidates_id;
		this.name = name;
		this.exp = exp;
		this.candidate_skills = candidate_skills;
		this.email = email;
		this.contact_no = contact_no;
		this.company_name = company_name;
		this.candidates_location = candidates_location;
		this.notice_period = notice_period;
		this.expected_ctc = expected_ctc;
		this.shifts = shifts;
		this.relocation = relocation;
		this.feedback = feedback;
		this.interview_sceduled_date = interview_sceduled_date;
		this.status = status;
		this.domain = domain;
	}

	public int getCandidates_id() {
		return candidates_id;
	}

	public void setCandidates_id(int candidates_id) {
		this.candidates_id = candidates_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getCandidate_skills() {
		return candidate_skills;
	}

	public void setCandidate_skills(String candidate_skills) {
		this.candidate_skills = candidate_skills;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCandidates_location() {
		return candidates_location;
	}

	public void setCandidates_location(String candidates_location) {
		this.candidates_location = candidates_location;
	}

	public int getNotice_period() {
		return notice_period;
	}

	public void setNotice_period(int notice_period) {
		this.notice_period = notice_period;
	}

	public int getExpected_ctc() {
		return expected_ctc;
	}

	public void setExpected_ctc(int expected_ctc) {
		this.expected_ctc = expected_ctc;
	}

	public String getShifts() {
		return shifts;
	}

	public void setShifts(String shifts) {
		this.shifts = shifts;
	}

	public String getRelocation() {
		return relocation;
	}

	public void setRelocation(String relocation) {
		this.relocation = relocation;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public LocalDateTime getInterview_sceduled_date() {
		return interview_sceduled_date;
	}

	public void setInterview_sceduled_date(LocalDateTime interview_sceduled_date) {
		this.interview_sceduled_date = interview_sceduled_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "Candidates [candidates_id=" + candidates_id + ", name=" + name + ", exp=" + exp + ", candidate_skills="
				+ candidate_skills + ", email=" + email + ", contact_no=" + contact_no + ", company_name="
				+ company_name + ", candidates_location=" + candidates_location + ", notice_period=" + notice_period
				+ ", expected_ctc=" + expected_ctc + ", shifts=" + shifts + ", relocation=" + relocation + ", feedback="
				+ feedback + ", interview_sceduled_date=" + interview_sceduled_date + ", status=" + status + ", domain="
				+ domain + "]";
	}

}