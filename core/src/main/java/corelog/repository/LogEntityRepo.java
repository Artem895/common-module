package corelog.repository;

import corelog.model.DbLogModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogEntityRepo extends JpaRepository<DbLogModel,Long> {
}
