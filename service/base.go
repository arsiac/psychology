package service

import (
	"github.com/jinzhu/gorm"
)

var Mysql *gorm.DB


// 获取行数
func SelectCount(model interface{}) (count int) {
	Mysql.Model(model).Count(&count)
	return count
}

