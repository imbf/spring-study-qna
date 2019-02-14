package codesquad.repository;

import codesquad.model.Answer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
    Optional<Answer> findByQuestionId(Long questionId);
}
