package com.interna.gatewayservice.model.user;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.spi.QueryImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class UserPrefixedSequenceIdGenerator implements IdentifierGenerator {

    private String generateUserId(User user, String prefix) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DDD");
        return prefix
                .concat(String.valueOf(LocalDateTime.now().getYear()))
                .concat(LocalDateTime.now().format(formatter))
                .concat(String.valueOf(LocalDateTime.now().getNano()).substring(0, 6));
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        IdentifierGenerator.super.configure(type, params, serviceRegistry);
    }

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        User user = (User) o;
        return String.format(generateUserId(user, rolePrefix(user, sharedSessionContractImplementor)));
    }

    private String rolePrefix(User user, SharedSessionContractImplementor session) {
        String query = "SELECT name from Role where id = :id";
        QueryImplementor<String> nameRoleQuery = session.createQuery(query, String.class);
        nameRoleQuery.setParameter("id", user.getRole().getId());
        return rolePrefixRefactor(nameRoleQuery.getSingleResult());
    }

    private String rolePrefixRefactor(String s) {
        return s.substring(0, 2);
    }
}
