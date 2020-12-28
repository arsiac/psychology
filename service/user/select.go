package user

import (
	"github.com/arsiac/psychology/entity"
	"github.com/arsiac/psychology/log"
	"github.com/arsiac/psychology/service"
)

const (
	selectCount  = "select count(1) as count from sys_user"
	selectPage = "select * from sys_user limit ?,?"
	selectById = "select * from sys_user where id = ?"
)

// 获取行数
func SelectCount(interface{}) (count int) {
	service.Mysql.Model(&entity.User{}).Count(&count)
	return count
}

// 分页查询
func SelectPage(page *entity.Page) (users []entity.User) {
	start := (page.Index - 1) * page.Size
	end := page.Index * page.Size
	service.Mysql.Offset(start).Limit(end).Find(&users)
	log.Debugln("user.SelectPage() ->", users)
	return
}

// 根据 id 查询
func SelectById(id int64) (user entity.User) {
	err := service.Mysql.Select(&user, selectById, id)
	if err != nil {
		log.Errorln("user.SelectById() ->", err)
		return
	}
	log.Debugln("user.SelectById() ->", user)
	return
}
