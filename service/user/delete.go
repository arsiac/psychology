package user

import (
	"github.com/arsiac/psychology/entity"
	"github.com/arsiac/psychology/service"
)

func Delete(user *entity.User)  {
	service.Mysql.Delete(user)
}
