package se.ecutb.cai.ListCrudApplication.data;

import org.springframework.stereotype.Component;
import se.ecutb.cai.ListCrudApplication.entity.AppUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AppUserDaoImpl implements AppUserDao {

    List<AppUser> userList = new ArrayList<>();

    @Override
    public Optional<AppUser> findById(String userId) {
        return userList.stream().
                filter(appUser -> appUser.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public List<AppUser> findAll() {
        return userList;
    }

    @Override
    public Optional<AppUser> findByEmail(String email) {
        return userList.stream()
                .filter(appUser -> appUser.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public boolean save(AppUser appUser) {
        return userList.add(appUser);
    }

    @Override
    public AppUser update(AppUser appUser) {
        AppUser original = findById(appUser.getUserId()).get();
        original.setBirthDate(appUser.getBirthDate());
        original.setEmail(appUser.getEmail());
        original.setName(appUser.getName());
        return original;
    }

    @Override
    public boolean delete(String userId) {
        AppUser appUser = findById(userId).get();
        return userList.remove(appUser);
    }



}
