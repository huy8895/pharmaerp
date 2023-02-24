package DKSPACE.PhamarERP.repository;

import DKSPACE.PhamarERP.master_data.entity.Uploadable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadableRepository extends JpaRepository<Uploadable, Long> {
}
