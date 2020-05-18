package com.chenzj36.project.monitor.captureRecord.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.chenzj36.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 识别记录表 capture_record
 * 
 * @author chenzj36
 * @date 2020-04-29
 */
public class CaptureRecord extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 记录id */
	private Integer id;
	/** 相机id */
	private Integer capId;
	/** 记录时间 */
	private Date recTime;
	/** 图像地址 */
	private String imgUrl;
	/** 车牌号 */
	private String plateNum;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setCapId(Integer capId) 
	{
		this.capId = capId;
	}

	public Integer getCapId() 
	{
		return capId;
	}
	public void setRecTime(Date recTime) 
	{
		this.recTime = recTime;
	}

	public Date getRecTime() 
	{
		return recTime;
	}
	public void setImgUrl(String imgUrl) 
	{
		this.imgUrl = imgUrl;
	}

	public String getImgUrl() 
	{
		return imgUrl;
	}
	public void setPlateNum(String plateNum) 
	{
		this.plateNum = plateNum;
	}

	public String getPlateNum() 
	{
		return plateNum;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("capId", getCapId())
            .append("recTime", getRecTime())
            .append("imgUrl", getImgUrl())
            .append("plateNum", getPlateNum())
            .toString();
    }
}
