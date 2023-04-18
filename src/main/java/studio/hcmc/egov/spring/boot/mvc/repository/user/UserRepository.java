package studio.hcmc.egov.spring.boot.mvc.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.hcmc.egov.spring.boot.mvc.entity.user.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /**
     * 이메일로 사용자 탐색
     * @param email 이메일
     * @return 탐색된 사용자, 존재하지 않을 때 {@link Optional#empty()}
     */
    Optional<UserEntity> findByEmail(String email);

    /**
     * 로그인 정보로 사용자 탐색
     * @param email 이메일
     * @param password 비밀번호
     * @return 탐색된 사용자, 존재하지 않을 때 {@link Optional#empty()}
     */
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
