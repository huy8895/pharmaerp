package DKSPACE.PhamarERP.basecrud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

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
        return repository.findAllByDeletedAtIsNotNull(pageable);
    }

    @Override
    public E findOne(Long id) {
        log.info("findOne id : {}", id);
        return repository.findByIdAndDeletedAtIsNull(id)
                         .orElseThrow();
    }

    @Override
    public void softDelete(Long id) {
        log.info("softDelete id : {}", id);
        repository.findById(id)
                .ifPresent(e -> {
                    e.setDeletedAt(LocalDateTime.now());
                    repository.save(e);
                });
    }

    @Override
    public void hardDelete(Long id) {
        log.info("hardDelete id : {}", id);
        repository.deleteById(id);
    }

    @Override
    public List<E> saveList(List<E> list) {
        log.info("saveAll id : {}", list);
        return repository.saveAll(list);
    }
}
