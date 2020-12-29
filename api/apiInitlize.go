package api

import (
	"github.com/arsiac/psychology/api/user"
	"github.com/gin-gonic/gin"
)

const (
	userBaseUrl = "/api/user"
)

var Router = gin.Default()

func init()  {
	userApi := Router.Group(userBaseUrl)
	{
		userApi.GET("", user.List)
		userApi.GET("/:id", user.Info)

		userApi.POST("", user.Save)
		userApi.PUT("", user.Update)
	}
}
