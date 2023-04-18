package studio.hcmc.egov.spring.boot.mvc.vo.user;

import studio.hcmc.egov.spring.boot.mvc.domain.user.UserDomain;

public class UserVO implements UserDomain {
    private long id;

    private String email;

    private String password;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
