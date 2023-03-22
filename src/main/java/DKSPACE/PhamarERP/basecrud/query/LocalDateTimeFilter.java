package DKSPACE.PhamarERP.basecrud.query;

import io.github.jhipster.service.filter.RangeFilter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDateTime;
import java.util.List;

public class LocalDateTimeFilter extends RangeFilter<LocalDateTime> {
	private static final long serialVersionUID = 1L;
	
	public LocalDateTimeFilter() {
	}
	
	public LocalDateTimeFilter(final LocalDateTimeFilter filter) {
		super(filter);
	}
 
	public LocalDateTimeFilter copy() {
		return new LocalDateTimeFilter(this);
	}
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public LocalDateTimeFilter setEquals(LocalDateTime equals) {
		super.setEquals(equals);
		return this;
	}
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public LocalDateTimeFilter setNotEquals(LocalDateTime equals) {
		super.setNotEquals(equals);
		return this;
	}
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public LocalDateTimeFilter setGreaterThan(LocalDateTime equals) {
		super.setGreaterThan(equals);
		return this;
	}
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public LocalDateTimeFilter setGreaterThanOrEqual(LocalDateTime equals) {
		super.setGreaterThanOrEqual(equals);
		return this;
	}
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public LocalDateTimeFilter setLessThan(LocalDateTime equals) {
		super.setLessThan(equals);
		return this;
	}
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public LocalDateTimeFilter setLessThanOrEqual(LocalDateTime equals) {
		super.setLessThanOrEqual(equals);
		return this;
	}
	
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public LocalDateTimeFilter setIn(List<LocalDateTime> in) {
		super.setIn(in);
		return this;
	}
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public LocalDateTimeFilter setNotIn(List<LocalDateTime> notIn) {
		super.setNotIn(notIn);
		return this;
	}
}