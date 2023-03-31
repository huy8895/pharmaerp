package DKSPACE.PhamarERP.basecrud;

import DKSPACE.PhamarERP.basecrud.query.Criteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseCRUDService<E extends BaseCRUDEntity> {
    /**
     * Save a baseCRUDEntity.
     *
     * @param baseCRUDEntity the entity to save.
     * @return the persisted entity.
     */
    E save(E baseCRUDEntity);


    /**
     * Partially updates a baseCRUDEntity.
     * update 1 phần. chỉ update với những trường nào khác null.
     *
     * @param baseCRUDEntity the entity to update partially.
     * @return the persisted entity.
     */
    E partialUpdate(E baseCRUDEntity);

    /**
     * Get all the capacities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<E> findAll(Pageable pageable);

    /**
     * Get the "id" baseCRUDEntity.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    E findOne(Long id);

    /**
     * Soft Delete the "id" baseCRUDEntity.
     * set deleted_flag to True
     * @param id the id of the entity.
     */
    void softDelete(Long id);

    /**
     * Hard Delete the "id" baseCRUDEntity.
     * remove from entity
     * @param id the id of the entity.
     */
    void hardDelete(Long id);

    List<E> saveList(List<E> entity);
    
    default Object findByCriteria(Pageable pageable, Criteria<E> criteria){
        return null;
    }
    
    Object toggleActive(Long id, Class<E> entityClass);
}
