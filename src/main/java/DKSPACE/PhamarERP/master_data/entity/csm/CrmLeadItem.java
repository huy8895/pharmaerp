package DKSPACE.PhamarERP.master_data.entity.csm;

import DKSPACE.PhamarERP.basecrud.BaseCRUDEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "crm_lead_items", indexes = {
		@Index(name = "crm_lead_items_crm_lead_id_idx", columnList = "crm_lead_id")
})
public class CrmLeadItem extends BaseCRUDEntity {
	
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "crm_lead_id", nullable = false)
	private CrmLead crmLead;
	
	@Size(max = 100)
	@NotNull
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Size(max = 10)
	@Column(name = "color", length = 10)
	private String color;
	
	@Column(name = "describe", length = Integer.MAX_VALUE)
	private String describe;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CrmLeadItem that = (CrmLeadItem) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}