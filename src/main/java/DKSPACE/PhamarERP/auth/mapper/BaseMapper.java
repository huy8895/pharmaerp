package DKSPACE.PhamarERP.auth.mapper;

public interface BaseMapper <D,E>{
    D toDTO(E entity);
    E toEntity(D dto);
}
