package com.hms.service;

import java.util.List;

import com.hms.entities.Admin;

/*
 * 
 */
public interface AdminService{

	Admin getAdminById(int id);

	List<Admin> getAllAdmins();

}