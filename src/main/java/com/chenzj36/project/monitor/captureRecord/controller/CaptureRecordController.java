package com.chenzj36.project.monitor.captureRecord.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chenzj36.framework.aspectj.lang.annotation.Log;
import com.chenzj36.framework.aspectj.lang.enums.BusinessType;
import com.chenzj36.project.monitor.captureRecord.domain.CaptureRecord;
import com.chenzj36.project.monitor.captureRecord.service.ICaptureRecordService;
import com.chenzj36.framework.web.controller.BaseController;
import com.chenzj36.framework.web.page.TableDataInfo;
import com.chenzj36.framework.web.domain.AjaxResult;
import com.chenzj36.common.utils.poi.ExcelUtil;

/**
 * 识别记录信息操作处理
 * 
 * @author chenzj36
 * @date 2020-04-29
 */
@Controller
@RequestMapping("/monitor/captureRecord")
public class CaptureRecordController extends BaseController
{
    private String prefix = "monitor/captureRecord";
	
	@Autowired
	private ICaptureRecordService captureRecordService;
	
	@RequiresPermissions("monitor:captureRecord:view")
	@GetMapping()
	public String captureRecord()
	{
	    return prefix + "/captureRecord";
	}
	
	/**
	 * 查询识别记录列表
	 */
	@RequiresPermissions("monitor:captureRecord:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CaptureRecord captureRecord)
	{
		startPage();
        List<CaptureRecord> list = captureRecordService.selectCaptureRecordList(captureRecord);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出识别记录列表
	 */
	@RequiresPermissions("monitor:captureRecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CaptureRecord captureRecord)
    {
    	List<CaptureRecord> list = captureRecordService.selectCaptureRecordList(captureRecord);
        ExcelUtil<CaptureRecord> util = new ExcelUtil<CaptureRecord>(CaptureRecord.class);
        return util.exportExcel(list, "captureRecord");
    }
	
	/**
	 * 新增识别记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存识别记录
	 */
	@RequiresPermissions("monitor:captureRecord:add")
	@Log(title = "识别记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CaptureRecord captureRecord)
	{		
		return toAjax(captureRecordService.insertCaptureRecord(captureRecord));
	}

	/**
	 * 修改识别记录
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		CaptureRecord captureRecord = captureRecordService.selectCaptureRecordById(id);
		mmap.put("captureRecord", captureRecord);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存识别记录
	 */
	@RequiresPermissions("monitor:captureRecord:edit")
	@Log(title = "识别记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CaptureRecord captureRecord)
	{		
		return toAjax(captureRecordService.updateCaptureRecord(captureRecord));
	}
	
	/**
	 * 删除识别记录
	 */
	@RequiresPermissions("monitor:captureRecord:remove")
	@Log(title = "识别记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(captureRecordService.deleteCaptureRecordByIds(ids));
	}
	
}
