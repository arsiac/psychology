package top.arsiac.psychology.user.centre.pojo.entity;

import java.util.Date;

/**
 * <p>角色对应权力表</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/31
 */
public class RolePowerEntity {
	/**
	 * 角色权力id
	 * */
	private Long id;

	/**
	 * 角色id
	 */
	private Long roleId;

	/**
	 * 权力id
	 */
	private Long powerId;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPowerId() {
		return powerId;
	}

	public void setPowerId(Long powerId) {
		this.powerId = powerId;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "RolePowerEntity{" +
				"id=" + id +
				", roleId=" + roleId +
				", powerId=" + powerId +
				", createBy=" + createBy +
				", createTime=" + createTime +
				", updateBy=" + updateBy +
				", updateTime=" + updateTime +
				", version=" + version +
				'}';
	}
}
