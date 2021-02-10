package org.homeboy.spring.repository;

import org.homeboy.spring.domains.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * {@Link User} {@Link Repository}
 * @author Tintin-Mask
 */
@Repository
public class UserRepository {

    private final ConcurrentMap<Integer, User> userDataCurrentMap = new ConcurrentHashMap<>();
    private final AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * save user info
     * @param user user object
     */
    public void save(User user) {
        int id = atomicInteger.incrementAndGet();
        user.setId(id);
        userDataCurrentMap.put(id, user);
    }

    /**
     * find all the user info.
     * @return all the user info list.
     */
    public Collection<User> findAll()
    {
        return userDataCurrentMap.values();
    }

}
