package DKSPACE.PhamarERP.basecrud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
public abstract class AbstractBaseCRUDService<E extends BaseCRUDEntity, R extends BaseCRUDRepository<E, Long>> implements BaseCRUDService<E> {
    protected final R repository;

    protected AbstractBaseCRUDService(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E baseCRUDEntity) {
        log.info("save baseCRUDEntity : {}", baseCRUDEntity);
        return repository.save(baseCRUDEntity);
    }
    @Override
    public E partialUpdate(E baseCRUDEntity) {
        log.info("baseCRUDEntity : {}", baseCRUDEntity);
        return repository
                .findById(baseCRUDEntity.getId())
                .map(existingProduct -> {
                    BaseCrudUtils.update(baseCRUDEntity, baseCRUDEntity);
                    return existingProduct;
                })
                .map(repository::save)
                .orElseThrow();
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        log.info("findAll pageable : {}", pageable);
        return repository.findAll(pageable);
    }

    @Override
    public E findOne(Long id) {
        log.info("findOne id : {}", id);
        return repository.findByIdAndDeletedFlagFalse(id)
                         .orElseThrow();
    }

    @Override
    public void softDelete(Long id) {
        log.info("softDelete id : {}", id);
        repository.findById(id)
                .ifPresent(e -> {
                    e.setDeletedFlag(true);
                    repository.save(e);
                });
    }

    @Override
    public void hardDelete(Long id) {
        log.info("hardDelete id : {}", id);
        repository.deleteById(id);
    }
}