package wms.dto;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("OfficeDTO")
public class OfficeDTO {
	int oidx, opost;
	String officename, mhp, otel, mname, memail, oroad, oaddress, oview;
	
	//검색어
	String search;
}