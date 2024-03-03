package wedsan.simplemarketplace.infrastructure.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import wedsan.simplemarketplace.infrastructure.entity.UserEntity;
import wedsan.simplemarketplace.infrastructure.persistence.UserRepository;

import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.getUserEntityByEmail(email);
        User user = new User(
                userEntity.getEmail(),
                userEntity.getPassword(),
                mapToSimpleGrantedAuthority(userEntity)
        );
        return user;
    }

    private List<SimpleGrantedAuthority> mapToSimpleGrantedAuthority(UserEntity user){
        return List.of(new SimpleGrantedAuthority(user.getUserRoles().toString()));
    }
}
