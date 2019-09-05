package codesquad.dao;

import codesquad.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByUserId(String userId);
}
