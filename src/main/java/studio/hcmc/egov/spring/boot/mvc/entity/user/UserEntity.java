package studio.hcmc.egov.spring.boot.mvc.entity.user;

import jakarta.persistence.*;
import studio.hcmc.egov.spring.boot.mvc.domain.user.UserDomain;

@Entity(name = "user")
@Table(name = "user")
public class UserEntity implements UserDomain {
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", unique = true, nullable = false, updatable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    /**
     * JPA로부터 인스턴스 생성을 위한 빈 생성자
     */
    public UserEntity() {}

    /**
     * 다른 UserDomain으로부터 복사
     * @param domain 복사할 원본 UserDomain
     */
    public UserEntity(UserDomain domain) {
        this.id = domain.getId();
        this.email = domain.getEmail();
        this.password = domain.getPassword();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
