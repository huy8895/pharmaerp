package DKSPACE.PhamarERP.general.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class CrmCompaniesCrmLeadId implements Serializable {
	private static final long serialVersionUID = 3887721060089161610L;
	@NotNull
	@Column(name = "crm_company_id", nullable = false)
	private Long crmCompanyId;
	
	@NotNull
	@Column(name = "crm_lead_id", nullable = false)
	private Long crmLeadId;
	
	@NotNull
	@Column(name = "crm_lead_item_id", nullable = false)
	private Long crmLeadItemId;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CrmCompaniesCrmLeadId entity = (CrmCompaniesCrmLeadId) o;
		return Objects.equals(this.crmCompanyId, entity.crmCompanyId) &&
				Objects.equals(this.crmLeadItemId, entity.crmLeadItemId) &&
				Objects.equals(this.crmLeadId, entity.crmLeadId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(crmCompanyId, crmLeadItemId, crmLeadId);
	}
	
}