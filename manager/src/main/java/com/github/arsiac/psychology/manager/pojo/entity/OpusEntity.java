package com.github.arsiac.psychology.manager.pojo.entity;


import java.util.Date;

/**
 * <p>著作</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021-03-12 00:14:16
 */
public class OpusEntity {

	/**
	 * 著作id
	 */
	private Long id;

	/**
	 * 著作名称
	 */
	private String name;

	/**
	 * 作者
	 */
	private Long authorId;

	/**
	 * 成果类型
	 */
	private Long achievementTypeId;

	/**
	 * 出版社
	 */
	private String publishingHouse;

	/**
	 * 出版时间
	 */
	private Date publishDate;

	/**
	 * ISBN
	 */
	private String isbn;

	/**
	 * 状态
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

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAchievementTypeId(Long achievementTypeId) {
		this.achievementTypeId = achievementTypeId;
	}

	public Long getAchievementTypeId() {
		return achievementTypeId;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
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

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	@Override
	public String toString() {
		return "OpusEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", authorId=" + authorId +
				", achievementTypeId=" + achievementTypeId +
				", publishingHouse='" + publishingHouse + '\'' +
				", publishDate=" + publishDate +
				", isbn='" + isbn + '\'' +
				", status=" + status +
				", returnMessage='" + returnMessage + '\'' +
				", createBy=" + createBy +
				", createTime=" + createTime +
				", updateBy=" + updateBy +
				", updateTime=" + updateTime +
				", version=" + version +
				'}';
	}
}
