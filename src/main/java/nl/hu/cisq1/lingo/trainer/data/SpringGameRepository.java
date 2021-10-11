package nl.hu.cisq1.lingo.trainer.data;

import nl.hu.cisq1.lingo.trainer.domain.LingoGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringGameRepository extends JpaRepository<LingoGame, Long> {
    @Override
    <S extends LingoGame> S save(S s);

    @Override
    List<LingoGame> findAllById(Iterable<Long> iterable);

    LingoGame findLingoGameById(Long id);
}
