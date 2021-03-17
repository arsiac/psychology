package com.github.arsiac.psychology.manager.pojo.entity;


import java.util.Date;

/**
 * <p></p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:15
 */
public class PaperEntity {

	/**
	 * 论文id
	 */
	private Long id;

	/**
	 * 论文名称
	 */
	private String name;

	/**
	 * 第一作者
	 */
	private Long firstAuthorId;

	/**
	 * 通讯作者
	 */
	private Long correspondingAuthorId;

	/**
	 * 刊物
	 */
	private String publication;

	/**
	 * 发表时间
	 */
	private Date publishDate;

	/**
	 * 发表年份及卷（期）数
	 */
	private String publicationVersion;

	/**
	 * 论文级别
	 */
	private Long paperLevelId;

	/**
	 * 状态(0未提交, 1已提交, 2审核通过, 3退回修改)
	 */
	private Integer status;

	/**
	 * 退回修改建议
	 */
	private String returnMessage;

	/**
	 * 创建者
	 */
	private Long createBy;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新者
	 */
	private Long updateBy;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 版本
	 */
	private Integer version;


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setFirstAuthorId(Long firstAuthorId) {
		this.firstAuthorId = firstAuthorId;
	}

	public Long getFirstAuthorId() {
		return firstAuthorId;
	}

	public void setCorrespondingAuthorId(Long correspondingAuthorId) {
		this.correspondingAuthorId = correspondingAuthorId;
	}

	public Long getCorrespondingAuthorId() {
		return correspondingAuthorId;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublicationVersion(String publicationVersion) {
		this.publicationVersion = publicationVersion;
	}

	public String getPublicationVersion() {
		return publicationVersion;
	}

	public void setPaperLevelId(Long paperLevelId) {
		this.paperLevelId = paperLevelId;
	}

	public Long getPaperLevelId() {
		return paperLevelId;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersion() {
		return version;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}
}
