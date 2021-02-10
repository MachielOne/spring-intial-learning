package org.homeboy.spring.Repository;

import org.homeboy.spring.domains.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * {@link User} {@Link Repository}
 */
@Repository
public class UserRepository {

    private ConcurrentMap<Integer, User> userDataCourrentMap = new ConcurrentHashMap<>();
    private AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 保存用户对象
     * @param user
     * @return 如果保存成功，返回<code>true</code>,
     * 否则，返回<code>false</code>
     */
    public boolean save(User user) {
        Integer id = atomicInteger.incrementAndGet();
        user.setId(id);
        return userDataCourrentMap.put(id, user) == null;
    }

    /**
     * 获取用户列表
     * @return 返回所有user列表
     */
    public Collection<User> findAll()
    {
        return userDataCourrentMap.values();
    }

}
