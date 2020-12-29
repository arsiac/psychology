package entity

import (
	"fmt"
	"github.com/arsiac/psychology/common"
	"github.com/arsiac/psychology/common/log"
	"github.com/arsiac/psychology/constant"
	"github.com/jinzhu/gorm"
	"strconv"
)

// table user
type User struct {
	BaseModel
	Name string
	Password string
}

type UserVO struct {
	BaseModelVo
	Name string `json:"name"`
	Password string `json:"password"`
	OldPassword string `json:"oldPassword"`
}

// 结构体对应的数据库表名
func (User)TableName() string {
	return "sys_user"
}

// 在插入数据库前生成 id 加密用户密码
func (u *User) BeforeCreate(scope *gorm.Scope) error {
	// 生成 id
	err := scope.SetColumn("id", constant.Snowflake.GetId())
	if err != nil {
		log.Errorln("user.BeforeCreate() -> ", err)
		return err
	}
	// 加密密码
	err = scope.SetColumn("password", common.EncryptPassword(u.Password))
	if err != nil {
		log.Errorln("user.BeforeCreate() -> ", err)
		return err
	}
	return nil
}

func (u *User) BeforeUpdate(scope *gorm.Scope) error {
	// 加密密码
	if u.Password == "" {
		return nil
	}
	err := scope.SetColumn("password", common.EncryptPassword(u.Password))
	if err != nil {
		log.Errorln("user.BeforeCreate() -> ", err)
		return err
	}
	return nil
}

func NewUserVo(user *User) *UserVO {
	userVo := new (UserVO)
	userVo.ID = strconv.FormatInt(user.ID, 10)
	userVo.Name = user.Name
	userVo.Password = user.Password
	userVo.CreatedAt = user.CreatedAt.Format(constant.TimeFormat)
	userVo.UpdatedAt = user.UpdatedAt.Format(constant.TimeFormat)
	return userVo
}

func GetUserFromUserVO(vo *UserVO) *User {
	user := new(User)
	var err error
	user.ID, err = strconv.ParseInt(vo.ID, 10, 64)
	if err != nil {
		log.Errorln("user.GetUserFromUserVO -> ", err)
		return nil
	}
	user.Name = vo.Name
	user.Password = vo.Password
	return user
}

func GetUserVos(users *[]User) []UserVO {
	var userVos []UserVO
	for _, v := range *users {
		userVos = append(userVos, *NewUserVo(&v))
	}
	return userVos
}

func (u *User)String() string {
	return fmt.Sprintf("user{ id: %v, name: %v, password: %v, createAt: %v, updateAt: %v }",
		u.ID, u.Name, u.Password, u.CreatedAt, u.UpdatedAt)
}
