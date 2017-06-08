package com.hxqh.eam.dao;

import com.hxqh.eam.common.basedao.DaoSupport;
import com.hxqh.eam.model.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends DaoSupport<User> implements UserDao {

}
