package api

import (
	"github.com/arsiac/psychology/constant/api"
	"github.com/gin-gonic/gin"
	"net/http"
)

var Router = gin.Default()

func init()  {
	userApi := Router.Group(api.UserApi)
	{
		userApi.GET("", List)
		userApi.POST("", Save)
	}
}

// response
func Response(code int, msg string, data interface{}) gin.H {
	return gin.H{
		"code": code,
		"msg": msg,
		"data": data,
	}
}

func ResponseSuccess(data interface{}) gin.H {
	return Response(http.StatusOK, "success", data)
}

func ResponseError(code int, msg string) gin.H {
	return Response(code, msg, nil)
}

