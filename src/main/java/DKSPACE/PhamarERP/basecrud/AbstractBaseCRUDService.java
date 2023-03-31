package DKSPACE.PhamarERP.basecrud;

import DKSPACE.PhamarERP.i18n.enums.ApiResponseInfo;
import DKSPACE.PhamarERP.i18n.exception.ClientException;
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
        if (baseCRUDEntity.getId() == null){
            log.error("The given id must not be null");
            throw new ClientException(ApiResponseInfo.BAD_REQUEST);
        }
        return repository
                .findById(baseCRUDEntity.getId())
                .map(existingProduct -> {
                    BaseCrudUtils.update(baseCRUDEntity, existingProduct);
                    return existingProduct;
                })
                .map(repository::save)
                .orElseThrow();
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        log.info("findAll pageable : {}", pageable);
        return repository.findAllByDeletedAtIsNull(pageable);
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
        E entity = this.findOne(id);
        entity.setDeletedAt(LocalDateTime.now());
        repository.save(entity);
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
    
    @Override
    public Object toggleActive(Long id, Class<E > entityClass) {
        final var entity = this.findOne(id);
        if (entity instanceof Toggleable toggleable){
            final var isActive = toggleable.getIsActive() != null && toggleable.getIsActive();
            toggleable.setIsActive(!isActive);
            this.save(entity);
        }
        return null;
    }
}
