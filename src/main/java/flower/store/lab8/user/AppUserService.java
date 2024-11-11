package flower.store.lab8.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private final UserRepository appUserRepository;

    @Autowired
    public AppUserService(UserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public AppUser addUser(AppUser appUser) {
        Optional<AppUser> userOptional = appUserRepository.findUserByEmail(appUser.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        return appUserRepository.save(appUser);
    }
}