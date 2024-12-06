package wms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConfigMapper {

	List<dto.ConfigDTO> all(Map<String, String> keycode);
	List<dto.ConfigDTO> searchall();
	
}
