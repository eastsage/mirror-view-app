package com.mirrorview.domain.essay.service;

import java.util.List;

import com.mirrorview.domain.essay.dto.EssayDetailDto;

public interface EssayDetailService {
	List<EssayDetailDto> findEssayByEssayId(Long essayId);
}
