package se.ecutb.cai.ListCrudApplication.data;

import se.ecutb.cai.ListCrudApplication.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserDao {
    Optional<AppUser> findById(String userId);

    List<AppUser> findAll();

    Optional<AppUser> findByEmail(String email);

    boolean save(AppUser appUser);

    AppUser update(AppUser appUser);

    boolean delete(String userId);
}
