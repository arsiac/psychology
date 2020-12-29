package user

import (
	"github.com/arsiac/psychology/entity"
	"github.com/arsiac/psychology/service"
)

// 分页查询
func SelectPage(page *entity.Page) (users []entity.User) {
	start := (page.Index - 1) * page.Size
	service.Mysql.Offset(start).Limit(page.Size).Find(&users)
	return
}

// 根据 id 查询
func SelectById(id int64) (user entity.User) {
	service.Mysql.Find(&user, "id = ?", id)
	return
}

// 根据 name 查询
func SelectByName(name string) (user entity.User)  {
	service.Mysql.Find(&user, "name = ?", name)
	return
}
