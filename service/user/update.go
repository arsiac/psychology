package user

import (
	"github.com/arsiac/psychology/entity"
	"github.com/arsiac/psychology/service"
)

// 不更新密码
func Update(user *entity.User) bool {
	service.Mysql.Model(user).Updates(entity.User{
		Name: user.Name,
	})
	return true
}

// 修改密码
func UpdatePassword(user *entity.User) bool {
	service.Mysql.Model(user).Updates(entity.User{
		Password: user.Password,
	})
	return true
}
