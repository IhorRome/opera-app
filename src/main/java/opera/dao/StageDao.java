package opera.dao;

import opera.model.Stage;

import java.util.List;
import java.util.Optional;

public interface StageDao {
    Stage add(Stage stage);

    Optional<Stage> get(Long id);

    List<Stage> getAll();
}
