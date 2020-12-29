package common

import (
	"github.com/gin-gonic/gin"
	"net/http"
)

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

