package DTO;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("memberdto")
public class member_DTO {
	int midx;
	String mpart, mspot, mname, mjob, mid, mpass, memail, mhp, approve, mdate;
}
