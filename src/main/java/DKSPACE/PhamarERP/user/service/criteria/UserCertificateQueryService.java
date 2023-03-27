package DKSPACE.PhamarERP.user.service.criteria;

import DKSPACE.PhamarERP.basecrud.query.FilterService;
import DKSPACE.PhamarERP.basecrud.query.SpecificationBuilder;
import DKSPACE.PhamarERP.user.dto.criteria.UserCertificateCriteria;
import DKSPACE.PhamarERP.user.model.UserCertificate;
import DKSPACE.PhamarERP.user.model.UserCertificate_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserCertificateQueryService extends FilterService<UserCertificate, UserCertificateCriteria> {
	public Specification<UserCertificate> createSpecification(UserCertificateCriteria criteria) {
		return SpecificationBuilder
				.<UserCertificate>builder()
				.and(criteria.getUserId(), UserCertificate_.userId, super::buildSpecification)
				.and(criteria.getName(), UserCertificate_.name, super::buildStringSpecification)
				.and(criteria.getOrganization(), UserCertificate_.organization, super::buildStringSpecification)
				.and(criteria.getHasNoExpirationDate(), UserCertificate_.hasNoExpirationDate, super::buildSpecification)
				.and(criteria.getStartDate(), UserCertificate_.startDate, super::buildStringSpecification)
				.and(criteria.getEndDate(), UserCertificate_.endDate, super::buildStringSpecification)
				.and(criteria.getLink(), UserCertificate_.link, super::buildStringSpecification)
				.build();
	}
}