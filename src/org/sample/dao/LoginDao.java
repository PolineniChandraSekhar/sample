package org.sample.dao;

import org.sample.domain.User;

public interface LoginDao {

	public User getUser(String name);
}
