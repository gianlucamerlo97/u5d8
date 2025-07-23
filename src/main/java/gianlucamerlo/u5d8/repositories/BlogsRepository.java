package gianlucamerlo.u5d8.repositories;

import gianlucamerlo.u5d8.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogsRepository extends JpaRepository<Blog, UUID> {
}
