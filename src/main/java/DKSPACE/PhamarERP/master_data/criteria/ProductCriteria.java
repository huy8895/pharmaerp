package DKSPACE.PhamarERP.master_data.criteria;


import lombok.*;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ProductCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter name;

    private LongFilter modelId;

    private LongFilter categoryId;

    private LongFilter brandId;

    private LongFilter colorId;

    private LongFilter storageId;

    private Boolean distinct;
    
    @Override
    public ProductCriteria copy(ProductCriteria productCriteria) {
        ProductCriteria productCriteria = ProductCriteria.builder()
        		.serialVersionUID()
        		.id(productCriteria.getId())
        		.name(productCriteria.getName())
        		.modelId(productCriteria.getModelId())
        		.categoryId(productCriteria.getCategoryId())
        		.brandId(productCriteria.getBrandId())
        		.colorId(productCriteria.getColorId())
        		.storageId(productCriteria.getStorageId())
        		.distinct(productCriteria.getDistinct())
        		.build();
        return productCriteria;
    }
}
