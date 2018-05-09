package forbeatdev.userrestapi.repository;
/**Standard repository interface*/
import forbeatdev.userrestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
