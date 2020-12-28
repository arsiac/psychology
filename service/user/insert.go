package user

import (
	"github.com/arsiac/psychology/entity"
	"github.com/arsiac/psychology/service"
)

const (
	insertOne = "insert into `user`(`id`, `name`, `password`, `create_time`) values (?, ?, ?, ?)"
)

func Insert(user *entity.User) bool {
	service.Mysql.Create(user)
	return true
}
