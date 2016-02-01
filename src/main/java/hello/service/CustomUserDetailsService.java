package hello.service;

import hello.model.User;
import hello.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by skyADMIN on 16/2/1.
 */
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByMail(s);
        if (user == null){
            throw new UsernameNotFoundException("Username "+ s + " not found");
        }
        return new SecurityUser(user);
    }
}
