package entity

import (
	"fmt"
	"github.com/arsiac/psychology/common"
	"github.com/arsiac/psychology/constant"
	"github.com/arsiac/psychology/log"
	"github.com/jinzhu/gorm"
	"strconv"
	"time"
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
	return nil
}

func CreateUser(name, password string) *User {
	user := new(User)
	user.Name = name
	user.Password = password
	return user
}

func NewUser(id int64, createAt, updateAt time.Time, name, password string) *User {
	user := new(User)
	user.ID = id
	user.Name = name
	user.Password = password
	user.CreatedAt = createAt
	user.UpdatedAt = updateAt
	user.DeletedAt = nil
	return user
}

func NewUserVo(user *User) *UserVO {
	userVo := new (UserVO)
	userVo.ID = strconv.FormatInt(user.ID, 10)
	userVo.Name = user.Name
	//userVo.CreatedAt = strconv.FormatInt(user.CreatedAt.Unix(), 10)
	//userVo.UpdatedAt = strconv.FormatInt(user.UpdatedAt.Unix(), 10)
	userVo.CreatedAt = user.CreatedAt.Format(constant.TimeFormat)
	userVo.UpdatedAt = user.UpdatedAt.Format(constant.TimeFormat)
	return userVo
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
