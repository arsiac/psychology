package common

import (
	"fmt"
	"github.com/arsiac/psychology/log"
	_ "github.com/go-sql-driver/mysql"
	"github.com/jinzhu/gorm"
)

type MysqlInfo struct {
	Address string `json:"address"`
	Port int `json:"port"`
	Database string `json:"database"`
	Username string `json:"username"`
	Password string `json:"password"`
	Option string `json:"option"`
}

func NewMysqlInfo(port int, address, database, username, password, option string) *MysqlInfo {
	mysqlInfo := new(MysqlInfo)
	mysqlInfo.Port = port
	mysqlInfo.Address = address
	mysqlInfo.Database = database
	mysqlInfo.Username = username
	mysqlInfo.Password = password
	mysqlInfo.Option = option
	return mysqlInfo
}

func (info *MysqlInfo) String() string {
	return fmt.Sprintf("MysqlInfo{ main: %v:%v/%v?%v, user: %v, passwd: %v }",
		info.Address, info.Port, info.Database, info.Option, info.Username, info.Password)
}

func GetDefaultMysqlSettings() *MysqlInfo {
	return NewMysqlInfo(3306, "127.0.0.1", "psychology", "root", "123456", "charset=utf8")
}

func GenerateMysqlUrl(info *MysqlInfo) string {
	if info == nil {
		info = GetDefaultMysqlSettings()
		log.Infoln("传入数据库信息为空，使用默认信息", info)
	}

	return fmt.Sprintf("%v:%v@tcp(%v:%v)/%v?%v", info.Username, info.Password, info.Address, info.Port, info.Database, info.Option)
}

func GetMysqlConnection(url string) *gorm.DB {
	db, err := gorm.Open("mysql", url)
	if err != nil {
		log.Errorln("打开数据库失败", err)
		return nil
	}
	return db
}
