package studio.hcmc.egov.spring.boot.mvc.service.user;

import org.springframework.stereotype.Service;
import studio.hcmc.egov.spring.boot.mvc.domain.user.UserDomain;
import studio.hcmc.egov.spring.boot.mvc.entity.user.UserEntity;
import studio.hcmc.egov.spring.boot.mvc.repository.user.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * {@link UserDomain}으로 사용자 정보 저장
     * @param domain 생성 또는 수정된 내용이 포함된 {@link UserDomain}
     * @return 생성 또는 수정된 내용이 반영된 {@link UserDomain}
     */
    public UserEntity save(UserDomain domain) {
        return userRepository.save(new UserEntity(domain));
    }

    /**
     * 사용자 ID으로 탐색
     * @param id 사용자 ID({@link UserDomain#getId()})
     * @return 탐색된 사용자, 존재하지 않을 때 {@link Optional#empty()}
     */
    public Optional<UserEntity> findById(long id) {
        return userRepository.findById(id);
    }

    /**
     * {@link UserDomain}으로 가능한 한 모두 일치하는 사용자를 탐색
     * @param domain 탐색할 내용이 포함된 {@link UserDomain}
     * @return 탐색된 사용자, 존재하지 않을 때 {@link Optional#empty()}
     */
    public Optional<UserEntity> findByDomain(UserDomain domain) {
        final var email = domain.getEmail();
        final var password = domain.getPassword();
        if (email != null && password != null) {
            return userRepository.findByEmailAndPassword(email, password);
        } else if (email != null) {
            return userRepository.findByEmail(email);
        } else {
            return Optional.empty();
        }
    }
}
