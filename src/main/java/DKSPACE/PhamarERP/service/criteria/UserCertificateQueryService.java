package DKSPACE.PhamarERP.service.criteria;

import DKSPACE.PhamarERP.helper.query.QueryService;
import DKSPACE.PhamarERP.helper.query.SpecificationBuilder;
import DKSPACE.PhamarERP.master_data.dto.criteria.UserCertificateCriteria;
import DKSPACE.PhamarERP.master_data.entity.UserCertificate;
import DKSPACE.PhamarERP.master_data.entity.UserCertificate_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service

public class UserCertificateQueryService extends QueryService<UserCertificate> implements FilterService<UserCertificate,UserCertificateCriteria> {
	public Specification<UserCertificate> createSpecification(UserCertificateCriteria criteria) {
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