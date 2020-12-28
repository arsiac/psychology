package api

import (
	"github.com/arsiac/psychology/entity"
	"github.com/arsiac/psychology/log"
	userService "github.com/arsiac/psychology/service/user"
	"github.com/gin-gonic/gin"
	"net/http"
	"strconv"
)

// 模糊查询 GET
func List(c *gin.Context)  {
	page := entity.GetDefaultPage()

	//获取分页信息
	indexString := c.Param("pageIndex")
	sizeString := c.Param("pageSize")

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

	users := userService.SelectPage(page)
	// 转为vo返回
	c.JSON(http.StatusOK, ResponseSuccess(entity.GetUserVos(&users)))
}

// 添加
func Save(c *gin.Context) {
	name := c.PostForm("name")
	password := c.PostForm("password")
	if name == "" {
		 c.JSON(http.StatusForbidden, ResponseError(http.StatusForbidden, "用户名为空"))
		return
	}
	if password == "" {
		c.JSON(http.StatusForbidden, ResponseError(http.StatusForbidden, "密码为空"))
		return
	}
	user := entity.CreateUser(name, password)
	log.Infoln("user.save() ->", user.String())
	if userService.Insert(user) {
		c.JSON(http.StatusOK, ResponseSuccess(true))
	} else {
		c.JSON(http.StatusInsufficientStorage, ResponseError(http.StatusInsufficientStorage, "未知原因导致插入失败"))
	}
}