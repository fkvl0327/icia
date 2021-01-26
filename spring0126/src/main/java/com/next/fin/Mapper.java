package com.next.fin;

import org.apache.ibatis.annotations.Select;

public interface Mapper {
	@Select("SELECT SYSDATE FROM DUAL")
	public String getDate();
}
