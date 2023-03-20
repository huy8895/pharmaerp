package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserCertificateCriteria;
import DKSPACE.PhamarERP.master_data.entity.UserCertificate;
import DKSPACE.PhamarERP.master_data.entity.UserCertificate_;
import DKSPACE.PhamarERP.repository.UserCertificateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCertificateQueryService extends QueryService<UserCertificate> implements FilterService<UserCertificateCriteria> {
	private final UserCertificateRepository repository;
	
	@Transactional(readOnly = true)
	public Page<UserCertificate> findByCriteria(UserCertificateCriteria criteria, Pageable page) {
		log.debug("UserCertificateQueryService find by criteria : {}, page: {}", criteria, page);
		final Specification<UserCertificate> specification = this.createSpecification(criteria);
		return repository.findAll(specification, page);
	}
	
	private Specification<UserCertificate> createSpecification(UserCertificateCriteria criteria) {
		return SpecificationBuilder
				.<UserCertificate>builder()
				.and(criteria.getUserId(), filter -> this.buildSpecification(filter, UserCertificate_.userId))
				.and(criteria.getName(), filter -> this.buildStringSpecification(filter, UserCertificate_.name))
				.and(criteria.getOrganization(), filter -> this.buildStringSpecification(filter, UserCertificate_.organization))
				.and(criteria.getHasNoExpirationDate(), filter -> this.buildSpecification(filter, UserCertificate_.hasNoExpirationDate))
				.and(criteria.getStartDate(), filter -> this.buildStringSpecification(filter, UserCertificate_.startDate))
				.and(criteria.getEndDate(), filter -> this.buildStringSpecification(filter, UserCertificate_.endDate))
				.and(criteria.getLink(), filter -> this.buildStringSpecification(filter, UserCertificate_.link))
				.build();
	}
}