package com.spring.dao.impl;

import com.spring.dao.AbstractDao;
import com.spring.dao.RoleDao;
import com.spring.exception.DataProcessingException;
import com.spring.model.Role;
import com.spring.model.RoleType;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(String name) {
        try (Session session = factory.openSession()) {
            Query<Role> getRoleByName = session.createQuery(
                    "FROM Role WHERE name = :name", Role.class);
            getRoleByName.setParameter("name", RoleType.getEnumValue(name));
            return getRoleByName.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Role with name " + name + " not found", e);
        }
    }
}
