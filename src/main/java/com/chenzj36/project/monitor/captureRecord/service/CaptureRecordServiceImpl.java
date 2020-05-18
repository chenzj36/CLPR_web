package com.chenzj36.project.monitor.captureRecord.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chenzj36.project.monitor.captureRecord.mapper.CaptureRecordMapper;
import com.chenzj36.project.monitor.captureRecord.domain.CaptureRecord;
import com.chenzj36.project.monitor.captureRecord.service.ICaptureRecordService;
import com.chenzj36.common.utils.text.Convert;

/**
 * 识别记录 服务层实现
 * 
 * @author chenzj36
 * @date 2020-04-29
 */
@Service
public class CaptureRecordServiceImpl implements ICaptureRecordService 
{
	@Autowired
	private CaptureRecordMapper captureRecordMapper;

	/**
     * 查询识别记录信息
     * 
     * @param id 识别记录ID
     * @return 识别记录信息
     */
    @Override
	public CaptureRecord selectCaptureRecordById(Integer id)
	{
	    return captureRecordMapper.selectCaptureRecordById(id);
	}
	
	/**
     * 查询识别记录列表
     * 
     * @param captureRecord 识别记录信息
     * @return 识别记录集合
     */
	@Override
	public List<CaptureRecord> selectCaptureRecordList(CaptureRecord captureRecord)
	{
	    return captureRecordMapper.selectCaptureRecordList(captureRecord);
	}
	
    /**
     * 新增识别记录
     * 
     * @param captureRecord 识别记录信息
     * @return 结果
     */
	@Override
	public int insertCaptureRecord(CaptureRecord captureRecord)
	{
	    return captureRecordMapper.insertCaptureRecord(captureRecord);
	}
	
	/**
     * 修改识别记录
     * 
     * @param captureRecord 识别记录信息
     * @return 结果
     */
	@Override
	public int updateCaptureRecord(CaptureRecord captureRecord)
	{
	    return captureRecordMapper.updateCaptureRecord(captureRecord);
	}

	/**
     * 删除识别记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCaptureRecordByIds(String ids)
	{
		return captureRecordMapper.deleteCaptureRecordByIds(Convert.toStrArray(ids));
	}
	
}
