package DKSPACE.PhamarERP.basecrud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@NoRepositoryBean
public interface BaseCRUDRepository<E extends BaseCRUDEntity, ID> extends JpaRepository<E, ID> ,
        JpaSpecificationExecutor<E> {
    Optional<E> findByIdAndDeletedAtIsNull(ID id);
    Page<E> findAllByDeletedAtIsNull(@Param("pageable") Pageable pageable);
}
