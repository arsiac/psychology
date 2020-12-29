package main

import (
	"fmt"
	"github.com/arsiac/psychology/api"
	"github.com/arsiac/psychology/common"
	"github.com/arsiac/psychology/common/log"
	"github.com/arsiac/psychology/constant"
	"github.com/arsiac/psychology/service"
	"github.com/gin-gonic/gin"
)

func main() {
	constant.Init()
	log.Infoln("mysql ->", constant.MysqlUrl)
	service.Mysql = common.GetMysqlConnection(constant.MysqlUrl)
	defer service.Mysql.Close()

	fmt.Printf("--=[%v]=--\n", constant.App)
	gin.SetMode(gin.DebugMode)
	err := api.Router.Run(fmt.Sprintf(":%v", constant.Port))
	if err != nil {
		log.Errorln("app.run", err)
	}
}