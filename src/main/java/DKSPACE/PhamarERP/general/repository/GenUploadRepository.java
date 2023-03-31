package DKSPACE.PhamarERP.general.repository;

import DKSPACE.PhamarERP.basecrud.BaseCRUDRepository;
import DKSPACE.PhamarERP.general.model.GenUpload;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface GenUploadRepository extends BaseCRUDRepository<GenUpload, Long> {
	@Query("select g from GenUpload g where g.id in :genUploadIds")
	Set<GenUpload> findByIdIn(@Param("genUploadIds") Set<Long> genUploadIds);
}