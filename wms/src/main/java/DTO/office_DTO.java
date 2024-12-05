package DTO;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("office_DTO")
public class office_DTO {
	int oidx, opost;
	String officename, mhp, otel, mname, memail, oroad, oaddress, oview;
	
	//검색어
	String search;
}
