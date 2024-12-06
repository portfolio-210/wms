package dto;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("config_dto")
public class ConfigDTO {
	
	int midx;
	String mpart, mspot, mname, mjob, mid, mpass, memail, mhp, approve, mdate;
	
	String part1, part2, search;
	
	
	
	

}
