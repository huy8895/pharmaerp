package DKSPACE.PhamarERP.master_data.entity.csm;

import DKSPACE.PhamarERP.master_data.entity.id.CrmContactsCrmLeadId;
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
@Table(name = "crm_contacts_crm_leads", indexes = {
		@Index(name = "contacts_crm_lead_item_idx", columnList = "crm_lead_item_id"),
		@Index(name = "contacts_crm_lead_idx", columnList = "crm_lead_id"),
		@Index(name = "crm_contact_idx", columnList = "crm_contact_id")
})
public class CrmContactsCrmLead {
	@EmbeddedId
	private CrmContactsCrmLeadId id;
	
	@MapsId("crmContactId")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "crm_contact_id", nullable = false)
	private CrmContact crmContact;
	
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
		CrmContactsCrmLead that = (CrmContactsCrmLead) o;
		return id != null && Objects.equals(id, that.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}