package common

import (
	"fmt"
	"github.com/arsiac/psychology/entity"
	"testing"
)

func TestGenerateMysqlUrl(t *testing.T) {
	type args struct {
		info *MysqlInfo
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		// TODO: Add test cases.
		{
			name: "test 1",
			want: "admin:123456@tcp(1.1.1.1:3306)/db",
			args: args{
				info: NewMysqlInfo(3306, "1.1.1.1", "db", "admin", "123456", ""),
			},
		},
		{
			name: "test 1",
			want: "root:123465@tcp(127.0.0.1:3306)/psychology",
			args: args{
				info: GetDefaultMysqlSettings(),
			},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := GenerateMysqlUrl(tt.args.info); got != tt.want {
				t.Errorf("GenerateMysqlUrl() = %v, want %v", got, tt.want)
			}
		})
	}
}


func TestGetMysqlConnection(t *testing.T) {
	url := GenerateMysqlUrl(GetDefaultMysqlSettings())
	t.Log(url)
	connection := GetMysqlConnection(url)
	defer connection.Close()

	var users []entity.User
	err := connection.Select(&users, "select * from user")
	if err != nil {
		t.Fatal("connection failed.", err)
	}

	fmt.Println("Result: ",users)
}
