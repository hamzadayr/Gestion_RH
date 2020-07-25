package com.master_isi.dayr.service;

import com.master_isi.dayr.model.User;

public interface UserService {

	public void saveUser(User user);
	
	public boolean isUserAlreadyPresent(User user);
}
