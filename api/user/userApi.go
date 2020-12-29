package user

import (
	"github.com/arsiac/psychology/common"
	"github.com/arsiac/psychology/common/log"
	"github.com/arsiac/psychology/entity"
	"github.com/arsiac/psychology/service"
	userService "github.com/arsiac/psychology/service/user"
	"github.com/gin-gonic/gin"
	"net/http"
	"strconv"
)

// 模糊查询 GET
func List(c *gin.Context) {
	page := entity.GetDefaultPage()

	//获取分页信息
	indexString := c.Query("pageIndex")
	sizeString := c.Query("pageSize")
	log.Debugln("index", indexString, "size", sizeString)
	if indexString != "" {
		indexInt, err := strconv.Atoi(indexString)
		if err != nil {
			log.Errorln("user.List() -> index format error.", err)
		} else {
			page.Index = indexInt
		}
	}

	if sizeString != "" {
		sizeInt, err := strconv.Atoi(sizeString)
		if err != nil {
			log.Errorln("user.List() -> size format error.", err)
		} else {
			page.Size = sizeInt
		}
	}

	page.Total = service.SelectCount(entity.User{})
	users := userService.SelectPage(page)
	// 转为vo返回
	page.List = entity.GetUserVos(&users)
	log.Debugln("user.List -> ", page.String())
	c.JSON(http.StatusOK, common.ResponseSuccess(page))
}

// 根据 id 查询
func Info(c *gin.Context) {
	id := c.Param("id")
	if id == "" {
		log.Errorln("user.Info -> id is empty")
	}

	// 转为long
	longId, err := strconv.ParseInt(id, 10, 64)
	if err != nil {
		log.Errorln("user.Info -> id error", err)
		c.JSON(http.StatusForbidden, common.ResponseError(http.StatusForbidden, "id 错误: " + id))
		return
	}
	user := userService.SelectById(longId)
	if user.ID == 0 {
		log.Errorln("user.Info -> 用户不存在", id)
		c.JSON(http.StatusOK, common.ResponseSuccess(nil))
		return
	}
	c.JSON(http.StatusOK, common.ResponseSuccess(*entity.NewUserVo(&user)))
}

// 添加
func Save(c *gin.Context) {
	var receivedUser entity.User
	err := c.ShouldBindJSON(&receivedUser)
	if err != nil {
		log.Errorln("user.Save -> 接收JSON错误", err)
		return
	}
	// 校验数据
	if receivedUser.Name == "" {
		log.Errorln("user.Save -> 用户名为空")
		 c.JSON(http.StatusForbidden, common.ResponseError(http.StatusForbidden, "用户名为空"))
		return
	}
	if receivedUser.Password == "" {
		log.Errorln("user.Save -> 密码为空")
		c.JSON(http.StatusForbidden, common.ResponseError(http.StatusForbidden, "密码为空"))
		return
	}
	// 检查用户是否重复
	repeat := userService.SelectByName(receivedUser.Name)
	if repeat.ID != 0 {
		log.Errorln("user.Save -> 用户名重复")
		c.JSON(http.StatusForbidden, common.ResponseError(http.StatusForbidden, "用户名重复"))
		return
	}
	if userService.Insert(&receivedUser) {
		c.JSON(http.StatusOK, common.ResponseSuccess(true))
	} else {
		c.JSON(http.StatusInsufficientStorage, common.ResponseError(http.StatusInsufficientStorage, "未知原因导致失败"))
	}
}

// 更新
// 不更新密码
func Update(c *gin.Context) {
	var receivedUser entity.UserVO
	err := c.ShouldBindJSON(&receivedUser)
	if err != nil {
		c.JSON(http.StatusForbidden, common.ResponseError(http.StatusForbidden, "JSON 错误"))
		return
	}

	if userService.Update(entity.GetUserFromUserVO(&receivedUser)) {
		c.JSON(http.StatusOK, common.ResponseSuccess(true))
	} else {
		c.JSON(http.StatusInsufficientStorage, common.ResponseError(http.StatusInsufficientStorage, "未知原因导致失败"))
	}
}

// 更改密码
func ChangePassword(c *gin.Context) {
	var receivedUser entity.UserVO
	err := c.ShouldBindJSON(&receivedUser)
	if err != nil {
		c.JSON(http.StatusForbidden, common.ResponseError(http.StatusForbidden, "JSON 错误"))
		return
	}

	// 检查数据
	if receivedUser.ID == "" {
		c.JSON(http.StatusForbidden, common.ResponseError(http.StatusForbidden, "未指定用户"))
		return
	}
	if receivedUser.OldPassword == "" {
		c.JSON(http.StatusForbidden, common.ResponseError(http.StatusForbidden, "原密码为空"))
		return
	}
	if receivedUser.Password == "" {
		c.JSON(http.StatusForbidden, common.ResponseError(http.StatusForbidden, "新密码为空"))
		return
	}

	// 用户是否存在
	user := entity.GetUserFromUserVO(&receivedUser)
	existUser := userService.SelectById(user.ID)
	if existUser.ID == 0 {
		c.JSON(http.StatusForbidden, common.ResponseError(http.StatusForbidden, "用户不存在"))
		return
	}

	// 更新数据
	userService.UpdatePassword(user)
}