package com.chenzj36.project.monitor.captureRecord.mapper;

import com.chenzj36.project.monitor.captureRecord.domain.CaptureRecord;
import java.util.List;	

/**
 * 识别记录 数据层
 * 
 * @author chenzj36
 * @date 2020-04-29
 */
public interface CaptureRecordMapper 
{
	/**
     * 查询识别记录信息
     * 
     * @param id 识别记录ID
     * @return 识别记录信息
     */
	public CaptureRecord selectCaptureRecordById(Integer id);
	
	/**
     * 查询识别记录列表
     * 
     * @param captureRecord 识别记录信息
     * @return 识别记录集合
     */
	public List<CaptureRecord> selectCaptureRecordList(CaptureRecord captureRecord);
	
	/**
     * 新增识别记录
     * 
     * @param captureRecord 识别记录信息
     * @return 结果
     */
	public int insertCaptureRecord(CaptureRecord captureRecord);
	
	/**
     * 修改识别记录
     * 
     * @param captureRecord 识别记录信息
     * @return 结果
     */
	public int updateCaptureRecord(CaptureRecord captureRecord);
	
	/**
     * 删除识别记录
     * 
     * @param id 识别记录ID
     * @return 结果
     */
	public int deleteCaptureRecordById(Integer id);
	
	/**
     * 批量删除识别记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCaptureRecordByIds(String[] ids);
	
}