package se.ecutb.cai.ListCrudApplication.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class AppUser {

    private String userId;
    private String email;
    private String name;
    private LocalDate birthDate;
    private LocalDateTime timestamp;

    public AppUser(String email, String name, LocalDate birthDate, LocalDateTime timestamp) {
        this.userId = UUID.randomUUID().toString();
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
        this.timestamp = timestamp;
    }

    public AppUser() {}

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(userId, appUser.userId) &&
                Objects.equals(email, appUser.email) &&
                Objects.equals(name, appUser.name) &&
                Objects.equals(birthDate, appUser.birthDate) &&
                Objects.equals(timestamp, appUser.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, name, birthDate, timestamp);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", timestamp=" + timestamp +
                '}';
    }
}
