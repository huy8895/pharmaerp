package DKSPACE.PhamarERP.master_data.entity.id;

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
public class CrmContactsCrmLeadId implements Serializable {
	private static final long serialVersionUID = -1549716248212769479L;
	@NotNull
	@Column(name = "crm_contact_id", nullable = false)
	private Long crmContactId;
	
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
		CrmContactsCrmLeadId entity = (CrmContactsCrmLeadId) o;
		return Objects.equals(this.crmLeadItemId, entity.crmLeadItemId) &&
				Objects.equals(this.crmLeadId, entity.crmLeadId) &&
				Objects.equals(this.crmContactId, entity.crmContactId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(crmLeadItemId, crmLeadId, crmContactId);
	}
	
}