package DKSPACE.PhamarERP.general.repository;

import DKSPACE.PhamarERP.general.model.Uploadable;
import DKSPACE.PhamarERP.general.model.UploadableId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadableRepository extends JpaRepository<Uploadable, UploadableId> {
}