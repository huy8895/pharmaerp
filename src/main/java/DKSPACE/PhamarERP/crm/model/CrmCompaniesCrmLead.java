package DKSPACE.PhamarERP.crm.model;

import DKSPACE.PhamarERP.general.model.CrmCompaniesCrmLeadId;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "crm_companies_crm_leads", indexes = {
		@Index(name = "crm_company_idx", columnList = "crm_company_id"),
		@Index(name = "crm_lead_idx", columnList = "crm_lead_id"),
		@Index(name = "crm_lead_item_idx", columnList = "crm_lead_item_id")
})
public class CrmCompaniesCrmLead {
	@EmbeddedId
	private CrmCompaniesCrmLeadId id;
	
	@MapsId("crmCompanyId")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "crm_company_id", nullable = false)
	private CrmCompany crmCompany;
	
	@MapsId("crmLeadId")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "crm_lead_id", nullable = false)
	private CrmLead crmLead;
	
	@MapsId("crmLeadItemId")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "crm_lead_item_id", nullable = false)
	private CrmLeadItem crmLeadItem;
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CrmCompaniesCrmLead that = (CrmCompaniesCrmLead) o;
		return id != null && Objects.equals(id, that.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}